package com.example.ggaapi.controller;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.repository.IColaboradoresRepository;
import com.example.ggaapi.service.IColaboradoresService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gga_api")
public class ColaboradoresController {

    @Autowired
    private IColaboradoresService servColaboradores;

    @GetMapping("/getAllColaboradores")
    public ResponseEntity<?> getAllColaboradores(){
        List<Colaboradores> listColaboradores = servColaboradores.getAllColaboradores();

        if(listColaboradores.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(listColaboradores);
    }

    @GetMapping("/getColaborador/{id}")
    public ResponseEntity<?> getColaborador(@PathVariable("id") Integer id){
        Optional<Colaboradores> optColaborador = servColaboradores.getColaborador(id);
        if(optColaborador.isPresent()){
            return ResponseEntity.ok(optColaborador.get());
        }
        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createColaborador")
    public ResponseEntity<?> createColaborador(@RequestBody ColaboradoresDTO colaboradorDTO){

        if(servColaboradores.createColaborador(colaboradorDTO).isPresent()){
            return new ResponseEntity<>(201, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateColaborador")
    public ResponseEntity<?> updateColaborador(@RequestBody ColaboradoresDTO colaboradorDTO){
        if(servColaboradores.updateColaborador(colaboradorDTO).isPresent()){
            return new ResponseEntity<>(200,HttpStatus.OK);
        }
        return new ResponseEntity<>(400 + " No se pudo actualizar, por favor revisar la informacion", HttpStatus.BAD_REQUEST);
    }

}
