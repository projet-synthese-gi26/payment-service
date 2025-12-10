package com.yowyob.template.application.service;


import com.yowyob.template.domain.exception.WalletNotFoundException;
import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.domain.ports.in.WalletUseCase;
import com.yowyob.template.domain.ports.out.WalletEventPublisherPort;
import com.yowyob.template.domain.ports.out.WalletRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService implements WalletUseCase {

    public  final WalletRepositoryPort walletRepositoryPort;
    private final WalletEventPublisherPort eventPublisher;

    @Override
    public Mono<Wallet> createWallet(Wallet wallet) {
        Wallet toSave = new Wallet(
                wallet.id() != null ? wallet.id() : UUID.randomUUID(), // Génération ID si absent
                wallet.ownerId(),
                wallet.ownerName(),
                wallet.balance() != null ? wallet.balance() : BigDecimal.ZERO
        );

        return walletRepositoryPort.save(toSave);
                //.flatMap(saved -> eventPublisher.publishWalletCreated(saved).thenReturn(saved));
    }

    @Override
    public Mono<Wallet> getWalletByOwnerId(UUID ownerId) {
        return walletRepositoryPort.findByOwnerId(ownerId)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Wallet not found")));
    }

    @Override
    public Mono<Wallet> updateWallet(Wallet wallet) {
        return walletRepositoryPort.findById(wallet.id())
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Wallet not found")))
                .flatMap(existingWallet -> {
                    Wallet walletToUpdate = new Wallet(
                            existingWallet.id(),
                            wallet.ownerId() == null? existingWallet.ownerId(): wallet.ownerId(),
                            wallet.ownerName() == null? existingWallet.ownerName(): wallet.ownerName(),
                            existingWallet.balance()
                    );

                    return walletRepositoryPort.updateWallet(walletToUpdate);
                });
    }

    @Override
    public Mono<Void> deleteWallet(UUID id) {
        return walletRepositoryPort.findById(id)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Wallet not found")))
                .flatMap(wallet -> walletRepositoryPort.deleteById(wallet.id()));
    }

    @Override
    public Mono<Wallet> getWalletById(UUID id) {
        return walletRepositoryPort.findById(id)
                .switchIfEmpty(Mono.error(new WalletNotFoundException("Not found")));
    }

    @Override
    public Flux <Wallet> getAllWallets() {
        return walletRepositoryPort.findAllWallets();
    }
}
