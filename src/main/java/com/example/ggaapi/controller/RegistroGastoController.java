package com.example.ggaapi.controller;

import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.service.IRegistroGastoService;
import jakarta.persistence.criteria.CriteriaBuilder;
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
        List<RegistroGastosDTO> gastos = RegistroGastosDTO.MapperAllList(servGastos.getAllGastos());

        if(gastos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/getAllGastosDepa/{id}")
    public ResponseEntity<?> getAllGastosDepa(@PathVariable("id") Integer id){
        List<RegistroGastosDTO> gastos = RegistroGastosDTO.MapperAllList(servGastos.getAllGastosDepa(id));

        if(gastos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(gastos);
    }

    @GetMapping("/getGasto/{id}")
    public ResponseEntity<?> getGasto(@PathVariable("id") Integer id){
        RegistroGastosDTO gasto = servGastos.getGasto(id);
        if(gasto != null){
            return ResponseEntity.ok(gasto);
        }
        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllGastoLike/{data}/{idDepa}")
    public ResponseEntity<?> getAllGastoLike(@PathVariable("data") String data, @PathVariable("idDepa") Integer id){

        List<RegistroGastosDTO> gastos = RegistroGastosDTO.MapperAllList(servGastos.getAllGastosLike(data, id));

        if(!gastos.isEmpty()){
            return ResponseEntity.ok(gastos);
        }

        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/getAllGastoTransac/{idTransac}")
    public ResponseEntity<?> getAllGastoTransac(@PathVariable("idTransac") Integer id){

        List<RegistroGastosDTO> gt = RegistroGastosDTO.MapperAllList(servGastos.getAllGastosTransac(id));

        if(!gt.isEmpty()){
            return ResponseEntity.ok(gt);
        }

        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);

    }


    @GetMapping("/getCodigo")
    public ResponseEntity<?> getCodigo()
    {
        String valor = servGastos.GeneracionCodigo();
        return ResponseEntity.ok(valor);
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
