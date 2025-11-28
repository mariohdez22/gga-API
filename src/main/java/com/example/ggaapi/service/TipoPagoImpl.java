package com.example.ggaapi.service;

import com.example.ggaapi.model.Tipo_pago;
import com.example.ggaapi.repository.ITipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPagoImpl implements ITipoPagoService{

    @Autowired
    private ITipoPagoRepository repoTipo;

    @Override
    public List<Tipo_pago> getAllTipoPago(){
        return repoTipo.findAll();
    }

}
