package com.example.ggaapi.controller;

import com.example.ggaapi.model.Cargo_colaborador;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.service.ICargoColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class CargoColaboradorController {

    @Autowired
    private ICargoColaboradorService servCargo;

    @GetMapping("/getAllCargos")
    public ResponseEntity<?> getAllCargos(){
        List<Cargo_colaborador> listCargos = servCargo.getAllCargos();

        if(listCargos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listCargos);
    }

}
