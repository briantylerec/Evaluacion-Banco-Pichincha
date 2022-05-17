package com.application.pichuser.repository;

import com.application.pichuser.model.CustomerModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <CustomerModel, String>{
    
}
