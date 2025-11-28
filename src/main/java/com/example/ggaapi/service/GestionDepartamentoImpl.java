package com.example.ggaapi.service;

import com.example.ggaapi.dto.GestionDepartamentoDTO;
import com.example.ggaapi.model.Gestion_departamento;
import com.example.ggaapi.repository.IGestionDepartamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return repoDepartamentos.findAll(Sort.by(Sort.Direction.DESC,"idDepartamento"));
    }

    @Override
    public GestionDepartamentoDTO getDepartamento(Integer id) {

        Optional<Gestion_departamento> opt = repoDepartamentos.findById(id);

        if(opt.isEmpty()){
            return null;
        }

        Gestion_departamento d = opt.get();
        GestionDepartamentoDTO dto = new GestionDepartamentoDTO();

        dto.setIdDepartamento(d.getIdDepartamento());
        dto.setDepartamento(d.getDepartamento());
        dto.setDescripcion(d.getDescripcion());
        dto.setCantidadPresupuesto(d.getCantidadPresupuesto());
        dto.setIdColaborador(d.getColaborador().getIdColaborador());
        dto.setIdColor(d.getColor().getIdColor());
        dto.setIdTipoGestion(d.getTipoGestion().getIdTipoGestion());

        dto.setColor(d.getColor());
        dto.setColaborador(d.getColaborador());
        dto.setTipoGestion(d.getTipoGestion());

        return dto;
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
