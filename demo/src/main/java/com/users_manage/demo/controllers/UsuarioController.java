package com.users_manage.demo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.users_manage.demo.dtos.UsuarioDto;
import com.users_manage.demo.mappers.UsuarioMapper;
import com.users_manage.demo.models.UsuarioModel;
import com.users_manage.demo.services.UsuarioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor

public class UsuarioController {

    private final UsuarioService usService;
    private final UsuarioMapper usMapper;  


    @PostMapping("/crear")
    public ResponseEntity<UsuarioModel> crearUsuario(@Valid @RequestBody UsuarioDto usuarioDto) { 
        UsuarioModel usuarioModel = usMapper.toEntity(usuarioDto);
        return ResponseEntity.ok(usService.crearUsuario(usuarioModel));
    }
    
    @GetMapping("ver")
    public List<UsuarioModel> listar() {
        return usService.listar();
    }
    
    
}
