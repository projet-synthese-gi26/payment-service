package com.yowyob.template.infrastructure.adapters.outbound.persistence.repository;

import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.WalletEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WalletR2dbcRepository extends R2dbcRepository<WalletEntity, UUID> {
    Mono<WalletEntity> findByOwnerId(UUID ownerId);
}
