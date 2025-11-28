package com.example.ggaapi.controller;

import com.example.ggaapi.dto.RegistroProductosDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Registro_productos;
import com.example.ggaapi.service.IRegistroProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gga_api")
public class RegistroProductosController {

    @Autowired
    private IRegistroProductosService servProductos;

    @GetMapping("/getAllProductos")
    public ResponseEntity<?> getAllProductos(){
        List<RegistroProductosDTO> productos = RegistroProductosDTO.MapperAllList(servProductos.getAllProducts());
        if(productos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/getProducto/{id}")
    public ResponseEntity<?> getProducto(@PathVariable("id") Integer id){
        RegistroProductosDTO producto = servProductos.getProduct(id);
        if(producto != null){
            return ResponseEntity.ok(producto);
        }
        return new ResponseEntity<>(404 + " No se encontro el resultado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getProductoByFactura/{id}")
    public  ResponseEntity<?> getProductoByIdFactura(@PathVariable("id") Integer id){
        List<RegistroProductosDTO> productos = RegistroProductosDTO.MapperAllList(servProductos.getAllByIdFactura(id));
        if(productos.isEmpty()){
            return new ResponseEntity<>(404 + " No se encontraron resultados", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(productos);
    }

    /*@PostMapping("/createProducto")
    public ResponseEntity<?> createProducto(@RequestBody RegistroProductosDTO productoDTO){
        if(servProductos.createProduct(productoDTO).isPresent()){
            return new ResponseEntity<>(201, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateProducto")
    public ResponseEntity<?> updateProducto(@RequestBody RegistroProductosDTO productoDTO){
        if(servProductos.updateProduct(productoDTO).isPresent()){
            return new ResponseEntity<>(200, HttpStatus.OK);
        }
        return new ResponseEntity<>(400, HttpStatus.BAD_REQUEST);
    }*/
}
