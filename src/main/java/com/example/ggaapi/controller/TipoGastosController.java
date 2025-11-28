package com.example.ggaapi.controller;

import com.example.ggaapi.model.Estado_colaborador;
import com.example.ggaapi.model.Tipo_gastos;
import com.example.ggaapi.service.ITipoGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class TipoGastosController {

    @Autowired
    private ITipoGastoService servTipo;

    @GetMapping("/getAllTipoGastos")
    public ResponseEntity<?> getAllTipoGastos(){

        List<Tipo_gastos> listTipo = servTipo.getAllTipoGastos();

        if (listTipo.isEmpty())
        {
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(listTipo);

    }


}
