package com.example.expense.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.expense.DTO.request.LoginRequest;
import com.example.expense.DTO.response.ApiResponse;
import com.example.expense.service.AppUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {
  
  private AppUserService appUserService;

  @PostMapping
  public ResponseEntity<ApiResponse<?>> login(@RequestBody LoginRequest loginRequest){
    ApiResponse<?> response = new ApiResponse<>(200, "OK", "Login Successfully", appUserService.login(loginRequest));
    return ResponseEntity.ok(response);
  }

}
