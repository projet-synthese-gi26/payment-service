package com.yowyob.template.infrastructure.adapters.inbound.kafka.event;

import java.math.BigDecimal;
import java.util.UUID;

// Event reçu : "Ce wallet a fait un mouvement de 'baseAmount', prélevez la com !"
public record PaymentCommissionEvent(UUID ownerId, BigDecimal baseAmount) {
}
