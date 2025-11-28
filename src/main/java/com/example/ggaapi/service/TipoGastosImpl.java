package com.example.ggaapi.service;

import com.example.ggaapi.model.Tipo_gastos;
import com.example.ggaapi.repository.ITipoGastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoGastosImpl implements ITipoGastoService{

    @Autowired
    private ITipoGastosRepository repoTipoGasto;

    @Override
    public List<Tipo_gastos> getAllTipoGastos(){
        return repoTipoGasto.findAll();
    }

}
