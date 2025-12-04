package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record WalletResponse(UUID id, UUID ownerId, String ownerName, BigDecimal balance) {
}
