package com.example.expense.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.expense.model.AppUsers;

@Repository
public interface AppUserRepo extends JpaRepository<AppUsers,Long>{
  Optional<AppUsers> findByUsername(String username);
}
