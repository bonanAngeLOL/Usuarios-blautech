package com.angelol.blautech.test.service;

import java.util.List;

import com.angelol.blautech.test.bean.UsuarioBean;
import com.angelol.blautech.test.entities.UsuarioEntity;

import org.bson.types.ObjectId;

public interface UsuarioService{ 

    UsuarioBean getById(ObjectId idUsuario);

    void delete(ObjectId idUsuario);

    UsuarioBean save(UsuarioEntity usuario);

    List<UsuarioBean> getAll();

}
