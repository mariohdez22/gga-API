package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroProductosDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_productos;
import com.example.ggaapi.repository.IRegistroProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroProductosImpl implements IRegistroProductosService{

    @Autowired
    private IRegistroProductosRepository repoProductos;

    @Override
    public List<Registro_productos> getAllProducts(){
        return repoProductos.findAll();
    }

    @Override
    public Optional<Registro_productos> getProduct(Integer id){
        return repoProductos.findById(id);
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
