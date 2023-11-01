package com.example.ggaapi.service;

import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.model.Colaboradores;

import java.util.List;
import java.util.Optional;

public interface IColaboradoresService {

    List<Colaboradores> getAllColaboradores();
    List<Colaboradores> getColaboradoresVigentes();
    List<Colaboradores> getColaboradoresSuspendidos();
    List<Colaboradores> getColaboradoresNoDisponibles();
    Optional<Colaboradores> getColaborador(Integer id);
    Optional<Colaboradores> createColaborador(ColaboradoresDTO colaboradorDTO);
    Optional<Colaboradores> updateColaborador(ColaboradoresDTO colaboradorDTO);

}
