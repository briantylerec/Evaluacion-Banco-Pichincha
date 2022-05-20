package com.application.pichuser.controller;

import java.util.List;

import com.application.pichuser.exception.MensajeError;
import com.application.pichuser.exception.MensajeOk;
import com.application.pichuser.model.CustomerModel;
import com.application.pichuser.model.PersonModel;
import com.application.pichuser.service.CustomerService;
import com.application.pichuser.service.PersonService;
import com.application.pichuser.service.impl.CustomerServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class CustomerController {

    private final CustomerService customerSrv;
    private final PersonService personSrv;

    @PostMapping("/crear")
    public ResponseEntity<?> crearCliente(@RequestBody CustomerModel customer){
        
        try{            
            if(customerSrv.obtenerCliente(customer.getPersonaId().getIdPersona()) == null){
                PersonModel person = customer.getPersonaId();
                customer.setIdCliente(person.getIdPersona());

                personSrv.crearPersona(person);

                return new ResponseEntity<>(customerSrv.crearCliente(customer), HttpStatus.CREATED);
            }
            
            return ResponseEntity.ok(new MensajeOk("Msg","Usuario ya existe!"));

        }
        catch (Exception e){
            return new ResponseEntity<>(new MensajeError("CREATE", e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("obtener/{customerId}")
    public ResponseEntity<?> obtenerCliente(@PathVariable String customerId){
        try{           
            return new ResponseEntity<>(customerSrv.obtenerCliente(customerId)==null?new MensajeOk("Msg","Usuario no existe!"):customerSrv.obtenerCliente(customerId), HttpStatus.OK);
            
        } catch (Exception e){
            return new ResponseEntity<>(new MensajeError("GET", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="actualizar")
    public ResponseEntity<?> actualizarCliente(@RequestBody CustomerModel customer){
        
        try{
            if(customerSrv.obtenerCliente(customer.getPersonaId().getIdPersona())!=null){
                PersonModel person = customer.getPersonaId();
                customer.setIdCliente(person.getIdPersona());

                personSrv.crearPersona(person);
                
                
                return new ResponseEntity<>(customerSrv.crearCliente(customer), HttpStatus.OK);
            }
            
            return ResponseEntity.ok(new MensajeOk("Msg","Usuario no existe!"));

        }
        catch (Exception e){
            return new ResponseEntity<>(new MensajeError("UPDATE", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("eliminar/{customerId}")
    public ResponseEntity<?> eliminarCliente(@PathVariable String customerId){

        try{
            if(customerSrv.eliminarCliente(customerId)){
                return new ResponseEntity<>(new MensajeOk("Msg", "Cliente eliminado exitosamente!"), HttpStatus.OK);
            }
            return ResponseEntity.ok(new MensajeOk("Msg", "Cliente no existe!"));
        } catch(Exception e){
            return new ResponseEntity<>(new MensajeError("DELETE", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("listar")
    public ResponseEntity<List<CustomerModel>> listarClientes(){
        return new ResponseEntity<>(customerSrv.listarClientes(), HttpStatus.OK);
    }
}