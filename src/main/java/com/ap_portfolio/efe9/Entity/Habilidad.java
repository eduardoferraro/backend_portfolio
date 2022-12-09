package com.ap_portfolio.efe9.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Habilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHabilidad;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en nombre habilidad. (Maximo 50 caracteres)")
    private String nombreHabilidad;
    
    @NotNull
    @Size(min = 1, max = 3, message = "Error de validacion en cantidad habilidad. (Maximo 3 caracteres)")
    private String cantidadHabilidad;

    public Habilidad() {
    }

    public Habilidad(String nombreHabilidad, String cantidadHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.cantidadHabilidad = cantidadHabilidad;
    }

    public int getIdHabilidad() {
        return idHabilidad;
    }

    public void setIdHabilidad(int idHabilidad) {
        this.idHabilidad = idHabilidad;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public void setNombreHabilidad(String nombreHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
    }

    public String getCantidadHabilidad() {
        return cantidadHabilidad;
    }

    public void setCantidadHabilidad(String cantidadHabilidad) {
        this.cantidadHabilidad = cantidadHabilidad;
    }

    
    
    
}