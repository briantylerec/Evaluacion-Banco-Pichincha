package com.application.pichuser.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class CustomerServiceTest {
    
    @InjectMocks
    CustomerService customerSrv;

    @Test
    public void testGettingCustomerExist() throws NullPointerException {

        try {
            String customerId = "0105686739";
            assertEquals(customerSrv.obtenerCliente(customerId), notNull());
        } catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        
    }
}
