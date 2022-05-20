package com.application.pichuser.service.impl;

import java.util.List;

import com.application.pichuser.model.CustomerModel;
import com.application.pichuser.model.PersonModel;
import com.application.pichuser.repository.CustomerRepository;
import com.application.pichuser.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public CustomerModel obtenerCliente(String customerId) {
        log.info("Getting customer by id " + customerId);

        try{
            return customerRepo.findById(customerId).get();
            
        } catch(Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public CustomerModel crearCliente(CustomerModel customer){
        log.info("Creating customer: " + customer);
        return customerRepo.save(customer);
    }

    @Override
    public CustomerModel actualizarCliente(CustomerModel customer){
        log.info("Updating customer: " + customer);
        return customerRepo.save(customer);
    }

    @Override
    public boolean eliminarCliente(String customerId) {
        log.info("Deleting by id " + customerId);

        if(obtenerCliente(customerId)!=null){
            customerRepo.deleteById(customerId);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean clienteExiste(String customerId) {

        return obtenerCliente(customerId)==null;
    }

    @Override
    public List<CustomerModel> listarClientes(){
        log.info("Listing customer ");
        return customerRepo.findAll();
    }

    @Override
    public CustomerModel obtenerClienteByPersona(PersonModel persona){
        List<CustomerModel> clientes = listarClientes();
        CustomerModel customer;

        for (int i = 0; i < clientes.size(); i++) {
            customer = clientes.get(i);
            if(customer.getPersonaId().getIdPersona().equals(persona.getIdPersona())){
                return customer;
            }
        }
        return null;
    }
}