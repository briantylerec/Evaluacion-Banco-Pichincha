package com.application.pichuser.service;

import com.application.pichuser.model.PersonModel;

public interface PersonService {

    public PersonModel obtenerPersona(String personId);

    public PersonModel crearPersona(PersonModel person);

    public PersonModel actualizarPersona(PersonModel person);

    public boolean eliminarPersona(PersonModel person);  
    
}
