package com.example.ggaapi.service;

import com.example.ggaapi.model.Color_tarjeta;
import com.example.ggaapi.repository.IColorTarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorTarjetaImpl implements IColorTarjetaService {

    @Autowired
    private IColorTarjetaRepository repoColor;

    @Override
    public List<Color_tarjeta> getAllColores(){
        return repoColor.findAll();
    }

}
