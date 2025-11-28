package com.example.ggaapi.controller;

import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.dto.ColorTarjetaDTO;
import com.example.ggaapi.model.Color_tarjeta;
import com.example.ggaapi.service.IColorTarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gga_api")
public class ColorTarjetaController {

    @Autowired
    private IColorTarjetaService servColor;

    @GetMapping("/getAllColores")
    public ResponseEntity<?> getAllColores(){
        List<Color_tarjeta> listColores = servColor.getAllColores();

        if(listColores.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listColores);
    }

}
