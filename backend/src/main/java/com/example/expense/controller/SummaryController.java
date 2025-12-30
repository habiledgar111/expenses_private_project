package com.example.expense.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.DTO.response.ApiResponse;
import com.example.expense.service.AppUserService;
import com.example.expense.service.TransactionService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/summary")
public class SummaryController {
  
  private TransactionService transactionService;
  private AppUserService appUserService;

  @GetMapping("/weekly/{userId}")
  public ResponseEntity<ApiResponse<?>> transactionWeek(@PathVariable Long userId, @RequestParam (required = true)LocalDate localDate){
    LocalDate startOfWeek = localDate.with(DayOfWeek.MONDAY);
    LocalDate endOfWeek = startOfWeek.plusDays(6);
    LocalDateTime start = startOfWeek.atStartOfDay();
    LocalDateTime end = endOfWeek.atTime(23,59,59);
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Transaction Per Week", transactionService.getTransactionsPerTime(appUserService.getUserById(userId), start, end));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/monthly/{userId}")
  public ResponseEntity<ApiResponse<?>> transactionMonth (@PathVariable Long userId, @RequestParam (required = true)int year, @RequestParam (required = true) int month){
    YearMonth ym = YearMonth.of(year, month);
    LocalDateTime start = ym.atDay(1).atStartOfDay();
    LocalDateTime end = ym.atEndOfMonth().atTime(23,59,59);
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Transaction Per Month", transactionService.getTransactionsPerTime(appUserService.getUserById(userId), start, end));
    return ResponseEntity.ok(response);
  }
}
