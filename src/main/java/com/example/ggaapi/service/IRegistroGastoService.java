package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.model.Registro_gastos;

import java.util.List;
import java.util.Optional;

public interface IRegistroGastoService {

    List<Registro_gastos> getAllGastos();
    List<Registro_gastos> getAllGastosDepa(Integer id);
    List<Registro_gastos> getAllGastosLike(String data, Integer id);
    List<Registro_gastos> getAllGastosTransac(Integer id);
    RegistroGastosDTO getGasto(Integer id);
    Optional<Registro_gastos> createGasto(RegistroGastosDTO gastosDTO);
    Optional<Registro_gastos> updateGasto(RegistroGastosDTO gastosDTO);
    String GeneracionCodigo();
    String ObtencionUltimoCodigo();
    Boolean VerificarCodigoUnico(String codigo);
}
