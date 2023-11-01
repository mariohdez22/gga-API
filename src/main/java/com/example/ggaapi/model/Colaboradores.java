package com.example.ggaapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="colaboradores")
public class Colaboradores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idColaborador;

    private String nombres;

    private String celular;

    private String email;

    private String nickname;

    private String contrasena;

    @OneToOne
    @JoinColumn(name = "idCargo")
    private Cargo_colaborador Cargo;

    @OneToOne
    @JoinColumn(name="idEstado")
    private Estado_colaborador Estado;

}
