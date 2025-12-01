package com.yowyob.template.infrastructure.adapters.outbound.cache;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletCachePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RedisAdapter implements WalletCachePort {
    private final ReactiveRedisTemplate<String, Object> redisTemplate;

    @Override
    public Mono<Boolean> saveInCache(Wallet wallet) {
        return redisTemplate.opsForValue()
                .set("wallet:" + wallet.id(), wallet, Duration.ofMinutes(10));
    }
}