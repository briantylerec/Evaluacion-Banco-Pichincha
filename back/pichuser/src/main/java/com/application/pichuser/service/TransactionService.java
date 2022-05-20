package com.application.pichuser.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.application.pichuser.model.TransactionModel;

public interface TransactionService {
    
    public TransactionModel obtenerMovimientos(String transactionId);

    public TransactionModel crearMovimientos(TransactionModel transaction);

    public TransactionModel actualizarMovimientos(TransactionModel transaction);

    public boolean eliminarMovimientos(TransactionModel transaction);

    public List<TransactionModel> listarMovimientos();

    public List<TransactionModel> listarMovimientosCliente(String customer);

    public List<Map<String, String>> listarMovimientosDateCliente(Date initDate, Date finalDate, String customerId);
}
