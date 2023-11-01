package com.example.ggaapi.dto;

import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Gestion_departamento;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.model.Tipo_gastos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class RegistroGastosDTO {

    public Integer idGasto;

    public String codigoCompra;

    public String descripcion;

    public BigDecimal totalGastos;

    public Tipo_gastos tipoGastos;

    public Gestion_departamento Departamento;

    public Colaboradores Colaborador;

    /*
    *
    *   METODOS
    *
    * */

    private boolean isBodyEmpty(){

        return  codigoCompra == null || codigoCompra.isEmpty() ||
                descripcion == null || descripcion.isEmpty() ||
                tipoGastos == null || tipoGastos.getIdTipoGasto() == null||
                Departamento == null || Departamento.getIdDepartamento() == null ||
                Colaborador == null || Colaborador.getIdColaborador() == null;
    }

    public Registro_gastos Mapper(){

        if(this.isBodyEmpty()){
            return null;
        }

        Registro_gastos gasto = new Registro_gastos();

        gasto.setCodigoCompra(codigoCompra);
        gasto.setDescripcion(descripcion);
        gasto.setTotalGastos(totalGastos);
        gasto.setColaborador(Colaborador);
        gasto.setDepartamento(Departamento);
        gasto.setTipoGastos(tipoGastos);

        return gasto;

    }

    public Registro_gastos MapperUpdate(){

        if(this.isBodyEmpty() || idGasto == null){
            return null;
        }

        Registro_gastos gasto = new Registro_gastos();

        gasto.setIdGasto(idGasto);
        gasto.setCodigoCompra(codigoCompra);
        gasto.setDescripcion(descripcion);
        gasto.setTotalGastos(totalGastos);
        gasto.setColaborador(Colaborador);
        gasto.setDepartamento(Departamento);
        gasto.setTipoGastos(tipoGastos);

        return gasto;

    }

}
