package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="tipo_gastos")
public class Tipo_gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoGasto;

    private String tipoGasto;

}
