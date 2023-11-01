package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@Entity
@Table(name="registro_gastos")
public class Registro_gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGasto;

    private String codigoCompra;

    private String descripcion;

    private BigDecimal totalGastos;

    @OneToOne
    @JoinColumn(name="idTipoGasto")
    private Tipo_gastos tipoGastos;

    @OneToOne
    @JoinColumn(name="idDepartamento")
    private Gestion_departamento Departamento;

    @OneToOne
    @JoinColumn(name="idColaborador")
    private Colaboradores Colaborador;

}
