package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.repository.IRegistroGastosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroGastoImpl implements IRegistroGastoService{

    @Autowired
    private IRegistroGastosRepository repoGastos;

    @Override
    public List<Registro_gastos> getAllGastos(){
        return repoGastos.findAll();
    }

    @Override
    public Optional<Registro_gastos> getGasto(Integer id){
        return repoGastos.findById(id);
    }

    @Override
    public Optional<Registro_gastos> createGasto(RegistroGastosDTO gastosDTO){
        Registro_gastos gasto = gastosDTO.Mapper();
        Optional<Registro_gastos> optGasto = Optional.ofNullable(gasto);
        if(optGasto.isPresent()){
            return Optional.of(repoGastos.save(gasto));
        }
        return optGasto;
    }

    @Override
    public Optional<Registro_gastos> updateGasto(RegistroGastosDTO gastosDTO){
        Registro_gastos gasto = gastosDTO.MapperUpdate();
        Optional<Registro_gastos> optGasto = Optional.ofNullable(gasto);
        if(optGasto.isPresent()){
            return Optional.of(repoGastos.save(gasto));
        }
        return optGasto;
    }

}
