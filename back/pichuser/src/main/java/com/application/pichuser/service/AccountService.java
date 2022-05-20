package com.application.pichuser.service;

import java.util.List;

import com.application.pichuser.model.AccountModel;
import com.application.pichuser.model.CustomerModel;
import com.application.pichuser.model.PersonModel;

public interface AccountService {

    public AccountModel obtenerCuenta(String accountId);

    public AccountModel crearCuenta(AccountModel account);

    public AccountModel actualizarCuenta(AccountModel account);

    public boolean eliminarCuenta(String accountId);

    public List<AccountModel> listarCuentas();

    public List<AccountModel> listarCuentaByCliente(String customerId);
    
}
