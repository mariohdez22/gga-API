package com.example.ggaapi.repository;

import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRegistroProductosRepository extends JpaRepository<Registro_productos,Integer> {

    List<Registro_productos> findAllByFacturas(Registro_facturas facturas);

}
