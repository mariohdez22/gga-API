package com.example.ggaapi.repository;

import com.example.ggaapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IRegistroGastosRepository extends JpaRepository<Registro_gastos,Integer> {

    List<Registro_gastos> findAllByDepartamentoOrderByIdGastoDesc(Gestion_departamento depa);

    List<Registro_gastos> findAllByCodigoCompra(String codigo);

    List<Registro_gastos> findAllByCodigoCompraContainingOrDescripcionContaining(String codigoCompra, String descripcion);

    List<Registro_gastos> findAllByTipoGastosContaining(Tipo_gastos tipoGastos);

    List<Registro_gastos> findAllByTipoTransaccion(Tipo_transaccion tipoTransaccion);
}
