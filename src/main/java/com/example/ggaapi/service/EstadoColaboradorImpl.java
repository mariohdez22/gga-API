package com.example.ggaapi.service;

import com.example.ggaapi.model.Cargo_colaborador;
import com.example.ggaapi.model.Estado_colaborador;
import com.example.ggaapi.repository.IEstadoColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoColaboradorImpl implements IEstadoColaboradorService{

    @Autowired
    private IEstadoColaboradorRepository repoEstado;
    @Override
    public List<Estado_colaborador> getAllEstados() {
        return repoEstado.findAll();
    }
}
