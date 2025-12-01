package com.yowyob.template.infrastructure.adapters.outbound.persistence;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.ports.out.TransactionRepositoryPort;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.repository.TransactionR2dbcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

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
                transaction.type(),
                transaction.status()
        );

        // 2. Save & Map Entity -> Domain
        return repository.save(entity)
                .map(saved -> new Transaction(
                        saved.getId(),
                        saved.getWalletId(),
                        saved.getAmount(),
                        saved.getType(),
                        saved.getStatus()
                ));
    }
}
