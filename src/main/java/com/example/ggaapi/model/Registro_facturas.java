package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name="registro_facturas")
public class Registro_facturas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacturas;

    private String codigoFactura;

    private String nrc;

    private String localVendedor;

    private String descripcionFactura;

    private Date fechaFacturacion;

    private String documento;

    private String direccion;

    private BigDecimal subTotal;

    private BigDecimal subImpuesto;

    private BigDecimal total;

    @OneToOne
    @JoinColumn(name="idGasto")
    private Registro_gastos gasto;

    @OneToOne
    @JoinColumn(name="idTipoFactura")
    private Tipo_facturas tipoFactura;

    @OneToOne
    @JoinColumn(name="idTipoPago")
    private Tipo_pago tipoPago;

    @OneToOne
    @JoinColumn(name="idTipoDocumento")
    private Tipo_documento tipoDocumento;

}
