package com.application.pichuser.service.impl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.application.pichuser.model.TransactionModel;
import com.application.pichuser.repository.TransactionRepository;
import com.application.pichuser.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private  TransactionRepository transactionRepo;

    @Override
    public TransactionModel obtenerMovimientos(String transactionId){
        log.info("Getting transaction:" + transactionId);
        try{
            return transactionRepo.findById(transactionId).get();
        } catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public TransactionModel crearMovimientos(TransactionModel transaction){
        log.info("Creating transaction:" + transaction);
        return transactionRepo.save(transaction);
    }

    @Override
    public TransactionModel actualizarMovimientos(TransactionModel transaction){
        log.info("Updating transaction:" + transaction);
        return transactionRepo.save(transaction);
    }

    @Override
    public boolean eliminarMovimientos(TransactionModel transaction){
        log.info("Deleting transaction:" + transaction);
        try{
            transactionRepo.deleteById(transaction.getIdMovimiento().toString());
            return true;
        } catch(Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<TransactionModel> listarMovimientos(){
        log.info("Listing transaction:");
        return transactionRepo.findAll();
    }

    @Override
    public List<TransactionModel> listarMovimientosCliente(String customer){
        log.info("Listing transactions by customer:" + customer);
        List<TransactionModel> lista = new ArrayList<TransactionModel>();

        for (TransactionModel m : transactionRepo.findAll()) {
            if(m.getCuentaId().getClienteId().getIdCliente().equals(customer)){
                lista.add(m);
            }
        }
        return lista;
    }

    @Override
    public List<Map<String, String>> listarMovimientosDateCliente(Date initDate, Date finalDate, String customerId){
        log.info("Listing transactions btween "+initDate+" and "+finalDate+" by customer id: " + customerId);

        List<Map<String, String>> lista = new ArrayList<>();

        for (TransactionModel m : listarMovimientosCliente(customerId)) {
            if(m.getFecha().after(initDate) && m.getFecha().before(finalDate)){
                
                Map<String, String> mapa = new HashMap<>();

                mapa.put("Fecha", m.getFecha().toString());
                mapa.put("Cliente", m.getCuentaId().getClienteId().getPersonaId().getNombre());
                mapa.put("Numero Cuenta", m.getCuentaId().getIdCuenta());
                mapa.put("Tipo", m.getTipoMovimiento());
                mapa.put("Saldo Inicial", String.valueOf(m.getSaldo()));
                mapa.put("Estado", m.getCuentaId().getEstado()==true?"true":"false");
                mapa.put("Movimiento", m.getTipoMovimiento().equals("credito")?"+"+String.valueOf(m.getValor()):"-"+String.valueOf(m.getValor()));
                mapa.put("Saldo Disponible", String.valueOf(m.getCuentaId().getSaldoInicial()));

                lista.add(mapa);
            }
        }
        return lista;
    }
}