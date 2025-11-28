package com.example.ggaapi.controller;

import com.example.ggaapi.model.Tipo_gastos;
import com.example.ggaapi.model.Tipo_pago;
import com.example.ggaapi.service.ITipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class TipoPagoController {

    @Autowired
    private ITipoPagoService servTipo;

    @GetMapping("/getAllTipoPago")
    public ResponseEntity<?> getAllTipoPago(){
        List<Tipo_pago> listTipo = servTipo.getAllTipoPago();

        if (listTipo.isEmpty())
        {
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(listTipo);
    }

}
