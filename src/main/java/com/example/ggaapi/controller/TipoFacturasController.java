package com.example.ggaapi.controller;

import com.example.ggaapi.model.Estado_colaborador;
import com.example.ggaapi.model.Tipo_facturas;
import com.example.ggaapi.service.ITipoFacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class TipoFacturasController {

    @Autowired
    private ITipoFacturasService servTipo;

    @GetMapping("/getAllTipoFacturas")
    public ResponseEntity<?> getAllTipoFacturas(){
        List<Tipo_facturas> listTipo = servTipo.getAllTipoFacturas();

        if (listTipo.isEmpty())
        {
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(listTipo);
    }

}
