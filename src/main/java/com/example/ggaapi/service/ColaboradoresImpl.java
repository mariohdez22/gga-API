package com.example.ggaapi.service;

import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.repository.IColaboradoresRepository;
import jakarta.persistence.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradoresImpl implements IColaboradoresService{

    @Autowired
    private IColaboradoresRepository repoColaboradores;

    @Override
    public List<Colaboradores> getAllColaboradores(){
        return repoColaboradores.findAll();
    }

    @Override
    public Optional<Colaboradores> getColaborador(Integer id){
        return repoColaboradores.findById(id);
    }

    @Override
    public Optional<Colaboradores> createColaborador(ColaboradoresDTO colaboradorDTO){
        Colaboradores colaborador = colaboradorDTO.Mapper();
        Optional<Colaboradores> opt = Optional.ofNullable(colaborador);
        if(opt.isPresent()){
            return Optional.of(repoColaboradores.save(colaborador));
        }
        return opt;
    }

    @Override
    public Optional<Colaboradores> updateColaborador(ColaboradoresDTO colaboradorDTO){
        Colaboradores colaborador = colaboradorDTO.MapperUpdate();
        Optional<Colaboradores> opt = Optional.ofNullable(colaborador);
        if(opt.isPresent()){
            return Optional.of(repoColaboradores.save(colaborador));
        }
        return opt;

    }

}
