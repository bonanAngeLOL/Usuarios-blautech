package com.angelol.blautech.test.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.angelol.blautech.test.entities.UsuarioEntity;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, ObjectId>{

}
