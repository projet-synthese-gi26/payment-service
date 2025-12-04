package com.yowyob.template.application.service;

import com.yowyob.template.domain.exception.TransactionNotFoundException;
import com.yowyob.template.domain.exception.WalletNotFoundException;
import com.yowyob.template.domain.handler.AbstractTransactionHandler;
import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.TransactionUseCase;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TransactionService implements TransactionUseCase {

    private final Map<TransactionType, AbstractTransactionHandler> handlersMap;
    private final TransactionRepositoryPort transactionRepositoryPort;
    private final WalletRepositoryPort walletRepositoryPort;

    public TransactionService(List<AbstractTransactionHandler> handlers, TransactionRepositoryPort transactionRepositoryPort, WalletRepositoryPort walletRepositoryPort) {
        this.handlersMap = handlers.stream()
                .collect(Collectors.toMap(AbstractTransactionHandler::getTransactionType, Function.identity()));
        this.transactionRepositoryPort = transactionRepositoryPort;
        this.walletRepositoryPort = walletRepositoryPort;
    }


    @Override
    public Mono<Transaction> createTransaction(Transaction transaction) {
        AbstractTransactionHandler handler = handlersMap.get(transaction.type());
        if (handler == null) {
            return Mono.error(new IllegalArgumentException("Type de transaction inconnu : " + transaction.type()));
        }
        return handler.process(transaction.walletId(), transaction.amount());
    }

    @Override
    public Mono<Transaction> getTransactionById(UUID id) {
        return transactionRepositoryPort.getTransactionById(id)
                .switchIfEmpty(Mono.error(new TransactionNotFoundException("Transaction not found")));
    }

    @Override
    public Flux<Transaction> getTransactionsByWalletId(UUID walletId) {
        return walletRepositoryPort.findById(walletId)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Not found")))
                .flatMapMany(wallet -> transactionRepositoryPort.getTransactionsByWalletId(walletId));
    }
}
