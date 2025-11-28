package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroFacturasDTO;
import com.example.ggaapi.dto.RegistroProductosDTO;
import com.example.ggaapi.model.Registro_facturas;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.model.Registro_productos;
import com.example.ggaapi.repository.IRegistroFacturasRepository;
import com.example.ggaapi.repository.IRegistroProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroFacturasImpl implements IRegistroFacturasService {

    @Autowired
    private IRegistroFacturasRepository repoFacturas;
    @Autowired
    private IRegistroProductosRepository repoProductos;

    @Override
    public List<Registro_facturas> getAllFacturas(){
        return repoFacturas.findAll(Sort.by(Sort.Direction.DESC,"idFacturas"));
    }

    @Override
    public RegistroFacturasDTO getFactura(Integer id){

        Optional<Registro_facturas> opt = repoFacturas.findById(id);

        if(opt.isEmpty()){
            return null;
        }

        Registro_facturas f = opt.get();
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

        return dto;
    }

    @Override
    public List<Registro_facturas> getAllByIdGasto(Integer id){

        Registro_gastos g = new Registro_gastos();
        g.setIdGasto(id);

        List<Registro_facturas> facturas = repoFacturas.findAllByGasto(g);

        if(facturas.isEmpty()){
            return new LinkedList<>();
        }

        return facturas;
    }

    @Override
    public List<Registro_facturas> getAllFacturasLike(String data, Integer id){

        List<Registro_facturas> facturas = repoFacturas.findAllByCodigoFacturaContainingOrNrcOrLocalVendedorContainingOrDescripcionFacturaContainingOrDocumentoContainingOrDireccionContaining(
                data, data, data, data, data, data
        );

        if(!facturas.isEmpty()){
            return filterList(facturas, id);
        }

        return new LinkedList<>();

    }

    @Override
    public boolean createFactura(RegistroFacturasDTO facturaDTO){
        Registro_facturas factura = facturaDTO.Mapper();
        Optional<Registro_facturas> optFactura = Optional.ofNullable(factura);

        if(optFactura.isPresent()){
            int id = repoFacturas.save(factura).getIdFacturas();
            saveProductos(facturaDTO.productos, id);
            return true;
        }
        return false;
    }

    private void saveProductos(List<RegistroProductosDTO> productosDTO, int idFactura){
        for(RegistroProductosDTO dto : productosDTO){
            dto.setIdFactura(idFactura);
            Registro_productos p = dto.Mapper();
            repoProductos.save(p);
        }
    }

    @Override
    public Optional<Registro_facturas> updateFactura(RegistroFacturasDTO facturaDTO){
        Registro_facturas factura = facturaDTO.MapperUpdate();
        Optional<Registro_facturas> optFactura = Optional.ofNullable(factura);

        if(optFactura.isPresent()){
            System.out.println("ESTE ES EL ID: " + optFactura.get().getIdFacturas());
            return Optional.of(repoFacturas.save(factura));
        }
        return optFactura;
    }

    private List<Registro_facturas> filterList(List<Registro_facturas> facturas, Integer idGasto) {

        List<Registro_facturas> filter = new LinkedList<>();

        for(Registro_facturas f : facturas){

            if(f.getGasto().getIdGasto().equals(idGasto)){
                filter.add(f);
            }

        }

        if(filter.isEmpty()){
            return new LinkedList<>();
        }

        return filter;
    }

}
