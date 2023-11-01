package com.example.ggaapi.service;

import com.example.ggaapi.model.Cargo_colaborador;
import com.example.ggaapi.repository.ICargoColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoColaboradorImpl implements ICargoColaboradorService{

    @Autowired
    private ICargoColaboradorRepository repoCargo;
    @Override
    public List<Cargo_colaborador> getAllCargos() {
        return repoCargo.findAll();
    }
}
