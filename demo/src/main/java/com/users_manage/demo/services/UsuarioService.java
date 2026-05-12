package com.users_manage.demo.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.users_manage.demo.mappers.UsuarioMapper;
import com.users_manage.demo.models.UsuarioModel;
import com.users_manage.demo.repositories.UsuarioRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UsuarioService {


    private final UsuarioRepo usuarioRepo;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioModel crearUsuario(UsuarioModel usuariomodel) {
        usuariomodel.setPassword(passwordEncoder.encode(usuariomodel.getPassword()));
        return usuarioRepo.save(usuariomodel);
    }


    public List<UsuarioModel> listar()  {
        List<UsuarioModel> usuarios = usuarioRepo.findAll();
        if (usuarios.isEmpty()) {
            throw new RuntimeException("No se encontraron usuarios");
        }
        return usuarios;
    }

}
