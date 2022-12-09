package com.ap_portfolio.efe9.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
    @NotBlank
    private String nombre; 
    
    @NotBlank
    private String apellido;
    
    @NotBlank
    private String residencia;
    
    @NotBlank
    private String edad;
    
    @NotBlank
    private String telefono;
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String imagenPersona;
    
    @NotBlank
    private String textoPersona;
  

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String residencia, String edad, String telefono, String email, String imagenPersona, String textoPersona) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.residencia = residencia;
        this.edad = edad;
        this.telefono = telefono;
        this.email = email;
        this.imagenPersona = imagenPersona;
        this.textoPersona = textoPersona;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
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

    public String getImagenPersona() {
        return imagenPersona;
    }

    public void setImagenPersona(String imagenPersona) {
        this.imagenPersona = imagenPersona;
    }

    public String getTextoPersona() {
        return textoPersona;
    }

    public void setTextoPersona(String textoPersona) {
        this.textoPersona = textoPersona;
    }


}
