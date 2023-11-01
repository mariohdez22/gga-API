package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
@Entity
@Table(name = "registro_productos")
public class Registro_productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombre;

    private String descripcion;

    private BigDecimal precio;

    private Integer cantidad;

    private BigDecimal subtotal;

    @OneToOne
    @JoinColumn(name="idFacturas")
    private Registro_facturas Facturas;

}
