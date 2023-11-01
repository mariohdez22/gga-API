package com.example.ggaapi.dto;

import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_productos;
import com.example.ggaapi.model.Registro_productos;
import jakarta.persistence.*;

import java.math.BigDecimal;

public class RegistroProductosDTO {
    
    public Integer idProducto;

    public String nombre;

    public String descripcion;

    public BigDecimal precio;

    public Integer cantidad;

    public BigDecimal subtotal;
    
    public Registro_facturas Facturas;

    /*
     *
     *   METODOS
     *
     * */

    private boolean isBodyEmpty(){

        return  nombre == null || nombre.isEmpty() ||
                descripcion == null || descripcion.isEmpty() ||
                precio == null ||
                cantidad == null ||
                subtotal == null ||
                Facturas == null || Facturas.getIdFacturas() == null;
    }

    public Registro_productos Mapper(){

        if(this.isBodyEmpty()){
            return null;
        }

        Registro_productos producto = new Registro_productos();

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setSubtotal(subtotal);
        producto.setFacturas(Facturas);

        return producto;

    }

    public Registro_productos MapperUpdate(){

        if(this.isBodyEmpty() || idProducto == null){
            return null;
        }

        Registro_productos producto = new Registro_productos();

        producto.setIdProducto(idProducto);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setSubtotal(subtotal);
        producto.setFacturas(Facturas);

        return producto;

    }

}
