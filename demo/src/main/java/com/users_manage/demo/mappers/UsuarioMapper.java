package com.users_manage.demo.mappers;

import org.springframework.stereotype.Component;

import com.users_manage.demo.dtos.UsuarioDto;
import com.users_manage.demo.models.UsuarioModel;

@Component

public class UsuarioMapper {


    public UsuarioModel toEntity(UsuarioDto dto) {
        UsuarioModel uModel = new UsuarioModel();
        uModel.setNom(dto.getNombre());
        uModel.setEmail(dto.getCorreo());
        uModel.setPassword(dto.getContraseña());
        uModel.setDocumento(dto.getDocumento());
        return uModel;
    }

    public UsuarioDto toDto(UsuarioModel model) {
        UsuarioDto uDto = new UsuarioDto();
        uDto.setNombre(model.getNom());
        uDto.setCorreo(model.getEmail());
        uDto.setDocumento(model.getDocumento());
        return uDto;
    }
}
