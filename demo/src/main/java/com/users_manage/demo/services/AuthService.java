package com.users_manage.demo.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.users_manage.demo.dtos.LoginDto;
import com.users_manage.demo.models.UsuarioModel;
import com.users_manage.demo.repositories.UsuarioRepo;
import com.users_manage.demo.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AuthService {

    private final UsuarioRepo usuarioRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    
    public String login(LoginDto loginDto){
        UsuarioModel usuarioModel = usuarioRepo.findByDocumento(loginDto.getDocumento())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            if (!passwordEncoder.matches(loginDto.getPassword(), usuarioModel.getPassword())) {
                throw new RuntimeException("Contraseña incorrecta");
                
            }

            return jwtUtil.generateToken(usuarioModel.getDocumento());
    }

}
