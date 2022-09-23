package com.portfolio.rrosales.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {

    @NotBlank
    private String titulo;
    @NotBlank
    private String fecha;
    @NotBlank
    private String url_img;
    @NotBlank
    private String url_proyecto;

    public dtoProyecto() {
    }

    public dtoProyecto(String titulo, String fecha, String url_img, String url_proyecto) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.url_img = url_img;
        this.url_proyecto = url_proyecto;
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

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl_proyecto() {
        return url_proyecto;
    }

    public void setUrl_proyecto(String url_proyecto) {
        this.url_proyecto = url_proyecto;
    }
    
    

}
