package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroFacturasDTO;
import com.example.ggaapi.model.Registro_facturas;

import java.util.List;
import java.util.Optional;

public interface IRegistroFacturasService {

    List<Registro_facturas> getAllFacturas();
    List<Registro_facturas> getAllByIdGasto(Integer id);
    List<Registro_facturas> getAllFacturasLike(String data, Integer id);
    RegistroFacturasDTO getFactura(Integer id);
    boolean createFactura(RegistroFacturasDTO facturaDTO);
    Optional<Registro_facturas> updateFactura(RegistroFacturasDTO facturaDTO);

}
