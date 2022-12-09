
package com.ap_portfolio.efe9.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String nombreInstitucion;
    
    @NotBlank
    private String nombreTitulo;
    
    @NotBlank
    private String anioDesde;
    
    @NotBlank
    private String anioHasta;
    
    @NotBlank
    private String imagenInstitucion;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreInstitucion, String nombreTitulo, String anioDesde, String anioHasta, String imagenInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
        this.nombreTitulo = nombreTitulo;
        this.anioDesde = anioDesde;
        this.anioHasta = anioHasta;
        this.imagenInstitucion = imagenInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getAnioDesde() {
        return anioDesde;
    }

    public void setAnioDesde(String anioDesde) {
        this.anioDesde = anioDesde;
    }

    public String getAnioHasta() {
        return anioHasta;
    }

    public void setAnioHasta(String anioHasta) {
        this.anioHasta = anioHasta;
    }

    public String getImagenInstitucion() {
        return imagenInstitucion;
    }

    public void setImagenInstitucion(String imagenInstitucion) {
        this.imagenInstitucion = imagenInstitucion;
    }
    
    
    
}
