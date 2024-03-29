package com.application.pichuser.repository;

import com.application.pichuser.model.AccountModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, String> {
    
}