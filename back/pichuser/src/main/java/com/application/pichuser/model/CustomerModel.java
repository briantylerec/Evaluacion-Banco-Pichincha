package com.application.pichuser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class CustomerModel implements Serializable {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", unique = true, nullable = false)
    private String idCliente;

    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "estado")
    private boolean estado;
    
    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id_persona")
    private PersonModel personaId;

    public CustomerModel() {
    }

    public CustomerModel(String idCliente, String contrasena, boolean estado, PersonModel personaId) {
        this.idCliente = idCliente;
        this.contrasena = contrasena;
        this.estado = estado;
        this.personaId = personaId;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public PersonModel getPersonaId() {
        return this.personaId;
    }

    public void setPersonaId(PersonModel personaId) {
        this.personaId = personaId;
    }   

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return this.estado;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}