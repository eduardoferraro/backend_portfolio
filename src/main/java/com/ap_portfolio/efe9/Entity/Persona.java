package com.ap_portfolio.efe9.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en nombre (Maximo 50 caracteres)")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en apellido (Maximo 50 caracteres)")
    private String apellido;
    
    @NotNull
    @Size(min = 2, max = 3, message = "Error de validacion en edad (3 caracteres)")
    private String edad;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en residencia.(Maximo 50 caracteres)")
    private String residencia;
    
    @NotNull
    @Size(min = 10, max = 15, message = "Error de validacion en telefono (Maximo 15 caracteres)")
    private String telefono;
    
    @NotNull
    @Size(min = 7, max = 50, message = "Error de validacion en email (Maximo 50 caracteres)")
    private String email;
    
    @NotNull
    @Size(min = 10, max = 500, message = "Error de validacion en imagen. (Maximo 500 caracteres)")
    private String imagenPersona;
    
    @NotNull
    @Size(min = 5, max = 500, message = "Error de validacion en texto persona. (Maximo 500 caracteres)")
    private String textoPersona;
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String edad, String residencia, String telefono, String email, String imagenPersona, String textoPersona, String textoHabilidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.residencia = residencia;
        this.telefono = telefono;
        this.email = email;
        this.imagenPersona = imagenPersona;
        this.textoPersona = textoPersona;
   
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
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
