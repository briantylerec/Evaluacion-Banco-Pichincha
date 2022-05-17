package com.application.pichuser.controllers;

import static org.mockito.Mockito.when;

import com.application.pichuser.controller.CustomerController;
import com.application.pichuser.model.CustomerModel;
import com.application.pichuser.model.PersonModel;
import com.application.pichuser.service.impl.CustomerServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class CustomerControllerTests {
    @InjectMocks
    CustomerController customerController;

    @Mock
    CustomerServiceImpl customerSrv;

    private CustomerModel customer;
    private PersonModel person;

    @BeforeEach
    void setUp() throws Exception{

        this.person = new PersonModel("0105686730","brian mora","masculino",28,"Americas","095456551");
        this.customer = new CustomerModel("", "1234", true, this.person);
    }

    @Test
    public void testDeleteClientTrue(){
        try {
            when(customerSrv.eliminarCliente(this.customer.getPersonaId().getIdPersona())).thenReturn(true);
        } catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}