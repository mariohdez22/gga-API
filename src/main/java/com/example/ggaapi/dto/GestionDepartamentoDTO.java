package com.example.ggaapi.dto;

import com.example.ggaapi.model.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter @Setter
public class GestionDepartamentoDTO {

    public Integer idDepartamento;
    public String departamento;
    public String descripcion;
    public Integer cantidadPresupuesto;
    public Integer idColaborador;
    public Integer idColor;
    public Integer idTipoGestion;

    /*
     *
     *   RELACIONES
     *
     */

    public Colaboradores colaborador;
    public Color_tarjeta color;
    public Tipo_Gestion tipoGestion;

    /*
    *
    *       METODOS
    *
    */

    private boolean isBodyEmpty(){

        return  departamento == null || departamento.isEmpty() ||
                descripcion == null || descripcion.isEmpty() ||
                cantidadPresupuesto == null ||
                idColaborador == null ||
                idColor == null ||
                idTipoGestion == null;
    }

    public static List<GestionDepartamentoDTO> MapperAllList(List<Gestion_departamento> depas){

        List<GestionDepartamentoDTO> depasDTO = new LinkedList<>();

        for(Gestion_departamento d : depas){

            GestionDepartamentoDTO depa = new GestionDepartamentoDTO();

            depa.setIdDepartamento(d.getIdDepartamento());
            depa.setDepartamento(d.getDepartamento());
            depa.setDescripcion(d.getDescripcion());
            depa.setCantidadPresupuesto(d.getCantidadPresupuesto());
            depa.setIdColaborador(d.getColaborador().getIdColaborador());
            depa.setIdColor(d.getColor().getIdColor());
            depa.setIdTipoGestion(d.getTipoGestion().getIdTipoGestion());

            depa.setColor(d.getColor());
            depa.setColaborador(d.getColaborador());
            depa.setTipoGestion(d.getTipoGestion());

            depasDTO.add(depa);

        }

        if(depasDTO.isEmpty()){
            return new LinkedList<>();
        }

        return depasDTO;
    }

    public Gestion_departamento Mapper(){

        if(this.isBodyEmpty()){
            return null;
        }

        Gestion_departamento dpt = new Gestion_departamento();

        dpt.setDepartamento(departamento);
        dpt.setDescripcion(descripcion);
        dpt.setCantidadPresupuesto(cantidadPresupuesto);

        dpt.setColor(new Color_tarjeta());
        dpt.setColaborador(new Colaboradores());
        dpt.setTipoGestion(new Tipo_Gestion());

        dpt.getColor().setIdColor(idColor);
        dpt.getColaborador().setIdColaborador(idColaborador);
        dpt.getTipoGestion().setIdTipoGestion(idTipoGestion);

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

        dpt.setColor(new Color_tarjeta());
        dpt.setColaborador(new Colaboradores());
        dpt.setTipoGestion(new Tipo_Gestion());

        dpt.getColor().setIdColor(idColor);
        dpt.getColaborador().setIdColaborador(idColaborador);
        dpt.getTipoGestion().setIdTipoGestion(idTipoGestion);

        return dpt;

    }

}
