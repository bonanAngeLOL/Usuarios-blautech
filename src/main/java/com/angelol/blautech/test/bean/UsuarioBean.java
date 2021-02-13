package com.angelol.blautech.test.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable{
    
    private static final long serialVersionUID = 1L; 

    private String id;

    private String nombre;

    private String apellido_paterno;

    private String apellido_materno;

    private String password;

    private String telefono;

    private String email;

    public UsuarioBean(String id, String nombre, String apellido_paterno, String apellido_materno, String password,
            String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
    }


    public UsuarioBean(String nombre, String apellido_paterno, String apellido_materno, String password,
            String telefono, String email) {
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.password = password;
        this.telefono = telefono;
        this.email = email;
    }

    public UsuarioBean(){}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
