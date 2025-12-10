package com.yowyob.template.domain.handler;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class AbstractTransactionHandler {

    protected final WalletRepositoryPort walletRepository;
    protected final TransactionRepositoryPort transactionRepository;

    public abstract TransactionType getTransactionType();

    // LE TEMPLATE METHOD (Orchestration Reactive)
    public Mono<Transaction> process(UUID walletId, BigDecimal amount) {
        TransactionType type = getTransactionType();
        return walletRepository.findById(walletId)
                .switchIfEmpty(Mono.error(new RuntimeException("Wallet not found")))
                .flatMap(wallet -> validate(wallet, amount)) // Etape 1 : Validation
                .flatMap(wallet -> applyBalance(wallet, amount)) // Etape 2 : Calcul nouveau solde
                .flatMap(walletRepository::updateWallet)
                .flatMap(savedWallet -> createTransaction(savedWallet, amount, type)) // Etape 4 : Créer objet Transaction
                .flatMap(transactionRepository::save) // Etape 5 : Sauvegarder historique
                .doOnSuccess(this::publishEvent); // Etape 6 : Side effect (Event)
    }

    // Méthodes abstraites à implémenter par les enfants
    protected abstract Mono<Wallet> validate(Wallet wallet, BigDecimal amount);
    protected abstract Mono<Wallet> applyBalance(Wallet wallet, BigDecimal amount);

    // Méthode commune
    private Mono<Transaction> createTransaction(Wallet wallet, BigDecimal amount, TransactionType type) {
        return Mono.just(new Transaction(null, wallet.id(), amount, type, TransactionStatus.COMPLETED));
    }

    // Méthode commune (peut être override ou déléguer à un port)
    protected void publishEvent(Transaction tx) {
        // Ici tu appelleras ton KafkaPort si besoin
        System.out.println("EVENT PUBLISHED: " + tx);
    }
}