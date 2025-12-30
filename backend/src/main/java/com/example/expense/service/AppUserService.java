package com.example.expense.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.example.expense.DTO.request.LoginRequest;
import com.example.expense.exception.ResourceNotFoundException;
import com.example.expense.model.AppUsers;
import com.example.expense.repo.AppUserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService {
  
  private AppUserRepo appUserRepo;

  public AppUsers getUserById(Long id){
    return appUserRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
  }

  public AppUsers login(LoginRequest loginRequest) throws BadCredentialsException{
    AppUsers user = appUserRepo.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
    if(loginRequest.getPassword().equals(user.getPassword())){
      return user;
    }
    throw new BadCredentialsException("Wrong Password");
  }
}
