package com.example.ggaapi.controller;

import com.example.ggaapi.model.Tipo_Gestion;
import com.example.ggaapi.model.Tipo_transaccion;
import com.example.ggaapi.service.ITipoGestion;
import com.example.ggaapi.service.ITipoTransaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class TipoTransaccionController {

    @Autowired
    private ITipoTransaccion servTipoTransaccion;

    @GetMapping("/getAllTipoTransaccion")
    public ResponseEntity<?> getAllTipoTransaccion(){

        List<Tipo_transaccion> tipos = servTipoTransaccion.getAllTipos();

        if(tipos.isEmpty()){
            return new ResponseEntity<>(404, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tipos);
    }

}
