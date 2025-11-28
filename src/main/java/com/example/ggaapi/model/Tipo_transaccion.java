package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_transaccion")
@Getter @Setter
public class Tipo_transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoTransaccion;
    private String tipoTransaccion;

}
