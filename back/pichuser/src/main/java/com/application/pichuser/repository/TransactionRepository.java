package com.application.pichuser.repository;

import com.application.pichuser.model.TransactionModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, String>{
    
}
