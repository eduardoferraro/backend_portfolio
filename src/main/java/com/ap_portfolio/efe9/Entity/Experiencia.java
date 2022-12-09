package com.ap_portfolio.efe9.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExperiencia;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error de validacion en nombre empresa. (Maximo 50 caracteres)")
    private String nombreEmpresa;
    
    @NotNull
    @Size(min = 1, max = 400, message = "Error de validacion en descripcion experiencia. (Maximo 400 caracteres)")
    private String descripcionExperiencia;
    
    @NotNull
    @Size(min = 4, max = 4, message = "Error de validacion en año desde. (Maximo 4 caracteres)")
    private String anioDesde;
    
    @NotNull
    @Size(min = 1, max = 2, message = "Error de validacion en mes desde. (Maximo 2 caracteres)")
    private String mesDesde;
    
    @NotNull
    @Size(min = 4, max = 4, message = "Error de validacion en año hasta. (Maximo 4 caracteres)")
    private String anioHasta;  
    
    @NotNull
    @Size(min = 1, max = 2, message = "Error de validacion en mes hasta. (Maximo 2 caracteres)")
    private String mesHasta; 
    
    private boolean esActual;
    
    public Experiencia() {
    }

    public Experiencia(String nombreEmpresa, String descripcionExperiencia, String anioDesde, String mesDesde, String anioHasta, String mesHasta, boolean esActual) {
        this.nombreEmpresa = nombreEmpresa;
        this.descripcionExperiencia = descripcionExperiencia;
        this.anioDesde = anioDesde;
        this.mesDesde = mesDesde;
        this.anioHasta = anioHasta;
        this.mesHasta = mesHasta;
        this.esActual = esActual;
    }

       
    
    //Getters and setters

    public int getIdExperiencia() {
        return idExperiencia;
    }

    public void setIdExperiencia(int idExperiencia) {
        this.idExperiencia = idExperiencia;
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

    public boolean getEsActual() {
        return esActual;
    }

    public void setEsActual(boolean esActual) {
        this.esActual = esActual;
    }

    

    
    
}