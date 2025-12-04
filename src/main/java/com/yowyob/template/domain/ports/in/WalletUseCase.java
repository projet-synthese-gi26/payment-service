package com.yowyob.template.domain.ports.in;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface WalletUseCase {
    Mono<Wallet> createWallet(Wallet wallet);
    Mono<Wallet> getWalletByOwnerId(UUID ownerId);
    Mono<Wallet> updateWallet(Wallet wallet);
    Mono<Void> deleteWallet(UUID id);
    Mono<Wallet> getWalletById(UUID id);
    Flux<Wallet> getAllWallets();
}
