package com.example.ggaapi.service;

import com.example.ggaapi.model.Tipo_facturas;
import com.example.ggaapi.repository.ITipoFacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoFacturasImpl implements ITipoFacturasService{

    @Autowired
    private ITipoFacturasRepository repoTipo;

    @Override
    public List<Tipo_facturas> getAllTipoFacturas(){
        return repoTipo.findAll();
    }

}
