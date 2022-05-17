package com.application.pichuser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
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

    public String getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        return this.edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}