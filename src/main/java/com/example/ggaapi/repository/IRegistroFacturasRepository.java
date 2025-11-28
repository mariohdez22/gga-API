package com.example.ggaapi.repository;

import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_gastos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRegistroFacturasRepository extends JpaRepository<Registro_facturas,Integer> {

    List<Registro_facturas> findAllByGasto(Registro_gastos gasto);

    List<Registro_facturas> findAllByCodigoFacturaContainingOrNrcOrLocalVendedorContainingOrDescripcionFacturaContainingOrDocumentoContainingOrDireccionContaining
            (String codigoFactura,
             String nrc,
             String localVendedor,
             String descripcionFactura,
             String documento,
             String direccion);

}
