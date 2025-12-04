package com.yowyob.template.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public record Wallet(UUID id, UUID ownerId, String ownerName, BigDecimal balance) {
    // Méthode helper pour l'immutabilité
    public Wallet withBalance(BigDecimal newBalance) {
        return new Wallet(id, ownerId, ownerName, newBalance);
    }
}
