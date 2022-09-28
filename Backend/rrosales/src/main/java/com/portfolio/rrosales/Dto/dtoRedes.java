package com.portfolio.rrosales.Dto;

import javax.validation.constraints.NotBlank;

public class dtoRedes {

    @NotBlank
    String nombre;
    @NotBlank
    String url_red;
    @NotBlank
    String url_logo;

    public dtoRedes() {
    }

    public dtoRedes(String nombre, String url_red, String url_logo) {
        this.nombre = nombre;
        this.url_red = url_red;
        this.url_logo = url_logo;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl_red() {
        return url_red;
    }

    public void setUrl_red(String url_red) {
        this.url_red = url_red;
    }

}
