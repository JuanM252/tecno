package com.users_manage.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginDto {

    @NotBlank
    private String documentos;

    @NotBlank
    private String password;

}
