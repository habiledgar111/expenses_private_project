package com.example.expense.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expense.model.TransactionType;
import com.example.expense.model.Transactions;

@Repository
public interface TransactionsRepo extends JpaRepository<Transactions,Long>{

  List<Transactions> findByUserIdAndType(Long userId,TransactionType type);
  List<Transactions> findByUserIdAndTransactionTimeBetween(Long userId, LocalDateTime start, LocalDateTime end);
  List<Transactions> findByUserIdAndCategory(Long userId, String category);
}
