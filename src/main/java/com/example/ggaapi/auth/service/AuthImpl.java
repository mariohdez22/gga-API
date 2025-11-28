package com.example.ggaapi.auth.service;

import com.example.ggaapi.auth.AuthResponse;
import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.dto.LoginDTO;
import com.example.ggaapi.jwt.service.IJwtService;
import com.example.ggaapi.model.Colaboradores;
import com.example.ggaapi.repository.IColaboradoresRepository;
import lombok.RequiredArgsConstructor;
/*import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;*/
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthImpl implements IAuthService{

    /*private final PasswordEncoder passEncoder;
    private final IColaboradoresRepository repoColab;
    private final IJwtService servToken;
    private final AuthenticationManager authManager;

    @Override
    public AuthResponse login(LoginDTO request) {

        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        Optional<Colaboradores> opt = repoColab.findByNickname(request.getUsername());

        if(opt.isEmpty()){
            return null;
        }

        UserDetails user = ColaboradoresDTO.Mapper(opt);
        String token = servToken.getToken(user);

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse register(ColaboradoresDTO request) {

        Colaboradores colaborador = request.Mapper();
        Optional<Colaboradores> opt = Optional.ofNullable(colaborador);

        if(opt.isEmpty()){
            return null;
        }

        colaborador.setContrasena(passEncoder.encode(request.contrasena));

        repoColab.save(colaborador);

        return AuthResponse.builder()
                .token(servToken.getToken(request))
                .build();
    }*/

}
