package com.ap_portfolio.efe9.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en nombre Proyecto. (Maximo 50 caracteres)")
    private String nombreProyecto;
    
    @NotNull
    @Size(min = 1, max = 400, message = "Error de validacion en descripcion Proyecto. (Maximo 400 caracteres)")
    private String descripcionProyecto;
    
    @NotNull
    @Size(min = 4, max = 4, message = "Error de validacion en año. (Maximo 4 caracteres)")
    private String anio;
    
    @NotNull
    @Size(min = 1, max = 200, message = "Error de validacion en link Proyecto. (Maximo 200 caracteres)")
    private String linkProyecto;   

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, String descripcionProyecto, String anio, String linkProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.anio = anio;
        this.linkProyecto = linkProyecto;
    }
    
    
    //Getters and setters

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getLinkProyecto() {
        return linkProyecto;
    }

    public void setLinkProyecto(String linkProyecto) {
        this.linkProyecto = linkProyecto;
    }

    

    

    
    
}