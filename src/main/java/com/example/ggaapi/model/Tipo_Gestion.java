package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tipo_gestion")
@Getter @Setter
public class Tipo_Gestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoGestion;
    private String tipoGestion;

}
