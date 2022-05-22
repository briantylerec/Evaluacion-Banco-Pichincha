package com.application.pichuser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
public class AccountModel implements Serializable {

    @Id
    @Column(name = "id_cuenta", unique = true, nullable = false)
    private String idCuenta;
    
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Column(name = "saldo_inicial")
    private float saldoInicial;
    @Column(name = "estado")
    private boolean estado;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id_cliente")
    private CustomerModel clienteId;

    public AccountModel() {
    }

    public AccountModel(String idCuenta, String tipoCuenta, float saldoInicial, boolean estado, CustomerModel clienteId) {
        this.idCuenta = idCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.clienteId = clienteId;
    }

}