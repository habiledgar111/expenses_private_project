package com.example.expense.DTO.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TransactionRequest {
  private BigDecimal amount;
  private String type;
  private String category;
  private String description;
  private LocalDateTime transactionTime;
  private Long userId;
}
