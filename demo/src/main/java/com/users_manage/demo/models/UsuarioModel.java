package com.users_manage.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Document(collection = "users")
@Data

public class UsuarioModel {

    @Id
    private String id;

    @Indexed(unique = true)
    private String documento;

    private String nom;
    
    private String email;
    
    // variable password para solo escritura y no lectura
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
}
