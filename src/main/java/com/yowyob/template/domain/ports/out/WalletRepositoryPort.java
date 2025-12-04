package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface WalletRepositoryPort {
    Mono<Wallet> findById(UUID id);
    Mono<Wallet> save(Wallet wallet);
    Mono<Wallet> findByOwnerId(UUID ownerId);
    Flux<Wallet> findAllWallets();
    Mono<Void> deleteById(UUID id);
    Mono<Wallet> updateWallet(Wallet wallet);
}
