package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface WalletRepositoryPort {
    Mono<Wallet> findById(UUID id);
    Mono<Wallet> save(Wallet wallet);
}
