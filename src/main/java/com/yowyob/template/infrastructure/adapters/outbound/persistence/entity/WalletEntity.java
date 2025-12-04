package com.yowyob.template.infrastructure.adapters.outbound.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table("wallets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletEntity implements Persistable<UUID> {
    @Id
    private UUID id;
    private UUID ownerId;
    private String ownerName;
    private BigDecimal balance;

    // 2. Ajouter un champ qui n'est pas dans la BDD
    @Transient
    private boolean isNew = false;

    // 3. Implémenter la méthode getId() (Lombok le fait souvent déjà via @Getter, mais c'est bien de l'avoir)
    @Override
    public UUID getId() {
        return id;
    }

    // 4. C'est ici que la magie opère
    @Override
    public boolean isNew() {
        // Si isNew est true OU si l'id est null, Spring fera un INSERT
        return isNew || id == null;
    }

    // Helper pour créer une entité marquée comme "nouvelle"
    public static WalletEntity createNew(UUID id, UUID ownerId, String ownerName, BigDecimal balance) {
        WalletEntity w = new WalletEntity(id, ownerId, ownerName, balance, true); // on met isNew à true
        return w;
    }
}
