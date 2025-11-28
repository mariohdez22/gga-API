package com.example.ggaapi.controller;

import com.example.ggaapi.model.Tipo_Gestion;
import com.example.ggaapi.service.ITipoGestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class TipoGestionController {

    @Autowired
    private ITipoGestion servTipoGestion;

    @GetMapping("/getAllTipoGestion")
    public ResponseEntity<?> getAllTipoGestion(){

        List<Tipo_Gestion> tipos = servTipoGestion.getAllTipos();

        if(tipos.isEmpty()){
            return new ResponseEntity<>(404, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tipos);
    }

}
