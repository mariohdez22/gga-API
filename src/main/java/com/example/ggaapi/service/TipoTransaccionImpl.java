package com.example.ggaapi.service;

import com.example.ggaapi.model.Tipo_transaccion;
import com.example.ggaapi.repository.ITipoTransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTransaccionImpl implements ITipoTransaccion{

    @Autowired
    private ITipoTransaccionRepository repoTipo;

    @Override
    public List<Tipo_transaccion> getAllTipos(){
        return repoTipo.findAll(Sort.by(Sort.Direction.DESC,"idTipoTransaccion"));
    }

}
