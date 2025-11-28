package com.example.ggaapi.controller;

import com.example.ggaapi.dto.RegistroFacturasDTO;
import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.dto.RegistroProductosDTO;
import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.service.IRegistroFacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gga_api")
public class RegistroFacturasController {

    @Autowired
    private IRegistroFacturasService servFacturas;

    @GetMapping("/getAllFacturas")
    public ResponseEntity<?> getAllFacturas(){
        List<RegistroFacturasDTO> facturas = RegistroFacturasDTO.MapperAllList(servFacturas.getAllFacturas());

        if(facturas.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/getFactura/{id}")
    public ResponseEntity<?> getFactura(@PathVariable("id") Integer id){
        RegistroFacturasDTO factura = servFacturas.getFactura(id);
        if(factura != null){
            return ResponseEntity.ok(factura);
        }
        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getFacturaByIdGasto/{id}")
    public  ResponseEntity<?> getFacturaByIdGasto(@PathVariable("id") Integer id){
        List<RegistroFacturasDTO> facturas = RegistroFacturasDTO.MapperAllList(servFacturas.getAllByIdGasto(id));
        if(facturas.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/getFacturaLike/{data}/{idGasto}")
    public ResponseEntity<?> getFacturaLike(@PathVariable("data") String data, @PathVariable("idGasto") Integer id){
        List<RegistroFacturasDTO> facturas = RegistroFacturasDTO.MapperAllList(servFacturas.getAllFacturasLike(data, id));

        if(!facturas.isEmpty()){
            return ResponseEntity.ok(facturas);
        }

        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createFactura")
    public ResponseEntity<?> createFactura(@RequestBody RegistroFacturasDTO facturaDTO){
        if(servFacturas.createFactura(facturaDTO)){
            return ResponseEntity.ok("Factura y productos guardados");
        }
        return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateFactura")
    public ResponseEntity<?> updateFactura(@RequestBody RegistroFacturasDTO facturaDTO){
        if(servFacturas.updateFactura(facturaDTO).isPresent()){
            return new ResponseEntity<>(200, HttpStatus.OK);
        }
        return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
    }


}
