package com.example.ggaapi.dto;

import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Gestion_departamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GestionDepartamentoDTO {

    public Integer idDepartamento;

    public String departamento;

    public String descripcion;

    public Integer cantidadPresupuesto;

    public Colaboradores Colaborador;

    /*
    *
    *       METODOS
    *
    */

    public boolean isBodyEmpty(){

        return  departamento == null || departamento.isEmpty() ||
                descripcion == null || descripcion.isEmpty() ||
                cantidadPresupuesto == null ||
                Colaborador == null || Colaborador.getIdColaborador() == null;
    }

    public Gestion_departamento Mapper(){

        if(this.isBodyEmpty()){
            System.out.println(departamento);
            System.out.println(descripcion);
            System.out.println(cantidadPresupuesto);
            System.out.println(Colaborador);
            return null;
        }

        Gestion_departamento dpt = new Gestion_departamento();

        dpt.setDepartamento(departamento);
        dpt.setDescripcion(descripcion);
        dpt.setCantidadPresupuesto(cantidadPresupuesto);
        dpt.setColaborador(Colaborador);

        return dpt;

    }

    public Gestion_departamento MapperUpdate(){

        if(this.isBodyEmpty() || idDepartamento == null){
            return null;
        }

        Gestion_departamento dpt = new Gestion_departamento();

        dpt.setIdDepartamento(idDepartamento);
        dpt.setDepartamento(departamento);
        dpt.setDescripcion(descripcion);
        dpt.setCantidadPresupuesto(cantidadPresupuesto);
        dpt.setColaborador(Colaborador);

        return dpt;

    }

}
