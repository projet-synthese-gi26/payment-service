package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Wallet;
import reactor.core.publisher.Mono;

public interface WalletCachePort {
    Mono<Boolean> saveInCache(Wallet wallet);
}
