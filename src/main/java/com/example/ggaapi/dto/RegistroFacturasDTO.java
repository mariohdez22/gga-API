package com.example.ggaapi.dto;

import com.example.ggaapi.model.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    public Integer idGasto;
    public Integer idTipoFactura;
    public Integer idTipoPago;
    public Integer idTipoDocumento;

    /*
    *
    *   PRODUCTOS
    *
    */

    public List<RegistroProductosDTO> productos;

    /*
    *
    *   RELACIONES
    *
    */

    public Registro_gastos gasto;
    public Tipo_facturas tipoFactura;
    public Tipo_pago tipoPago;
    public Tipo_documento tipoDocumento;

    /*
    *
    *   METODOS
    *
    */

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
                idGasto == null ||
                idTipoFactura == null ||
                idTipoPago == null ||
                idTipoDocumento == null;
    }

    public static List<RegistroFacturasDTO> MapperAllList(List<Registro_facturas> facturas){

        List<RegistroFacturasDTO> dtoList = new LinkedList<>();

        for(Registro_facturas f : facturas){

            RegistroFacturasDTO dto = new RegistroFacturasDTO();

            dto.setIdFacturas(f.getIdFacturas());
            dto.setCodigoFactura(f.getCodigoFactura());
            dto.setNrc(f.getNrc());
            dto.setLocalVendedor(f.getLocalVendedor());
            dto.setDescripcionFactura(f.getDescripcionFactura());
            dto.setFechaFacturacion(f.getFechaFacturacion());
            dto.setDocumento(f.getDocumento());
            dto.setDireccion(f.getDireccion());
            dto.setTotal(f.getTotal());
            dto.setSubTotal(f.getSubTotal());
            dto.setSubImpuesto(f.getSubImpuesto());

            dto.setIdGasto(f.getGasto().getIdGasto());
            dto.setIdTipoFactura(f.getTipoFactura().getIdTipoFactura());
            dto.setIdTipoPago(f.getTipoPago().getIdTipoPago());
            dto.setIdTipoDocumento(f.getTipoDocumento().getIdTipoDocumento());

            dto.setGasto(f.getGasto());
            dto.setTipoFactura(f.getTipoFactura());
            dto.setTipoPago(f.getTipoPago());
            dto.setTipoDocumento(f.getTipoDocumento());

            dtoList.add(dto);

        }

        if(dtoList.isEmpty()){
            return new LinkedList<>();
        }

        return dtoList;
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

        factura.setGasto(new Registro_gastos());
        factura.setTipoFactura(new Tipo_facturas());
        factura.setTipoPago(new Tipo_pago());
        factura.setTipoDocumento(new Tipo_documento());

        factura.getGasto().setIdGasto(idGasto);
        factura.getTipoFactura().setIdTipoFactura(idTipoFactura);
        factura.getTipoPago().setIdTipoPago(idTipoPago);
        factura.getTipoDocumento().setIdTipoDocumento(idTipoDocumento);

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

        factura.setGasto(new Registro_gastos());
        factura.setTipoFactura(new Tipo_facturas());
        factura.setTipoPago(new Tipo_pago());
        factura.setTipoDocumento(new Tipo_documento());

        factura.getGasto().setIdGasto(idGasto);
        factura.getTipoFactura().setIdTipoFactura(idTipoFactura);
        factura.getTipoPago().setIdTipoPago(idTipoPago);
        factura.getTipoDocumento().setIdTipoDocumento(idTipoDocumento);

        return factura;

    }
}
