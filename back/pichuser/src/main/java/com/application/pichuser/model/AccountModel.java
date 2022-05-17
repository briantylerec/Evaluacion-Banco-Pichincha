package com.application.pichuser.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta")
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

    public CustomerModel getClienteId() {
        return this.clienteId;
    }

    public void setClienteId(CustomerModel clienteId) {
        this.clienteId = clienteId;
    }    

    public String getIdCuenta() {
        return this.idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTipoCuenta() {
        return this.tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public float getSaldoInicial() {
        return this.saldoInicial;
    }

    public void setSaldoInicia(float saldoInicial) {
        this.saldoInicial = saldoInicial;
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