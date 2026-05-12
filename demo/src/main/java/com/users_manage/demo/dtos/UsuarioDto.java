package com.users_manage.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class UsuarioDto {


    @NotBlank
    private String nombre;
    
    @Email
    private String correo;

    @NotBlank
    private String documento;

    @Size(min = 6, max = 20)
    private String contraseña;
}
