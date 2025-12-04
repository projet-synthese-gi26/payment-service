package com.yowyob.template.infrastructure.adapters.inbound.kafka;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.domain.model.TransactionStatus;
import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.ports.in.TransactionUseCase;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.kafka.event.PaymentCommissionEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaPaymentConsumer {

    private final TransactionUseCase transactionUseCase;
    private final WalletUseCase walletUseCase;


    @Value("${application.payment.commission-rate}")
    private BigDecimal commissionRate;

    @KafkaListener(topics = "${application.kafka.topics.payment-commission}", groupId = "payment-group")
    public void consumePaymentCommission(PaymentCommissionEvent event) {


        // LOGIQUE MÉTIER : Calcul du montant à retirer (Pourcentage * MontantBase)
        BigDecimal amountToDeduct = event.baseAmount().multiply(commissionRate);

        walletUseCase.getWalletByOwnerId(event.ownerId())
                .flatMap(wallet -> {
                    Transaction domainTx = new Transaction(
                            null,
                            wallet.id(),
                            amountToDeduct,
                            TransactionType.PAYMENT,
                            TransactionStatus.PENDING
                    );

                    return transactionUseCase.createTransaction(domainTx);
                })
                .doOnSuccess(tx -> log.info("Commission prélevée avec succès. Tx ID: {}", tx.id()))
                .doOnError(e -> log.error("Échec du prélèvement de commission pour owner {}", event.ownerId(), e))
                .subscribe();
    }
}
