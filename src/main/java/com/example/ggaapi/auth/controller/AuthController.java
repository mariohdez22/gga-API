package com.example.ggaapi.auth.controller;

import com.example.ggaapi.auth.AuthResponse;
import com.example.ggaapi.auth.service.IAuthService;
import com.example.ggaapi.dto.ColaboradoresDTO;
import com.example.ggaapi.dto.LoginDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gga_api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final IAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO request)
    {
        //return ResponseEntity.ok(authService.login(request));
        return ResponseEntity.ok(new AuthResponse());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ColaboradoresDTO request){

        /*AuthResponse response = authService.register(request);

        if(response == null){
            return new ResponseEntity<>("No se pudo crear el usuario", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(response);*/

        return ResponseEntity.ok("hola");
    }

}
