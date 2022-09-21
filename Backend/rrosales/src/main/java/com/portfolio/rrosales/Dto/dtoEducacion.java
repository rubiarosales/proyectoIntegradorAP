
package com.portfolio.rrosales.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    
    @NotBlank
    private String institucion;
    @NotBlank
    private String titulo;
    @NotBlank
    private String fecha;
    @NotBlank
    private String url_logo;

    public dtoEducacion() {
    }

    public dtoEducacion(String institucion, String titulo, String fecha, String url_logo) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.url_logo = url_logo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }
    
    
}
