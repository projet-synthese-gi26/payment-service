package com.yowyob.template.infrastructure.adapters.outbound.persistence;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.repository.WalletR2dbcRepository;

import com.yowyob.template.infrastructure.mappers.WalletMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class PostgresWalletAdapter implements WalletRepositoryPort {

    private final WalletR2dbcRepository repository;
    private final WalletMapper mapper;


    @Override
    public Mono<Wallet> findById(UUID id) {
        return null;
    }

    @Override
    public Mono<Wallet> save(Wallet wallet) {
        return repository.save(mapper.toEntity(wallet))
                .map(mapper::toDomain);
    }
}
