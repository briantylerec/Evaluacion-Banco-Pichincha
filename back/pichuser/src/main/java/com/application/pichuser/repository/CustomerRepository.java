package com.application.pichuser.repository;

import com.application.pichuser.model.CustomerModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <CustomerModel, String>{
    
}
