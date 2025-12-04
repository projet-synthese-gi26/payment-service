package com.yowyob.template.infrastructure.adapters.outbound.persistence;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.WalletEntity;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.repository.WalletR2dbcRepository;

import com.yowyob.template.infrastructure.mappers.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostgresWalletAdapter implements WalletRepositoryPort {

    private final WalletR2dbcRepository repository;
    private final WalletMapper mapper;


    @Override
    public Mono<Wallet> findById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain); // Convertit l'Entity en Domain si trouvé
    }

    @Override
    public Mono<Wallet> save(Wallet wallet) {
        WalletEntity entity = mapper.toEntity(wallet);
        entity.setNew(true);

        return repository.save(entity)
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Wallet> findByOwnerId(UUID ownerId) {
        return repository.findByOwnerId(ownerId)
                .map(mapper::toDomain); // Convertit l'Entity en Domain si trouvé
    }

    @Override
    public Flux<Wallet> findAllWallets() {
        return repository.findAll()
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(UUID id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<Wallet> updateWallet(Wallet wallet) {
        return repository.findById(wallet.id())

                .switchIfEmpty(Mono.error(new RuntimeException("Wallet not found for update")))

                .map(entity -> {
                    entity.setOwnerId(wallet.ownerId());
                    entity.setBalance(wallet.balance());
                    return entity;
                })

                .flatMap(repository::save)

                .map(mapper::toDomain);
    }
}
