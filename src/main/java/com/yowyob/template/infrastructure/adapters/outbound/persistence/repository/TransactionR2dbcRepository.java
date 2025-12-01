package com.yowyob.template.infrastructure.adapters.outbound.persistence.repository;

import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import java.util.UUID;

public interface TransactionR2dbcRepository extends R2dbcRepository<TransactionEntity, UUID> {
}