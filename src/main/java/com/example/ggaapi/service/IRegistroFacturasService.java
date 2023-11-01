package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroFacturasDTO;
import com.example.ggaapi.model.Registro_facturas;

import java.util.List;
import java.util.Optional;

public interface IRegistroFacturasService {

    List<Registro_facturas> getAllFacturas();
    Optional<Registro_facturas> getFactura(Integer id);
    Optional<Registro_facturas> createFactura(RegistroFacturasDTO facturaDTO);
    Optional<Registro_facturas> updateFactura(RegistroFacturasDTO facturaDTO);

}
