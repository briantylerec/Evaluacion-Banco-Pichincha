package com.application.pichuser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Setter
@Getter
public class PersonModel implements Serializable{

    @Id
    @Column(name = "id_persona",unique = true, nullable = false)
    private String idPersona;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "genero")
    private String genero;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;

    public PersonModel() {
    }

    public PersonModel(String idPersona, String nombre, String genero, Integer edad, String direccion, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}