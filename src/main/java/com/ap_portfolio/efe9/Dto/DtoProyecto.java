package com.ap_portfolio.efe9.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    @NotBlank
    private String nombreProyecto;
    
    @NotBlank
    private String descripcionProyecto;
    
    @NotBlank
    private String anio;
    
    @NotBlank
    private String linkProyecto;
    
    
    //Constructores

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreProyecto, String descripcionProyecto, String anio, String linkProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.anio = anio;
        this.linkProyecto = linkProyecto;
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