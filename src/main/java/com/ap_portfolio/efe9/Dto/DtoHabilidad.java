package com.ap_portfolio.efe9.Dto;

import javax.validation.constraints.NotBlank;

public class DtoHabilidad {
    @NotBlank
    private String nombreHabilidad;
    
    @NotBlank
    private String cantidadHabilidad;
    
   
    
    //Constructores
    public DtoHabilidad() {
    }

    public DtoHabilidad(String nombreHabilidad, String cantidadHabilidad) {
        this.nombreHabilidad = nombreHabilidad;
        this.cantidadHabilidad = cantidadHabilidad;
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