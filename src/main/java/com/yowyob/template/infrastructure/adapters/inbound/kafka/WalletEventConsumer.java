package com.yowyob.template.infrastructure.adapters.inbound.kafka;

import com.yowyob.template.domain.model.Wallet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

public class WalletEventConsumer {
    @Value("${application.kafka.topics.wallet-events}")
    private String walletEventsTopic;

    @KafkaListener(topics = "${application.kafka.topics.wallet-events}", groupId = "template-group")
    public void consume(Wallet wallet) {
        log.info("CONSUMER: I received an event for wallet with id : {} and owner : {}",
                wallet.id(), wallet.ownerId());
    }
}
