package com.angelol.blautech.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.angelol.blautech.test.bean.UsuarioBean;
import com.angelol.blautech.test.entities.UsuarioEntity;
import com.angelol.blautech.test.service.UsuarioService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    
    @Autowired
    private UsuarioService usuarioServ;

    @GetMapping("/all")
    public List<UsuarioBean> getAll(){
        return usuarioServ.getAll();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioBean> getById(@PathVariable ObjectId idUsuario){
        UsuarioBean usuario =  usuarioServ.getById(idUsuario);
        if(usuario == null)
            return new ResponseEntity<UsuarioBean>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<UsuarioBean>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<UsuarioBean> deleteById(@PathVariable ObjectId idUsuario){
        UsuarioBean usuario = usuarioServ.getById(idUsuario);
        if(usuario == null){
            return new ResponseEntity<UsuarioBean>(HttpStatus.NOT_FOUND);
        }
        usuarioServ.delete(idUsuario);
        return new ResponseEntity<UsuarioBean>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public UsuarioBean create(@RequestBody UsuarioEntity usuario){
        usuario.set_id(null);
        UsuarioBean usuarioBean = usuarioServ.save(usuario);
        usuarioBean.setId(usuario.get_id().toHexString());
        return usuarioBean; 
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UsuarioEntity usuario){
        UsuarioBean dbUser = usuarioServ.getById(usuario.get_id());
        if(dbUser == null)
           return new ResponseEntity<UsuarioBean>(HttpStatus.NOT_FOUND);
        usuarioServ.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleError(HttpServletRequest req, Exception ex) {
        return new ResponseEntity<String>("{\"error\":\""+ex.toString()+"\"}", HttpStatus.BAD_REQUEST);
    }


}
