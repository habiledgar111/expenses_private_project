package com.example.expense.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Digits(integer = 15,fraction = 0)
  private BigDecimal amount;

  @Column(length = 10)
  private TransactionType type;

  @Column(length = 20)
  private String category;

  @Column(length = 25)
  private String description;

  @Column(name = "transaction_time")
  private LocalDateTime transactionTime;

  @ManyToOne
  @JoinColumn(name = "user_id",nullable = false)
  private AppUsers user;
}
