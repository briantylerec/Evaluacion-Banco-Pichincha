package com.application.pichuser.repository;

import com.application.pichuser.model.PersonModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonModel, String>{
    
}
