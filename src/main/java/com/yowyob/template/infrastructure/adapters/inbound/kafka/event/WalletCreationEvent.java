package com.yowyob.template.infrastructure.adapters.inbound.kafka.event;

import java.util.UUID;

public record WalletCreationEvent(UUID ownerId, String ownerName) {
}
