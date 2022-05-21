package com.application.pichuser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
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
}