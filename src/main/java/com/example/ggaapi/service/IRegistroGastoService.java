package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.model.Registro_gastos;

import java.util.List;
import java.util.Optional;

public interface IRegistroGastoService {

    List<Registro_gastos> getAllGastos();
    Optional<Registro_gastos> getGasto(Integer id);
    Optional<Registro_gastos> createGasto(RegistroGastosDTO gastosDTO);
    Optional<Registro_gastos> updateGasto(RegistroGastosDTO gastosDTO);

}
