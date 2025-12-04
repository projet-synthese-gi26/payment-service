package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;

@Component
public class PaymentHandler extends AbstractTransactionHandler {

    public PaymentHandler(WalletRepositoryPort walletRepo, TransactionRepositoryPort txRepo) {
        super(walletRepo, txRepo);
    }

    @Override
    protected Mono<Wallet> validate(Wallet wallet, BigDecimal amount) {
        // Sécurité : On ne peut pas "payer" un montant négatif ou nul
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new IllegalArgumentException("Le montant du paiement doit être positif"));
        }

        // Sécurité : Solde insuffisant
        if (wallet.balance().compareTo(amount) < 0) {
            return Mono.error(new RuntimeException("Solde insuffisant pour le paiement"));
        }
        return Mono.just(wallet);
    }

    @Override
    protected Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount) {
        return Mono.just(wallet.withBalance(wallet.balance().subtract(amount)));
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.PAYMENT;
    }
}