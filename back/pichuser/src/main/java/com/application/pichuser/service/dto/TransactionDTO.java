package com.application.pichuser.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDTO {
    String tipoMovimiento;
    float valor;
    String cuentaId;
}