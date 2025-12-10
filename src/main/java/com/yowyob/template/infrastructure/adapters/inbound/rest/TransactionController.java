package com.yowyob.template.infrastructure.adapters.inbound.rest;

import com.yowyob.template.domain.model.TransactionType;
import com.yowyob.template.domain.ports.in.TransactionUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionResponse;
import com.yowyob.template.infrastructure.mappers.TransactionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionUseCase useCase;
    private final TransactionMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TransactionResponse> create(@RequestBody @Valid Mono<TransactionRequest> requestMono) {
        return requestMono
                .flatMap(request -> {
                    if (request.type() != TransactionType.RECHARGE) {
                        return Mono.error(new IllegalArgumentException("Cet endpoint est réservé aux recharges via Agent"));
                    }
                    return Mono.just(request);
                })
                .map(mapper::toDomain)
                .flatMap(useCase::createTransaction)
                .map(mapper::toResponse);
    }

    @GetMapping("/{id}")
    public Mono<TransactionResponse> findById(@PathVariable("id") UUID id) {
        return useCase.getTransactionById(id)
                .map(mapper::toResponse);
    }

    @GetMapping("/Wallet/{walletId}")
    public Flux<TransactionResponse> findByWalletId(@PathVariable("walletId") UUID walletId) {
        return useCase.getTransactionsByWalletId(walletId)
                .map(mapper::toResponse);
    }
}
