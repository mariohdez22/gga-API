package com.example.ggaapi.dto;

import com.example.ggaapi.model.Color_tarjeta;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

@Getter @Setter
public class ColorTarjetaDTO {

    public Integer idColor;
    public String color;

    /*
    *
    * METODOS
    *
    */

    public static List<ColorTarjetaDTO> MapperAllList(List<Color_tarjeta> colores){

        List<ColorTarjetaDTO> dtoList = new LinkedList<>();

        for(Color_tarjeta c : colores){

            ColorTarjetaDTO dto = new ColorTarjetaDTO();

            dto.setIdColor(c.getIdColor());
            dto.setColor(c.getColor());

            dtoList.add(dto);
        }

        if(dtoList.isEmpty()){
            return new LinkedList<>();
        }

        return dtoList;
    }

}
