package com.example.ggaapi.repository;

import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Estado_colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IColaboradoresRepository extends JpaRepository<Colaboradores, Integer>
{
    List<Colaboradores> findAllByEstadoOrderByIdColaboradorDesc(Estado_colaborador estado);

    List<Colaboradores> findAllByNombresContainingOrCelularContainingOrEmailContainingOrNicknameContaining(String nombres, String celular, String email, String nickname);

    Optional<Colaboradores> findByNickname(String nickname);

}

/*



*/
