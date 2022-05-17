package com.application.pichuser.controller;

import java.util.List;

import com.application.pichuser.exception.MensajeError;
import com.application.pichuser.exception.MensajeOk;
import com.application.pichuser.model.CustomerModel;
import com.application.pichuser.model.AccountModel;
import com.application.pichuser.service.dto.AccountDTO;
import com.application.pichuser.service.impl.AccountServiceImpl;
import com.application.pichuser.service.impl.CustomerServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cuentas")
public class AccountController {

    private final AccountServiceImpl accountSrv;
    private final CustomerServiceImpl customerSrv;

    @PostMapping("crear")
    public ResponseEntity<?> crearCuenta(@RequestBody AccountDTO accountDTO){

        try{
            if(accountSrv.obtenerCuenta(accountDTO.getIdCuenta()) == null){

                CustomerModel customer = customerSrv.obtenerCliente(accountDTO.getClienteId());

                AccountModel account = new AccountModel(accountDTO.getIdCuenta(), accountDTO.getTipoCuenta(), accountDTO.getSaldoInicial(), accountDTO.getEstado(), customer);

                return new ResponseEntity<>(accountSrv.crearCuenta(account), HttpStatus.CREATED);
            }
            return ResponseEntity.ok(new MensajeOk("Msg","Cuenta ya existe."));
        } catch(Exception e){
            return new ResponseEntity<>(new MensajeError("CREATE",e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("actualizar")
    public ResponseEntity<?> actualizarCuenta(@RequestBody AccountDTO accountDTO){

        try{
            if(accountSrv.obtenerCuenta(accountDTO.getIdCuenta())!=null){
                CustomerModel customer = customerSrv.obtenerCliente(accountDTO.getClienteId());
                AccountModel account = new AccountModel(accountDTO.getIdCuenta(), accountDTO.getTipoCuenta(), accountDTO.getSaldoInicial(), accountDTO.getEstado(), customer);
                return new ResponseEntity<>(accountSrv.crearCuenta(account), HttpStatus.CREATED);
            } else {
                return ResponseEntity.ok(new MensajeOk("Msg","Cuenta no existe."));
            }
        } catch(Exception e){
            return new ResponseEntity<>(new MensajeError("UPDATE",e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("obtener/{accountId}")
    public ResponseEntity<?> obtenerCuenta(@PathVariable String accountId){
        try{
            AccountModel account = accountSrv.obtenerCuenta(accountId);
            if(account!=null){
                return new ResponseEntity<>(account, HttpStatus.OK);
            }
            return ResponseEntity.ok(new MensajeOk("Msg","Cuenta no existe."));
        } catch(Exception e){
            return new ResponseEntity<>(new MensajeError("GET",e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("listar")
    public ResponseEntity<List<AccountModel>> listarCuentas(){
        return new ResponseEntity<>(accountSrv.listarCuentas(), HttpStatus.OK);
    }

    @DeleteMapping("eliminar/{accountId}")
    public ResponseEntity<?> eliminarCuenta(@PathVariable String accountId){

        try{
            if(accountSrv.eliminarCuenta(accountId)){
                return new ResponseEntity<>(new MensajeOk("Msg", "Cuenta eliminada exitosamente!"), HttpStatus.OK);
            }
            return ResponseEntity.ok(new MensajeOk("Msg", "Cuenta no existe!"));
        } catch(Exception e){
            return new ResponseEntity<>(new MensajeError("DELETE", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    
}