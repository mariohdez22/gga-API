package com.example.ggaapi.dto;

import com.example.ggaapi.model.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter @Setter
public class RegistroGastosDTO {

    public Integer idGasto;
    public String codigoCompra;
    public String descripcion;
    public BigDecimal totalGastos;
    public Integer idTipoGastos;
    public Integer idDepartamento;
    public Integer idColaborador;
    public Integer idTipoTransaccion;

    /*
     *
     *   RELACIONES
     *
     */

    public Tipo_gastos tipoGastos;
    public Gestion_departamento departamento;
    public Colaboradores colaborador;
    public Tipo_transaccion tipoTransaccion;

    /*
    *
    *   METODOS
    *
    */

    private boolean isBodyEmpty(){

        return  codigoCompra == null || codigoCompra.isEmpty() ||
                descripcion == null || descripcion.isEmpty() ||
                totalGastos == null ||
                idTipoGastos == null ||
                idDepartamento == null ||
                idColaborador == null ||
                idTipoTransaccion == null;
    }

    public static List<RegistroGastosDTO> MapperAllList(List<Registro_gastos> gastos){

        List<RegistroGastosDTO> dtoList = new LinkedList<>();

        for(Registro_gastos g : gastos){

            RegistroGastosDTO dto = new RegistroGastosDTO();

            dto.setIdGasto(g.getIdGasto());
            dto.setCodigoCompra(g.getCodigoCompra());
            dto.setDescripcion(g.getDescripcion());
            dto.setTotalGastos(g.getTotalGastos());
            dto.setIdTipoGastos(g.getTipoGastos().getIdTipoGasto());
            dto.setIdDepartamento(g.getDepartamento().getIdDepartamento());
            dto.setIdColaborador(g.getColaborador().getIdColaborador());
            dto.setIdTipoTransaccion(g.getTipoTransaccion().getIdTipoTransaccion());

            dto.setTipoGastos(g.getTipoGastos());
            dto.setDepartamento(g.getDepartamento());
            dto.setColaborador(g.getColaborador());
            dto.setTipoTransaccion(g.getTipoTransaccion());

            dtoList.add(dto);
        }

        if(dtoList.isEmpty()){
            return new LinkedList<>();
        }

        return dtoList;
    }

    public Registro_gastos Mapper(){

        if(this.isBodyEmpty()){
            return null;
        }

        Registro_gastos gasto = new Registro_gastos();

        gasto.setCodigoCompra(codigoCompra);
        gasto.setDescripcion(descripcion);
        gasto.setTotalGastos(totalGastos);

        gasto.setColaborador(new Colaboradores());
        gasto.setDepartamento(new Gestion_departamento());
        gasto.setTipoGastos(new Tipo_gastos());
        gasto.setTipoTransaccion(new Tipo_transaccion());

        gasto.getColaborador().setIdColaborador(idColaborador);
        gasto.getDepartamento().setIdDepartamento(idDepartamento);
        gasto.getTipoGastos().setIdTipoGasto(idTipoGastos);
        gasto.getTipoTransaccion().setIdTipoTransaccion(idTipoTransaccion);

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

        gasto.setColaborador(new Colaboradores());
        gasto.setDepartamento(new Gestion_departamento());
        gasto.setTipoGastos(new Tipo_gastos());
        gasto.setTipoTransaccion(new Tipo_transaccion());

        gasto.getColaborador().setIdColaborador(idColaborador);
        gasto.getDepartamento().setIdDepartamento(idDepartamento);
        gasto.getTipoGastos().setIdTipoGasto(idTipoGastos);
        gasto.getTipoTransaccion().setIdTipoTransaccion(idTipoTransaccion);

        return gasto;

    }

}
