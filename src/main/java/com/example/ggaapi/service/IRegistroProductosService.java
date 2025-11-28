package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroProductosDTO;
import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_productos;

import java.util.List;
import java.util.Optional;

public interface IRegistroProductosService {

    List<Registro_productos> getAllProducts();
    RegistroProductosDTO getProduct(Integer id);
    Optional<Registro_productos> createProduct(RegistroProductosDTO productoDTO);
    Optional<Registro_productos> updateProduct(RegistroProductosDTO productoDTO);
    List<Registro_productos> getAllByIdFactura(Integer id);

}
