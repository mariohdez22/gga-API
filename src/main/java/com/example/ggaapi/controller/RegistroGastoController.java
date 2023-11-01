package com.example.ggaapi.controller;

import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.service.IRegistroGastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gga_api")
public class RegistroGastoController {

    @Autowired
    private IRegistroGastoService servGastos;

    @GetMapping("/getAllGastos")
    public ResponseEntity<?> getAllGastos(){
        List<Registro_gastos> gastos = servGastos.getAllGastos();
        if(gastos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/getGasto/{id}")
    public ResponseEntity<?> getGasto(@PathVariable("id") Integer id){
        Optional<Registro_gastos> optGasto = servGastos.getGasto(id);
        if(optGasto.isPresent()){
            return ResponseEntity.ok(optGasto.get());
        }
        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createGasto")
    public ResponseEntity<?> createGasto(@RequestBody RegistroGastosDTO gastoDTO){
        if(servGastos.createGasto(gastoDTO).isPresent()){
            return new ResponseEntity<>(200 + " Gasto registrado", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(400 + " No se pudo registrar el gasto", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateGasto")
    public ResponseEntity<?> updateGasto(@RequestBody RegistroGastosDTO gastosDTO){
        if(servGastos.updateGasto(gastosDTO).isPresent()){
            return new ResponseEntity<>(200 + "Actualizado satisfactoriamente", HttpStatus.OK);
        }
        return new ResponseEntity<>(400 + " No se pudo actualizar, por favor revisar la informacion", HttpStatus.BAD_REQUEST);
    }

}
