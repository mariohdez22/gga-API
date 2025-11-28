package com.example.ggaapi.service;

import com.example.ggaapi.dto.RegistroGastosDTO;
import com.example.ggaapi.model.Gestion_departamento;
import com.example.ggaapi.model.Registro_gastos;
import com.example.ggaapi.model.Tipo_gastos;
import com.example.ggaapi.model.Tipo_transaccion;
import com.example.ggaapi.repository.IRegistroGastosRepository;
import com.example.ggaapi.repository.ITipoGastosRepository;
import com.example.ggaapi.repository.ITipoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroGastoImpl implements IRegistroGastoService{

    @Autowired
    private IRegistroGastosRepository repoGastos;

    @Autowired
    private ITipoGastosRepository repoTipo;

    @Override
    public List<Registro_gastos> getAllGastos(){
        return repoGastos.findAll(Sort.by(Sort.Direction.DESC,"idGasto"));
    }

    @Override
    public List<Registro_gastos> getAllGastosDepa(Integer id){
        Gestion_departamento depa = new Gestion_departamento();
        depa.setIdDepartamento(id);
        return repoGastos.findAllByDepartamentoOrderByIdGastoDesc(depa);
    }

    @Override
    public RegistroGastosDTO getGasto(Integer id){

        Optional<Registro_gastos> opt = repoGastos.findById(id);

        if(opt.isEmpty()){
            return null;
        }

        Registro_gastos g = opt.get();
        RegistroGastosDTO dto = new RegistroGastosDTO();

        dto.setIdGasto(g.getIdGasto());
        dto.setCodigoCompra(g.getCodigoCompra());
        dto.setDescripcion(g.getDescripcion());
        dto.setTotalGastos(g.getTotalGastos());
        dto.setIdTipoGastos(g.getTipoGastos().getIdTipoGasto());
        dto.setIdDepartamento(g.getDepartamento().getIdDepartamento());
        dto.setIdColaborador(g.getColaborador().getIdColaborador());
        dto.setIdTipoTransaccion(g.getTipoTransaccion().getIdTipoTransaccion());

        dto.setTipoGastos(g.getTipoGastos());
        dto.setDepartamento(g.getDepartamento());
        dto.setColaborador(g.getColaborador());
        dto.setTipoTransaccion(g.getTipoTransaccion());

        return dto;
    }

    @Override
    public List<Registro_gastos> getAllGastosLike(String data, Integer id){

        try{

            List<Registro_gastos> gastos = repoGastos.findAllByCodigoCompraContainingOrDescripcionContaining(
                    data,data);

            if(!gastos.isEmpty()){
                return filterList(gastos,id);
            }

            List<Tipo_gastos> tipos = repoTipo.findAllByTipoGastoContaining(data);

            for (Tipo_gastos tg : tipos) {
                gastos = repoGastos.findAllByTipoGastosContaining(tg);
            }

            if(!gastos.isEmpty()){
                return filterList(gastos,id);
            }

        }catch (Exception ignored){}

        return new LinkedList<>();
    }

    @Override
    public List<Registro_gastos> getAllGastosTransac(Integer id){

        Tipo_transaccion t = new Tipo_transaccion();
        t.setIdTipoTransaccion(id);
        return repoGastos.findAllByTipoTransaccion(t);
    }

    @Override
    public Optional<Registro_gastos> createGasto(RegistroGastosDTO gastosDTO){
        Registro_gastos gasto = gastosDTO.Mapper();
        Optional<Registro_gastos> optGasto = Optional.ofNullable(gasto);
        if(optGasto.isPresent()){
            return Optional.of(repoGastos.save(gasto));
        }
        return optGasto;
    }

    @Override
    public Optional<Registro_gastos> updateGasto(RegistroGastosDTO gastosDTO){
        Registro_gastos gasto = gastosDTO.MapperUpdate();
        Optional<Registro_gastos> optGasto = Optional.ofNullable(gasto);
        if(optGasto.isPresent()){
            return Optional.of(repoGastos.save(gasto));
        }
        return optGasto;
    }

    @Override
    public String GeneracionCodigo() {
        String ultimo = ObtencionUltimoCodigo();

        if(ultimo.isEmpty()){
            return "COMP1";
        }

        int n = Integer.parseInt(ultimo.substring(4));

        String codigo;
        codigo = "COMP" + (n + 1);

        if(!VerificarCodigoUnico(codigo))
        {
            return GeneracionCodigo();
        }

        return codigo;
    }

    @Override
    public String ObtencionUltimoCodigo() {
        return repoGastos.findAll(getSortDesc()).get(0).getCodigoCompra();
    }

    @Override
    public Boolean VerificarCodigoUnico(String codigo) {
        return repoGastos.findAllByCodigoCompra(codigo).isEmpty();
    }

    private Sort getSortDesc(){
        return Sort.by(Sort.Direction.DESC, "idGasto");
    }

    private List<Registro_gastos> filterList(List<Registro_gastos> gastos, Integer idDepa) {

        List<Registro_gastos> filter = new LinkedList<>();

        for(Registro_gastos g : gastos){

            if(g.getDepartamento().getIdDepartamento().equals(idDepa)){
                filter.add(g);
            }

        }

        if(filter.isEmpty()){
            return new LinkedList<>();
        }

        return filter;
    }

}
