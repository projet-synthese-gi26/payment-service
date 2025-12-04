package com.yowyob.template.domain.ports.in;

import com.yowyob.template.domain.model.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface TransactionUseCase {
    Mono<Transaction> createTransaction(Transaction transaction);
    Mono<Transaction> getTransactionById(UUID id);
    Flux<Transaction> getTransactionsByWalletId(UUID walletId);
}
