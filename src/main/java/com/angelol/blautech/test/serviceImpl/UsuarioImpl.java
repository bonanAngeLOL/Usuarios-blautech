package com.angelol.blautech.test.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.angelol.blautech.test.bean.UsuarioBean;
import com.angelol.blautech.test.entities.UsuarioEntity;
import com.angelol.blautech.test.repository.UsuarioRepository;
import com.angelol.blautech.test.service.UsuarioService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImpl implements UsuarioService{

    @Autowired
    UsuarioRepository usuarioRepo;

    @Override
    public void delete(ObjectId idUsuario) {
        usuarioRepo.deleteById(idUsuario);
    }

    @Override
    public List<UsuarioBean> getAll() {
        List<UsuarioEntity> users =  usuarioRepo.findAll();
        List<UsuarioBean> usersBean = new ArrayList<>();
        for(UsuarioEntity user : users){
            UsuarioBean usuarioBean = new UsuarioBean(
                    user.get_id().toHexString(), 
                    user.getNombre(),
                    user.getApellido_paterno(),
                    user.getApellido_materno(),
                    user.getPassword(),
                    user.getTelefono(),
                    user.getEmail());
            usersBean.add(usuarioBean);
        }
        return usersBean;
    }

    @Override
    public UsuarioBean getById(ObjectId idUsuario) {
        UsuarioEntity user = usuarioRepo.findById(idUsuario).orElse(null);
        if(user == null)
            return null;
        UsuarioBean usuarioBean = new UsuarioBean(
                user.get_id().toHexString(), 
                user.getNombre(),
                user.getApellido_paterno(),
                user.getApellido_materno(),
                user.getPassword(),
                user.getTelefono(),
                user.getEmail());
        return usuarioBean;
    }

    @Override
    public UsuarioBean save(UsuarioEntity usuario) {
        usuarioRepo.save(usuario);
        UsuarioBean usuarioBean = new UsuarioBean(
               usuario.getNombre(),
               usuario.getApellido_paterno(),
               usuario.getApellido_materno(),
               usuario.getPassword(),
               usuario.getTelefono(),
               usuario.getEmail());
        return usuarioBean;
    }


}
