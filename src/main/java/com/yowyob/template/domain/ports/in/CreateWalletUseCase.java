package com.yowyob.template.domain.ports.in;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Mono;

public interface CreateWalletUseCase {
    Mono<Wallet> createWallet(Wallet wallet);
}
