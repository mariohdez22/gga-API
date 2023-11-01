package com.example.ggaapi.controller;

import com.example.ggaapi.dto.GestionDepartamentoDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Gestion_departamento;
import com.example.ggaapi.service.IGestionDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gga_api")
public class GestionDepartamentoController {

    @Autowired
    private IGestionDepartamentoService servDepartamentos;

    @GetMapping("/getAllDepartamentos")
    public ResponseEntity<?> getAllDepartamentos(){
        List<Gestion_departamento> listDepartamentos = servDepartamentos.getAllDepartamentos();
        if(listDepartamentos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listDepartamentos);
    }

    @GetMapping("/getDepartamento/{id}")
    public ResponseEntity<?> getDepartamento(@PathVariable("id") Integer id){
        Optional<Gestion_departamento> departamento = servDepartamentos.getDepartamento(id);
        if(departamento.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(departamento.get());
    }

    @PostMapping("/createDepartamento")
    public ResponseEntity<?> createDepartamento(@RequestBody GestionDepartamentoDTO departamentoDTO){
        System.out.println(departamentoDTO.descripcion);
        if(servDepartamentos.createDepartamento(departamentoDTO).isPresent()){
            return new ResponseEntity<>(201 + "Nuevo departamento creado",HttpStatus.CREATED);
        }
        return new ResponseEntity<>(400 + " No se pudo crear el departamento, verifique si la informacion esta completa",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateDepartamento")
    public ResponseEntity<?> updateDepartamento(@RequestBody GestionDepartamentoDTO departamentoDTO){
        if(servDepartamentos.updateDepartamento(departamentoDTO).isPresent()){
            return new ResponseEntity<>(200 + "Actualizado satisfactoriamente", HttpStatus.OK);
        }
        return new ResponseEntity<>(400 + " No se pudo actualizar, por favor revisar la informacion", HttpStatus.BAD_REQUEST);
    }

}
