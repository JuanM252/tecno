package com.users_manage.demo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.users_manage.demo.models.UsuarioModel;

@Repository 

public interface UsuarioRepo extends MongoRepository<UsuarioModel, String> {

    Optional<UsuarioModel> findByDocumento(String documento);

}
