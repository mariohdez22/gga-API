package com.example.ggaapi.dto;

import com.example.ggaapi.model.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter
public class RegistroFacturasDTO {
    
    public Integer idFacturas;

    public String codigoFactura;

    public String nrc;

    public String localVendedor;

    public String descripcionFactura;

    public Date fechaFacturacion;

    public String documento;

    public String direccion;

    public BigDecimal subTotal;

    public BigDecimal subImpuesto;

    public BigDecimal total;
    
    public Registro_gastos gasto;
    
    public Tipo_facturas tipoFactura;
    
    public Tipo_pago tipoPago;

    public Tipo_documento tipoDocumento;

    /*
    *
    *   METODOS
    *
    * */


    private boolean isBodyEmpty(){

        return  codigoFactura == null || codigoFactura.isEmpty() ||
                nrc == null || nrc.isEmpty() ||
                localVendedor == null || localVendedor.isEmpty() ||
                descripcionFactura == null || descripcionFactura.isEmpty() ||
                fechaFacturacion == null ||
                documento == null || documento.isEmpty() ||
                direccion == null || direccion.isEmpty() ||
                total == null ||
                subTotal == null ||
                subImpuesto == null ||
                gasto == null || gasto.getIdGasto() == null ||
                tipoFactura == null || tipoFactura.getIdTipoFactura() == null ||
                tipoPago == null || tipoPago.getIdTipoPago() == null ||
                tipoDocumento == null || tipoDocumento.getIdTipoDocumento() == null;
    }

    public Registro_facturas Mapper(){

        if(this.isBodyEmpty()){
            return null;
        }

        Registro_facturas factura = new Registro_facturas();

        factura.setCodigoFactura(codigoFactura);
        factura.setNrc(nrc);
        factura.setLocalVendedor(localVendedor);
        factura.setDescripcionFactura(descripcionFactura);
        factura.setFechaFacturacion(fechaFacturacion);
        factura.setDocumento(documento);
        factura.setDireccion(direccion);
        factura.setTotal(total);
        factura.setSubTotal(subTotal);
        factura.setSubImpuesto(subImpuesto);
        factura.setGasto(gasto);
        factura.setTipoFactura(tipoFactura);
        factura.setTipoPago(tipoPago);
        factura.setTipoDocumento(tipoDocumento);

        return factura;

    }

    public Registro_facturas MapperUpdate(){

        if(this.isBodyEmpty() || idFacturas == null){
            return null;
        }

        Registro_facturas factura = new Registro_facturas();

        factura.setIdFacturas(idFacturas);
        factura.setCodigoFactura(codigoFactura);
        factura.setNrc(nrc);
        factura.setLocalVendedor(localVendedor);
        factura.setDescripcionFactura(descripcionFactura);
        factura.setFechaFacturacion(fechaFacturacion);
        factura.setDocumento(documento);
        factura.setDireccion(direccion);
        factura.setTotal(total);
        factura.setSubTotal(subTotal);
        factura.setSubImpuesto(subImpuesto);
        factura.setGasto(gasto);
        factura.setTipoFactura(tipoFactura);
        factura.setTipoPago(tipoPago);
        factura.setTipoDocumento(tipoDocumento);

        return factura;

    }
}
