package com.users_manage.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginDto {

    @NotBlank
    private String documento;

    @NotBlank
    private String password;

}
