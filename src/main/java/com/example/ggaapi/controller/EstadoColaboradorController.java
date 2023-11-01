package com.example.ggaapi.controller;

import com.example.ggaapi.model.Estado_colaborador;
import com.example.ggaapi.service.IEstadoColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class EstadoColaboradorController {

    @Autowired
    private IEstadoColaboradorService servEstado;

    @GetMapping("/getAllEstados")
    public List<Estado_colaborador> getAllEstados(){
        return servEstado.getAllEstados();
    }

}
