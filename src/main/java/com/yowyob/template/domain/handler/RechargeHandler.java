package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
public class RechargeHandler extends AbstractTransactionHandler{

    public RechargeHandler(WalletRepositoryPort walletRepository, TransactionRepositoryPort transactionRepository) {
        super(walletRepository, transactionRepository);
    }

    @Override
    protected Mono<Wallet> validate(Wallet wallet, BigDecimal amount) {
        return null;
    }

    @Override
    protected Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount) {
        return null;
    }
}
