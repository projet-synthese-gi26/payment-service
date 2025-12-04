package com.yowyob.template.infrastructure.adapters.outbound.persistence;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.repository.TransactionR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostgresTransactionAdapter implements TransactionRepositoryPort {

    private final TransactionR2dbcRepository repository;

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        // 1. Map Domain -> Entity
        TransactionEntity entity = new TransactionEntity(
                transaction.id(),
                transaction.walletId(),
                transaction.amount(),
                transaction.type().name(),
                transaction.status().name()
        );

        // 2. Save & Map Entity -> Domain
        return repository.save(entity)
                .map(this::mapToDomain);
    }

    @Override
    public Mono<Transaction> getTransactionById(UUID id) {
        return repository.findById(id)
                .map(this::mapToDomain);
    }

    @Override
    public Flux<Transaction> getTransactionsByWalletId(UUID walletId) {
        return repository.findAllByWalletId(walletId) // Retourne Flux<TransactionEntity>
                .map(this::mapToDomain);              // Convertit en Flux<Transaction>
    }

    // Méthode utilitaire pour faire la conversion proprement
    private Transaction mapToDomain(TransactionEntity entity) {
        return new Transaction(
                entity.getId(),
                entity.getWalletId(),
                entity.getAmount(),
                // Attention à la conversion String -> Enum ici
                TransactionType.valueOf(entity.getType()),
                TransactionStatus.valueOf(entity.getStatus())
        );
    }
}
