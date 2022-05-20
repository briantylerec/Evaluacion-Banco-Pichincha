package com.application.pichuser.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.application.pichuser.service.dto.TransactionDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransactionControllerTest {

    private float saldoActual;
    private TransactionDTO transactionDTO;

    @BeforeEach
    void setUp() throws Exception{

        this.saldoActual = 200;
        this.transactionDTO = new TransactionDTO("credito", 800, "496825");
    }
    
    @Test
    public void testgetSaldo(){

        assertEquals(1000, this.transactionDTO.getTipoMovimiento().equals("credito")
        ? this.saldoActual + this.transactionDTO.getValor()
        : this.saldoActual - this.transactionDTO.getValor());
    }
}
