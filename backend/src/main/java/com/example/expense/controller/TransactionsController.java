package com.example.expense.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.DTO.request.TransactionRequest;
import com.example.expense.DTO.response.ApiResponse;
import com.example.expense.service.AppUserService;
import com.example.expense.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/transaction")
public class TransactionsController {
  
  private TransactionService transactionService;
  private AppUserService appUserService;

  @PostMapping
  public ResponseEntity<ApiResponse<?>> createTransaction(@RequestBody TransactionRequest transactionRequest){
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Transaksi Berhasil Dibuat", transactionService.createTransaction(transactionRequest, appUserService.getUserById(transactionRequest.getUserId())));
    return ResponseEntity.ok(response);
  }

  /**
   * 
   * @param userId userid from user
   * @return all transaction from userid
   */
  @GetMapping("/{userId}")
  public ResponseEntity<ApiResponse<?>> getAllTransaction(@PathVariable Long userId){
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "All Transaction", transactionService.getAllDesc(userId));
    return ResponseEntity.ok(response);
  }

  /**
   * 
   * @param userId userid from user
   * @param transactionId transactionid for transaction that want to edit
   * @param transactionRequest new data for transaction
   * @return transaction detail that has be edited
   */
  @PutMapping("/{userId}/{transactionId}")
  public ResponseEntity<ApiResponse<?>> updateTransaction(@PathVariable Long userId, @PathVariable Long transactionId, @RequestBody TransactionRequest transactionRequest){
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Update Succefully", transactionService.updateTransaction(transactionId, transactionRequest));
    return ResponseEntity.ok(response);
  }


  @DeleteMapping("/{transactionId}")
  public ResponseEntity<ApiResponse<?>> deleteTransaction(@PathVariable Long transactionId){
    transactionService.deleteTransaction(transactionId);
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Transaction SuccessFully Deleted",null);
    return ResponseEntity.ok(response);
  }
}
