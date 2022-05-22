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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
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

    public TransactionModel(Date fecha, String tipoMovimiento, float valor, float saldo, AccountModel cuentaId) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuentaId = cuentaId;
    }
}