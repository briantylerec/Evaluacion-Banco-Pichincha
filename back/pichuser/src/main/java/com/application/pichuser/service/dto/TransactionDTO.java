package com.application.pichuser.service.dto;

public class TransactionDTO {
    
    String tipoMovimiento;
    float valor;
    String cuentaId;

    public TransactionDTO() {
    }

    public TransactionDTO(String tipoMovimiento, float valor, String cuentaId) {
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.cuentaId = cuentaId;
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

    public String getCuentaId() {
        return this.cuentaId;
    }

    public void setCuentaId(String cuentaId) {
        this.cuentaId = cuentaId;
    }

}
