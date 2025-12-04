package com.yowyob.template.infrastructure.adapters.inbound.kafka;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.kafka.event.WalletCreationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static org.apache.kafka.common.requests.DeleteAclsResponse.log;

@Component
@RequiredArgsConstructor
public class WalletEventConsumer {

    private final WalletUseCase walletUseCase;
//    @Value("${application.kafka.topics.wallet-events}")
//    private String walletEventsTopic;
//
//    @KafkaListener(topics = "${application.kafka.topics.wallet-events}", groupId = "template-group")
//    public void consume(Wallet wallet) {
//        log.info("CONSUMER: I received an event for wallet with id : {} and owner : {}",
//                wallet.id(), wallet.ownerId());
//    }


    @KafkaListener(topics = "${application.kafka.topics.wallet-create}", groupId = "payment-group")
    public void consumeWalletCreation(WalletCreationEvent event) {
        Wallet domainWallet = new Wallet(null, event.ownerId(), event.ownerName(), BigDecimal.ZERO);

        walletUseCase.createWallet(domainWallet)
                .doOnSuccess(w -> log.info("Wallet créé: {}", w.id()))
                .doOnError(e -> log.error("Erreur création wallet", e))
                .subscribe();
    }
}
