package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroProductosDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_productos;
import com.example.ggaapi.repository.IRegistroProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroProductosImpl implements IRegistroProductosService{

    @Autowired
    private IRegistroProductosRepository repoProductos;

    @Override
    public List<Registro_productos> getAllProducts(){
        return repoProductos.findAll(Sort.by(Sort.Direction.DESC,"idProducto"));
    }

    @Override
    public RegistroProductosDTO getProduct(Integer id){

        Optional<Registro_productos> opt = repoProductos.findById(id);

        if(opt.isEmpty()){
            return null;
        }

        Registro_productos p = opt.get();
        RegistroProductosDTO dto = new RegistroProductosDTO();

        dto.setIdProducto(p.getIdProducto());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecio(p.getPrecio());
        dto.setCantidad(p.getCantidad());
        dto.setSubtotal(p.getSubtotal());
        dto.setIdFactura(p.getFacturas().getIdFacturas());

        dto.setFacturas(p.getFacturas());

        return dto;
    }

    @Override
    public List<Registro_productos> getAllByIdFactura(Integer id){

        Registro_facturas f = new Registro_facturas();
        f.setIdFacturas(id);

        List<Registro_productos> productos = repoProductos.findAllByFacturas(f);

        if(productos.isEmpty()){
            return new LinkedList<>();
        }

        return productos;

    }

    @Override
    public Optional<Registro_productos> createProduct(RegistroProductosDTO productoDTO){
        Registro_productos producto = productoDTO.Mapper();
        Optional<Registro_productos> opt = Optional.ofNullable(producto);
        if(opt.isPresent()){
            return Optional.of(repoProductos.save(producto));
        }
        return opt;
    }

    @Override
    public Optional<Registro_productos> updateProduct(RegistroProductosDTO productoDTO){
        Registro_productos producto = productoDTO.MapperUpdate();
        Optional<Registro_productos> opt = Optional.ofNullable(producto);
        if(opt.isPresent()){
            return Optional.of(repoProductos.save(producto));
        }
        return opt;
    }
}
