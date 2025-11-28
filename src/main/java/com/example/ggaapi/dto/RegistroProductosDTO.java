package com.example.ggaapi.dto;

import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_productos;
import com.example.ggaapi.model.Registro_productos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter @Setter
public class RegistroProductosDTO {
    
    public Integer idProducto;
    public String nombre;
    public String descripcion;
    public BigDecimal precio;
    public Integer cantidad;
    public BigDecimal subtotal;
    public Integer idFactura;

    /*
     *
     *   RELACIONES
     *
     */
    public Registro_facturas facturas;

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
                idFactura == null;
    }

    public static List<RegistroProductosDTO> MapperAllList(List<Registro_productos> productos){

        List<RegistroProductosDTO> dtoList = new LinkedList<>();

        for (Registro_productos p : productos){

            RegistroProductosDTO dto = new RegistroProductosDTO();

            dto.setIdProducto(p.getIdProducto());
            dto.setNombre(p.getNombre());
            dto.setDescripcion(p.getDescripcion());
            dto.setPrecio(p.getPrecio());
            dto.setCantidad(p.getCantidad());
            dto.setSubtotal(p.getSubtotal());
            dto.setIdFactura(p.getFacturas().getIdFacturas());

            dto.setFacturas(p.getFacturas());

            dtoList.add(dto);

        }

        if(dtoList.isEmpty()){
            return new LinkedList<>();
        }

        return dtoList;

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

        producto.setFacturas(new Registro_facturas());
        producto.getFacturas().setIdFacturas(idFactura);

        return producto;

    }

    public Registro_productos MapperUpdate(){

        if(this.isBodyEmpty() || idProducto == null){
            return null;
        }

        Registro_productos producto = new Registro_productos();

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setCantidad(cantidad);
        producto.setSubtotal(subtotal);

        producto.setFacturas(new Registro_facturas());
        producto.getFacturas().setIdFacturas(idFactura);

        return producto;

    }

}
