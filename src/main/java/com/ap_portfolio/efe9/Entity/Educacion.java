
package com.ap_portfolio.efe9.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEducacion;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en nombre Institucion. (Maximo 50 caracteres)")
    private String nombreInstitucion;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en nombre titulo. (Maximo 50 caracteres)")
    private String nombreTitulo;
    
    @NotNull
    @Size(min = 4, max = 4, message = "Error de validacion en Año desde. (Maximo 4 caracteres)")
    private String anioDesde;
    
    @NotNull
    @Size(min = 4, max = 4, message = "Error de validacion en Año Hasta. (Maximo 4 caracteres)")
    private String anioHasta;
    
    @NotNull
    @Size(min = 10, max = 500, message = "Error de validacion en imagen institucion. (Maximo 500 caracteres)")
    private String imagenInstitucion;

    public Educacion() {
    }

    public Educacion(String nombreInstitucion, String nombreTitulo, String anioDesde, String anioHasta, String imagenInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
        this.nombreTitulo = nombreTitulo;
        this.anioDesde = anioDesde;
        this.anioHasta = anioHasta;
        this.imagenInstitucion = imagenInstitucion;
    }

    public int getIdEducacion() {
        return idEducacion;
    }

    public void setIdEducacion(int idEducacion) {
        this.idEducacion = idEducacion;
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
