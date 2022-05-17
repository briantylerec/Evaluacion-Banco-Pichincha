package com.application.pichuser.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class TransactionModel implements Serializable {

    @Id
    @Column(name="id_movimiento",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMovimiento;
    
    @Column(name = "fecha")
    private Date fecha;
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Column(name = "valor")
    private float valor;
    @Column(name = "saldo")
    private float saldo;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id_cuenta")
    private AccountModel cuentaId;

    public TransactionModel() {
    }

    public TransactionModel(Date fecha, String tipoMovimiento, float valor, float saldo, AccountModel cuentaId) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuentaId = cuentaId;
    }

    public AccountModel getCuentaId() {
        return this.cuentaId;
    }

    public void setCuentaId(AccountModel cuentaId) {
        this.cuentaId = cuentaId;
    }

    public Long getIdMovimiento() {
        return this.idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    } 

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return this.tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }   
}