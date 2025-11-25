package com.yowyob.template.infrastructure.mappers;


import com.yowyob.template.domain.model.Wallet;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.WalletResponse;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.WalletEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WalletMapper {
    Wallet toDomain(WalletRequest request);
    WalletResponse toResponse(Wallet domain);

    WalletEntity toEntity(Wallet domain);
    Wallet toDomain(WalletEntity entity);
}
