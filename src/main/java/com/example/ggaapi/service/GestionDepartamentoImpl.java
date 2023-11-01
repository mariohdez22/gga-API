package com.example.ggaapi.service;

import com.example.ggaapi.dto.GestionDepartamentoDTO;
import com.example.ggaapi.model.Gestion_departamento;
import com.example.ggaapi.repository.IGestionDepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class GestionDepartamentoImpl implements IGestionDepartamentoService{

    @Autowired
    private IGestionDepartamentosRepository repoDepartamentos;

    @Override
    public List<Gestion_departamento> getAllDepartamentos(){
        return repoDepartamentos.findAll();
    }

    @Override
    public Optional<Gestion_departamento> getDepartamento(Integer id) {
        return repoDepartamentos.findById(id);
    }

    @Override
    public Optional<Gestion_departamento> createDepartamento(GestionDepartamentoDTO departamentoDTO){
        Gestion_departamento departamento = departamentoDTO.Mapper();
        Optional<Gestion_departamento> optDepa = Optional.ofNullable(departamento);
        if(optDepa.isPresent()){
            return Optional.of(repoDepartamentos.save(departamento));
        }
        return optDepa;
    }

    @Override
    public Optional<Gestion_departamento> updateDepartamento(GestionDepartamentoDTO departamentoDTO){
        Gestion_departamento departamento = departamentoDTO.MapperUpdate();
        Optional<Gestion_departamento> optDepa = Optional.ofNullable(departamento);
        if(optDepa.isPresent()){
            return Optional.of(repoDepartamentos.save(departamento));
        }
        return  optDepa;
    }

}
