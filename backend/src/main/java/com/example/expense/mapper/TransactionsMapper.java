package com.example.expense.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.expense.DTO.request.TransactionRequest;
import com.example.expense.model.Transactions;

@Mapper(componentModel = "spring")
public interface TransactionsMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "user", ignore = true)
  @Mapping(target = "transactionTime", expression = "java(request.getTransactionTime() != null ? request.getTransactionTime() : java.time.LocalDateTime.now())")
  Transactions toEntity(TransactionRequest request);
}
