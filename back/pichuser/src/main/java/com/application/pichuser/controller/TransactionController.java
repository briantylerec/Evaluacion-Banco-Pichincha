package com.application.pichuser.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.application.pichuser.exception.MensajeError;
import com.application.pichuser.exception.MensajeOk;
import com.application.pichuser.model.AccountModel;
import com.application.pichuser.model.TransactionModel;
import com.application.pichuser.service.dto.TransactionDTO;
import com.application.pichuser.service.impl.AccountServiceImpl;
import com.application.pichuser.service.impl.TransactionServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("movimientos")
public class TransactionController {

    private final TransactionServiceImpl transactionSrv;
    private final AccountServiceImpl accountSrv;

    @PostMapping("crear")
    public ResponseEntity<?> crearMovimiento(@RequestBody TransactionDTO transactionDTO) {
        try {

            AccountModel account = accountSrv.obtenerCuenta(transactionDTO.getCuentaId());

            float saldoActual = account.getSaldoInicial();

            if (saldoActual < transactionDTO.getValor() && transactionDTO.getTipoMovimiento().equals("debito")) {
                return ResponseEntity.ok(new MensajeOk("Msg", "Saldo no disponible"));
            } else {
                float saldo = getSaldo(saldoActual, transactionDTO);
                account.setSaldoInicia(saldo);

                TransactionModel transaction = new TransactionModel(new Date(), transactionDTO.getTipoMovimiento(),
                        transactionDTO.getValor(), saldo, account);
                accountSrv.actualizarCuenta(account);

                return new ResponseEntity<>(transactionSrv.crearMovimientos(transaction), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new MensajeError("CREATE", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    float getSaldo(float saldoActual, TransactionDTO transactionDTO){
        return transactionDTO.getTipoMovimiento().equals("credito")
                        ? saldoActual + transactionDTO.getValor()
                        : saldoActual - transactionDTO.getValor();
    }

    @GetMapping(value = "listar")
    public ResponseEntity<?> listarMovimientosDateCliente(@RequestBody Map<String, String> data) {
        try {
            return new ResponseEntity<>(transactionSrv.listarMovimientosDateCliente(
                    (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data.get("fechaInicio")),
                    (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data.get("fechaFin")), data.get("cliente")), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MensajeError("CREATE", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}