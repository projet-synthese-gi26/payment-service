package com.yowyob.template.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Transaction(UUID id, UUID walletId, BigDecimal amount, String type, String status) {}

