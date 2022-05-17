package com.application.pichuser.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.application.pichuser.model.AccountModel;
import com.application.pichuser.repository.AccountRepository;
import com.application.pichuser.service.AccountService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepo;

    public AccountModel obtenerCuenta(String accountId){
        log.info("Getting Account by id " + accountId);

        try{
            return accountRepo.findById(accountId).get();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    public AccountModel crearCuenta(AccountModel account){
        log.info("Creating new account: " + account);
        return accountRepo.save(account);
    }

    public AccountModel actualizarCuenta(AccountModel account){
        log.info("Updaating account: " + account);
        return accountRepo.save(account);
    }

    public boolean eliminarCuenta(String accountId){
        log.info("Deleting account by id " + accountId);
        try{
            accountRepo.deleteById(accountId);
            log.info("Account deleted!");
            return true;
        } catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    public List<AccountModel> listarCuentas(){
        log.info("List all accounts ");
        return accountRepo.findAll();
    }

    public List<AccountModel> listarCuentaByCliente(String customerId){
        log.info("List account by id " + customerId);
        List<AccountModel> lista = new ArrayList<>();

        for (AccountModel customer : listarCuentas()) {
            if (customer.getClienteId().equals(customerId)){
                lista.add(customer);
            }
        }
        return lista;
    }
}