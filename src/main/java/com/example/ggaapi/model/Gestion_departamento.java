package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="gestion_departamento")
public class Gestion_departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;
    private String departamento;
    private String descripcion;
    private Integer cantidadPresupuesto;

    @ManyToOne
    @JoinColumn(name="idColor")
    private Color_tarjeta color;

    @ManyToOne
    @JoinColumn(name = "idColaborador")
    private Colaboradores colaborador;

    @ManyToOne
    @JoinColumn(name = "idTipoGestion")
    private Tipo_Gestion tipoGestion;

}
