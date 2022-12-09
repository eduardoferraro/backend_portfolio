package com.ap_portfolio.efe9.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String nombreEmpresa;
    
    @NotBlank
    private String descripcionExperiencia;
    
    @NotBlank
    private String anioDesde;
    
    @NotBlank
    private String mesDesde;
    
    private String anioHasta;
    
    private String mesHasta;
    
    private Boolean esActual;
    
    
    //Constructores
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreEmpresa, String descripcionExperiencia, String anioDesde, String mesDesde, String anioHasta, String mesHasta, Boolean esActual) {
        this.nombreEmpresa = nombreEmpresa;
        this.descripcionExperiencia = descripcionExperiencia;
        this.anioDesde = anioDesde;
        this.mesDesde = mesDesde;
        this.anioHasta = anioHasta;
        this.mesHasta = mesHasta;
        this.esActual = esActual;
    }


    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDescripcionExperiencia() {
        return descripcionExperiencia;
    }

    public void setDescripcionExperiencia(String descripcionExperiencia) {
        this.descripcionExperiencia = descripcionExperiencia;
    }

    public String getAnioDesde() {
        return anioDesde;
    }

    public void setAnioDesde(String anioDesde) {
        this.anioDesde = anioDesde;
    }

    public String getMesDesde() {
        return mesDesde;
    }

    public void setMesDesde(String mesDesde) {
        this.mesDesde = mesDesde;
    }

    public String getAnioHasta() {
        return anioHasta;
    }

    public void setAnioHasta(String anioHasta) {
        this.anioHasta = anioHasta;
    }

    public String getMesHasta() {
        return mesHasta;
    }

    public void setMesHasta(String mesHasta) {
        this.mesHasta = mesHasta;
    }

    public Boolean getEsActual() {
        return esActual;
    }

    public void setEsActual(Boolean esActual) {
        this.esActual = esActual;
    }

    
}