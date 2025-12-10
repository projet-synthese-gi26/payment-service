package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionResponse(UUID id, UUID walletId, BigDecimal amount, TransactionType type, TransactionStatus status) {
}
