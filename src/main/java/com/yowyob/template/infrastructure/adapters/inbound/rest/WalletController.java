package com.yowyob.template.infrastructure.adapters.inbound.rest;

import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletResponse;
import com.yowyob.template.infrastructure.mappers.WalletMapper;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletUseCase useCase;
    private final WalletMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<WalletResponse> create(@RequestBody @Valid Mono<WalletRequest> requestMono) {
        return requestMono
                .map(mapper::toDomain)
                .flatMap(useCase::createWallet)
                .map(mapper::toResponse);
    }

    @GetMapping
    public Flux<WalletResponse> getAllWallets() {
        return useCase.getAllWallets()
                .map(mapper::toResponse);
    }

    @GetMapping("/{id}")
    public Mono<WalletResponse> getWallet(@PathVariable UUID id) {
        return useCase.getWalletById(id)
                .map(mapper::toResponse);
    }

    @GetMapping("/owner/{id}")
    public Mono<WalletResponse> getWalletOwner(@PathVariable UUID id) {
        return useCase.getWalletByOwnerId(id)
                .map(mapper::toResponse);
    }

    @PatchMapping("/{id}")
    public Mono<WalletResponse> updateWallet(@PathVariable UUID id, @RequestBody @Valid WalletRequest request) {
        Wallet wallet = new Wallet(id, request.ownerId(), request.ownerName(), null);
        return useCase.updateWallet(wallet)
                .map(mapper::toResponse);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteWallet(@PathVariable UUID id) {
        return useCase.deleteWallet(id);
    }
}