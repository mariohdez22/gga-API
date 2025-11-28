package com.example.ggaapi.repository;

import com.example.ggaapi.model.Tipo_gastos;
import com.example.ggaapi.model.Tipo_pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITipoPagoRepository extends JpaRepository<Tipo_pago, Integer> {

}
