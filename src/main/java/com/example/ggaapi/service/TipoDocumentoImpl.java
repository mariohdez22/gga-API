package com.example.ggaapi.service;

import com.example.ggaapi.model.Tipo_documento;
import com.example.ggaapi.repository.ITipoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoImpl implements ITipoDocumentoService{

    @Autowired
    private ITipoDocumentoRepository repoTipo;

    @Override
    public List<Tipo_documento> getAllTipoDocumento(){
        return repoTipo.findAll();
    }

}
