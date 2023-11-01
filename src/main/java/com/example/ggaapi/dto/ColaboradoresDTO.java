package com.example.ggaapi.dto;

import com.example.ggaapi.model.Cargo_colaborador;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Estado_colaborador;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Optional;

@Getter @Setter
public class ColaboradoresDTO {

    public Integer idColaborador;

    public String nombres;

    public String celular;

    public String email;

    public String nickname;

    public String contrasena;

    public Integer idCargo;

    public Integer idEstado;

    public Cargo_colaborador Cargo;

    public Estado_colaborador Estado;

    /*
     *
     *      METODOS
     *
     */

    private boolean isBodyEmpty(){

        return  nombres == null || nombres.isEmpty() ||
                celular == null || celular.isEmpty() ||
                email == null || email.isEmpty() ||
                nickname == null || nickname.isEmpty() ||
                contrasena == null || contrasena.isEmpty();
    }

    /*
        || Cargo == null || Cargo.getIdCargo() == null ||
         Estado == null || Estado.getIdEstado() == null
    */

    /*
    Sirve para crear y mapear cada atributo del DTO con el modelo original

    retorna null -> si el DTO esta vacio
    retorna un objeto Colaboradores -> si el DTO tiene informacion

    */
    public Colaboradores Mapper(){

        System.out.println();
        System.out.println("Esto se Ejecuto Correctamente");

        if(this.isBodyEmpty()){
            System.out.println("es el body");
            return null;
        }

        Colaboradores colaborador = new Colaboradores();

        colaborador.setNombres(nombres);
        colaborador.setCelular(celular);
        colaborador.setEmail(email);
        colaborador.setNickname(nickname);
        colaborador.setContrasena(contrasena);
        //colaborador.setCargo(Cargo);
        //colaborador.setEstado(Estado);

        if (this.getIdCargo() != null)
        {
            Cargo_colaborador cargo = new Cargo_colaborador();
            cargo.setIdCargo(idCargo);
            colaborador.setCargo(cargo);
            System.out.println("lo lograste");
        }
        else
        {
            System.out.println("es el cargo el que esta mal");
            return null;
        }

        if (this.getIdEstado() != null)
        {
            Estado_colaborador estado = new Estado_colaborador();
            estado.setIdEstado(idEstado);
            colaborador.setEstado(estado);
            System.out.println("lo lograste x2");
        }
        else
        {
            System.out.println("es el estado el que esta mal");
            return null;
        }

        System.out.println(1);

        return colaborador;
    }

    public Colaboradores MapperUpdate(){

        System.out.println();
        System.out.println("Esto se Ejecuto Correctamente");

        if(this.isBodyEmpty() || idColaborador == null){
            return null;
        }

        Colaboradores colaborador = new Colaboradores();

        colaborador.setIdColaborador(idColaborador);
        colaborador.setNombres(nombres);
        colaborador.setCelular(celular);
        colaborador.setEmail(email);
        colaborador.setNickname(nickname);
        colaborador.setContrasena(contrasena);
        //colaborador.setCargo(Cargo);
        //colaborador.setEstado(Estado);

        if (this.getIdCargo() != null)
        {
            Cargo_colaborador cargo = new Cargo_colaborador();
            cargo.setIdCargo(idCargo);
            colaborador.setCargo(cargo);
        }
        else
        {
            return null;
        }

        if (this.getIdEstado() != null)
        {
            Estado_colaborador estado = new Estado_colaborador();
            estado.setIdEstado(idEstado);
            colaborador.setEstado(estado);
        }
        else
        {
            return null;
        }

        return colaborador;
    }

}
