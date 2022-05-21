package com.application.pichuser.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {
    private String idCuenta;
    private String tipoCuenta;
    private float saldoInicial;
    private boolean estado;
    private String clienteId;
}