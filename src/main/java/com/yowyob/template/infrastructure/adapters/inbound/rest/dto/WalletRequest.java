package com.yowyob.template.infrastructure.adapters.inbound.rest.dto;

import java.util.UUID;

public record WalletRequest (UUID ownerId, String ownerName) {}
