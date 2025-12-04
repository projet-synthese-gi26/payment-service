package com.yowyob.template.infrastructure.adapters.outbound.messaging;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.out.WalletEventPublisherPort;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class KafkaAdapter implements WalletEventPublisherPort {

    private final ReactiveKafkaProducerTemplate<String, Object> kafkaTemplate;

    @Value("${application.kafka.topics.wallet-create}")
    private String walletEventsTopic;

    public KafkaAdapter(ReactiveKafkaProducerTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public Mono<Void> publishWalletCreated(Wallet wallet) {
        return kafkaTemplate.send(walletEventsTopic, wallet.id().toString(), wallet)
                .then();
    }
}