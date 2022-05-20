package com.application.pichuser.service;

import java.util.List;

import com.application.pichuser.model.CustomerModel;
import com.application.pichuser.model.PersonModel;

public interface CustomerService {
    
    public CustomerModel obtenerCliente(String customerId);

    public CustomerModel crearCliente(CustomerModel customer);

    public CustomerModel actualizarCliente(CustomerModel customer);

    public boolean eliminarCliente(String customerId);

    public boolean clienteExiste(String customerId);

    public List<CustomerModel> listarClientes();

    public CustomerModel obtenerClienteByPersona(PersonModel persona);
}
