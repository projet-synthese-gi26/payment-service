package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Component
public class RechargeHandler extends AbstractTransactionHandler {

    public RechargeHandler(WalletRepositoryPort walletRepository, TransactionRepositoryPort transactionRepository) {
        super(walletRepository, transactionRepository);
    }

    @Override
    protected Mono<Wallet> validate(Wallet wallet, BigDecimal amount) {
        // Validation simple : le montant doit être positif
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new IllegalArgumentException("Le montant de la recharge doit être positif"));
        }
        // On pourrait ajouter ici des règles : plafond max du wallet, statut du wallet actif, etc.
        return Mono.just(wallet);
    }

    @Override
    protected Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount) {
        // LOGIQUE MÉTIER : On AJOUTE le montant au solde
        BigDecimal newBalance = wallet.balance().add(amount);
        return Mono.just(wallet.withBalance(newBalance));
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.RECHARGE;
    }
}