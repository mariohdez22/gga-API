package com.example.ggaapi.service;

import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Estado_colaborador;
import com.example.ggaapi.repository.IColaboradoresRepository;
import jakarta.persistence.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradoresImpl implements IColaboradoresService{

    @Autowired
    private IColaboradoresRepository repoColaboradores;

    @Override
    public List<Colaboradores> getAllColaboradores(){
        return repoColaboradores.findAll(Sort.by(Sort.Direction.DESC,"idColaborador"));
    }

    @Override
    public List<Colaboradores> getAllColaboradoresLike(String data){
        return repoColaboradores.findAllByNombresContainingOrCelularContainingOrEmailContainingOrNicknameContaining(
                data, data, data, data
        );
    }

    @Override
    public List<Colaboradores> getColaboradoresVigentes() {
        Estado_colaborador estado = new Estado_colaborador();
        estado.setIdEstado(1);
        return repoColaboradores.findAllByEstadoOrderByIdColaboradorDesc(estado);
    }

    @Override
    public List<Colaboradores> getColaboradoresSuspendidos() {
        Estado_colaborador estado = new Estado_colaborador();
        estado.setIdEstado(2);
        return repoColaboradores.findAllByEstadoOrderByIdColaboradorDesc(estado);
    }

    @Override
    public List<Colaboradores> getColaboradoresNoDisponibles() {
        Estado_colaborador estado = new Estado_colaborador();
        estado.setIdEstado(3);
        return repoColaboradores.findAllByEstadoOrderByIdColaboradorDesc(estado);
    }

    @Override
    public ColaboradoresDTO getColaborador(Integer id){
        Optional<Colaboradores> opt = repoColaboradores.findById(id);
        if(opt.isEmpty()){
            return null;
        }
        Colaboradores c = opt.get();
        ColaboradoresDTO dto = new ColaboradoresDTO();

        dto.setIdColaborador(c.getIdColaborador());
        dto.setNombres(c.getNombres());
        dto.setCelular(c.getCelular());
        dto.setEmail(c.getEmail());
        dto.setNickname(c.getNickname());
        dto.setContrasena(c.getContrasena());
        dto.setIdCargo(c.getCargo().getIdCargo());
        dto.setIdEstado(c.getEstado().getIdEstado());

        return dto;
    }

    @Override
    public Optional<Colaboradores> createColaborador(ColaboradoresDTO colaboradorDTO){
        Colaboradores colaborador = colaboradorDTO.Mapper();
        Optional<Colaboradores> opt = Optional.ofNullable(colaborador);
        if(opt.isPresent()){
            return Optional.of(repoColaboradores.save(colaborador));
        }
        return opt;
    }

    @Override
    public Optional<Colaboradores> updateColaborador(ColaboradoresDTO colaboradorDTO){
        Colaboradores colaborador = colaboradorDTO.MapperUpdate();
        Optional<Colaboradores> opt = Optional.ofNullable(colaborador);
        if(opt.isPresent()){
            return Optional.of(repoColaboradores.save(colaborador));
        }
        return opt;

    }

    @Override
    public Optional<ColaboradoresDTO> getUser(String username){
        return Optional.ofNullable(ColaboradoresDTO.Mapper(repoColaboradores.findByNickname(username)));
    }

}
