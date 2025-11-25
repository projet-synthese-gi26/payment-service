package com.yowyob.template.domain.ports.out;

import com.yowyob.template.domain.model.Transaction;
import reactor.core.publisher.Mono;

public interface TransactionRepositoryPort {
    Mono<Transaction> save(Transaction transaction);
}
