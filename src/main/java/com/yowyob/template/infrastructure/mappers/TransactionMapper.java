package com.yowyob.template.infrastructure.mappers;

import com.yowyob.template.domain.model.Transaction;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionRequest;
import com.yowyob.template.infrastructure.adapters.inbound.rest.dto.TransactionResponse;
import com.yowyob.template.infrastructure.adapters.outbound.persistence.entity.TransactionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction toDomain(TransactionRequest request);
    TransactionResponse toResponse(Transaction domain);

    TransactionEntity toEntity(Transaction domain);
    Transaction toDomain(TransactionEntity entity);
}
