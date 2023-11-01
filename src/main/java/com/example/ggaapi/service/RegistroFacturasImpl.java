package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroFacturasDTO;
import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.repository.IRegistroFacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroFacturasImpl implements IRegistroFacturasService {

    @Autowired
    private IRegistroFacturasRepository repoFacturas;

    @Override
    public List<Registro_facturas> getAllFacturas(){
        return repoFacturas.findAll();
    }

    @Override
    public Optional<Registro_facturas> getFactura(Integer id){
        return repoFacturas.findById(id);
    }

    @Override
    public Optional<Registro_facturas> createFactura(RegistroFacturasDTO facturaDTO){
        Registro_facturas factura = facturaDTO.Mapper();
        Optional<Registro_facturas> optFactura = Optional.ofNullable(factura);

        if(optFactura.isPresent()){
            return Optional.of(repoFacturas.save(factura));
        }
        return optFactura;
    }

    @Override
    public Optional<Registro_facturas> updateFactura(RegistroFacturasDTO facturaDTO){
        Registro_facturas factura = facturaDTO.MapperUpdate();
        Optional<Registro_facturas> optFactura = Optional.ofNullable(factura);

        if(optFactura.isPresent()){
            System.out.println("ESTE ES EL ID: " + optFactura.get().getIdFacturas());
            return Optional.of(repoFacturas.save(factura));
        }
        return optFactura;
    }

}
