package com.example.ggaapi.dto;

import com.example.ggaapi.model.Cargo_colaborador;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.model.Estado_colaborador;
import lombok.Getter;
import lombok.Setter;
/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
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

    /*
     *
     *   RELACIONES
     *
     */

    public Cargo_colaborador cargo;
    public Estado_colaborador estado;

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

    public static List<ColaboradoresDTO> MapperAllList(List<Colaboradores> colaboradores){

        List<ColaboradoresDTO> dtoList = new LinkedList<>();

        for(Colaboradores c : colaboradores){

            ColaboradoresDTO colab = new ColaboradoresDTO();

            colab.setIdColaborador(c.getIdColaborador());
            colab.setNombres(c.getNombres());
            colab.setCelular(c.getCelular());
            colab.setEmail(c.getEmail());
            colab.setNickname(c.getNickname());
            colab.setContrasena(c.getContrasena());
            colab.setIdCargo(c.getCargo().getIdCargo());
            colab.setIdEstado(c.getEstado().getIdEstado());

            colab.setCargo(c.getCargo());
            colab.setEstado(c.getEstado());

            dtoList.add(colab);
        }

        if(dtoList.isEmpty()){
            return new LinkedList<>();
        }

        return dtoList;
    }

    public static ColaboradoresDTO Mapper(Optional<Colaboradores> optColab){

        if(optColab.isEmpty()){
            System.out.println("Ta vacio");
            return null;
        }

        Colaboradores colaborador = optColab.get();

        ColaboradoresDTO dto = new ColaboradoresDTO();

        dto.setNombres(colaborador.getNombres());
        dto.setCelular(colaborador.getCelular());
        dto.setEmail(colaborador.getEmail());
        dto.setNickname(colaborador.getNickname());
        dto.setContrasena(colaborador.getContrasena());

        if (colaborador.getCargo().getIdCargo() != null)
        {
            dto.setCargo(colaborador.getCargo());
        }
        else
        {
            System.out.println("es el cargo el que esta mal");
            return null;
        }

        if (colaborador.getEstado().getIdEstado() != null)
        {
            dto.setEstado(colaborador.getEstado());
        }
        else
        {
            System.out.println("es el estado el que esta mal");
            return null;
        }

        return dto;
    }

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

    /*
     *
     *   SEGURIDAD
     *
     */

    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(cargo.getCargoColaborador()));
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return nickname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/

}
