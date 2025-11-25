package com.yowyob.template.application.service;


import com.yowyob.template.domain.handler.PaymentHandler;
import com.yowyob.template.domain.handler.RechargeHandler;
import com.yowyob.template.domain.model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final PaymentHandler paymentHandler;
    private final RechargeHandler rechargeHandler;

    public Mono<Transaction> processPayment(UUID walletId, BigDecimal amount) {
        return paymentHandler.process(walletId, amount, "PAYMENT");
    }

    public Mono<Transaction> processRecharge(UUID walletId, BigDecimal amount) {
            return rechargeHandler.process( walletId, amount, "RECHARGE");
    }
}
