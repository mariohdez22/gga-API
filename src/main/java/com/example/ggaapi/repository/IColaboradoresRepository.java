package com.example.ggaapi.repository;

import com.example.ggaapi.model.Colaboradores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IColaboradoresRepository extends JpaRepository<Colaboradores, Integer>
{
    List<Colaboradores> findByEstado(String valor);
}

/*



*/
