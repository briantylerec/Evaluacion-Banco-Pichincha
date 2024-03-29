package com.application.pichuser.service.impl;

import com.application.pichuser.model.PersonModel;
import com.application.pichuser.repository.PersonRepository;
import com.application.pichuser.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepo;

    @Override
    public PersonModel obtenerPersona(String personId) {
        log.info("Getting person by id " + personId);
        return personRepo.findById(personId).get();
    }

    @Override
    public PersonModel crearPersona(PersonModel person){
        log.info("Creating person:" + person);
        return personRepo.save(person);
    }

    @Override
    public PersonModel actualizarPersona(PersonModel person){
        log.info("Updatingperson:" + person);
        return personRepo.save(person);
    }

    @Override
    public boolean eliminarPersona(PersonModel person) {
        log.info("Deleting person:" + person);

        personRepo.deleteById(person.getIdPersona());
        return true;
    }       
}