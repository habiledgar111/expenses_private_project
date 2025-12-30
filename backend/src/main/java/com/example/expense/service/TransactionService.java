package com.example.expense.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.expense.repo.TransactionsRepo;
import com.example.expense.DTO.request.TransactionRequest;
import com.example.expense.exception.ResourceNotFoundException;
import com.example.expense.helper.Updater;
import com.example.expense.mapper.TransactionsMapper;
import com.example.expense.model.AppUsers;
import com.example.expense.model.TransactionType;
import com.example.expense.model.Transactions;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {
  private TransactionsRepo transactionsRepo;
  private TransactionsMapper transactionsMapper;

  // transaction
  // tambah transaksi
  public Transactions createTransaction(TransactionRequest TransactionRequest, AppUsers user) {

    Transactions transaction = transactionsMapper.toEntity(TransactionRequest);
    transaction.setUser(user);
    return transactionsRepo.save(transaction);
  }

  public Transactions getTransactionById(Long id) {
    Transactions transaction = transactionsRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Transaction Not Found"));
    return transaction;
  }

  // edit transaksi
  public Transactions updateTransaction(Long id, TransactionRequest TransactionRequest) {
    Transactions transactionNew = transactionsMapper.toEntity(TransactionRequest);
    Transactions transactionOld = getTransactionById(id);
    Updater.updateByIdFieldChecker(transactionNew, transactionOld);
    return transactionsRepo.save(transactionOld);
  }

  // hapus transaksi
  public void deleteTransaction(Long id) {
    Transactions transaction = getTransactionById(id);
    transactionsRepo.delete(transaction);
  }

  // lihat transaksi (sort by date desc)
  public List<Transactions> getAllDesc() {
    return transactionsRepo.findAll(Sort.by("transactionTime").descending());
  }

  // summary
  // total pemasukan
  public BigDecimal totalPemasukan(AppUsers user) {
    return transactionsRepo.findByUserIdAndType(user.getId(), TransactionType.INCOME).stream()
        .map(Transactions::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  //total pengeluaran
  public BigDecimal totalPengeluaran(AppUsers user){
    return transactionsRepo.findByUserIdAndType(user.getId(), TransactionType.EXPENSE).stream()
        .map(Transactions::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
  }

  //filter
  //per minggu atau perbulan
  /**
   * 
   * @param user user yang login
   * @param start waktu start dalam bentuk localdatetime 
   * @param end waktu end dalam bentuk localdatetime
   * @return daftar transaksi yang difilter berdasarkan start time dan end time
   */
  public List<Transactions> getTransactionsPerTime(AppUsers user,LocalDateTime start, LocalDateTime end){
    return transactionsRepo.findByUserIdAndTransactionTimeBetween(user.getId(), start, end);
  }

  //category
  /**
   * 
   * @param user user yang login
   * @param category category yang ingin difilter
   * @return daftar transaksi yang difilter
   */
  public List<Transactions> getTransactionsByCategory(AppUsers user, String category){
    return transactionsRepo.findByUserIdAndCategory(user.getId(), category);
  }

}
