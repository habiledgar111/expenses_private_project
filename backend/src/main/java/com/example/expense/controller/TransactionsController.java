package com.example.expense.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.DTO.request.TransactionRequest;
import com.example.expense.DTO.response.ApiResponse;
import com.example.expense.service.AppUserService;
import com.example.expense.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TransactionsController {
  
  private TransactionService transactionService;
  private AppUserService appUserService;

  public ResponseEntity<ApiResponse<?>> createTransaction(@RequestBody TransactionRequest transactionRequest){
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Transaksi Berhasil Dibuat", transactionService.createTransaction(transactionRequest, appUserService.getUserById(transactionRequest.getUserId())));
    return ResponseEntity.ok(response);
  }
}
