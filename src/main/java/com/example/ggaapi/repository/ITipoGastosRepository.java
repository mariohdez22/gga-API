package com.example.ggaapi.repository;

import com.example.ggaapi.model.Tipo_gastos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITipoGastosRepository extends JpaRepository<Tipo_gastos, Integer> {

    List<Tipo_gastos> findAllByTipoGastoContaining(String tipoGasto);

}
