package com.example.ggaapi.controller;

import com.example.ggaapi.model.Estado_colaborador;
import com.example.ggaapi.model.Tipo_documento;
import com.example.ggaapi.service.ITipoDocumentoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gga_api")
public class TipoDocumentoController {

    @Autowired
    private ITipoDocumentoService servTipo;

    @GetMapping("/getAllTipoDocumento")
    private ResponseEntity<?> getAllTipoDocumento(){
        List<Tipo_documento> listTipo = servTipo.getAllTipoDocumento();

        if (listTipo.isEmpty())
        {
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(listTipo);
    }

}
