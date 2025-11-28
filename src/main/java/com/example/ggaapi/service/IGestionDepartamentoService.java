package com.example.ggaapi.service;

import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.dto.GestionDepartamentoDTO;
import com.example.ggaapi.model.Gestion_departamento;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IGestionDepartamentoService {

    List<Gestion_departamento> getAllDepartamentos();
    GestionDepartamentoDTO getDepartamento(Integer id);
    Optional<Gestion_departamento> createDepartamento(GestionDepartamentoDTO departamentoDTO);
    Optional<Gestion_departamento> updateDepartamento(GestionDepartamentoDTO departamentoDTO);



}
