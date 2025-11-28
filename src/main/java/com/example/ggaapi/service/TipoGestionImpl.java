package com.example.ggaapi.service;

import com.example.ggaapi.model.Tipo_Gestion;
import com.example.ggaapi.repository.ITipoGestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoGestionImpl implements ITipoGestion {

    @Autowired
    private ITipoGestionRepository repoTipos;

    @Override
    public List<Tipo_Gestion> getAllTipos(){
        return repoTipos.findAll(Sort.by(Sort.Direction.DESC,"idTipoGestion"));
    }

}
