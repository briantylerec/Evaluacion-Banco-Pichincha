package com.application.pichuser.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.application.pichuser.exception.MensajeError;
import com.application.pichuser.exception.MensajeOk;
import com.application.pichuser.helper.PDFGenerator;
import com.application.pichuser.model.AccountModel;
import com.application.pichuser.model.TransactionModel;
import com.application.pichuser.service.AccountService;
import com.application.pichuser.service.TransactionService;
import com.application.pichuser.service.dto.TransactionDTO;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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

    @Autowired
    private TransactionService transactionSrv;
    @Autowired
    private AccountService accountSrv;

    @PostMapping("crear")
    public ResponseEntity<?> crearMovimiento(@RequestBody TransactionDTO transactionDTO) {
        try {

            AccountModel account = accountSrv.obtenerCuenta(transactionDTO.getCuentaId());

            float saldoActual = account.getSaldoInicial();

            if (saldoActual < transactionDTO.getValor() && transactionDTO.getTipoMovimiento().equals("debito")) {
                return ResponseEntity.ok(new MensajeOk("Msg", "Saldo no disponible"));
            } else {
                float saldo = getSaldo(saldoActual, transactionDTO);
                account.setSaldoInicial(saldo);

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
            List<Map<String, String>> reporte = transactionSrv.listarMovimientosDateCliente(
                (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data.get("fechaInicio")),
                (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data.get("fechaFin")),
                data.get("cliente"));

            return new ResponseEntity<>(reporte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MensajeError("CREATE", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "reportes", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> customerReport(@RequestBody Map<String, String> data) throws IOException, ParseException {
        
        List<Map<String, String>> reporte = transactionSrv.listarMovimientosDateCliente(
                (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data.get("fechaInicio")),
                (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data.get("fechaFin")),
                data.get("cliente"));

        ByteArrayInputStream bis = PDFGenerator.customerPDFReport(reporte);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}