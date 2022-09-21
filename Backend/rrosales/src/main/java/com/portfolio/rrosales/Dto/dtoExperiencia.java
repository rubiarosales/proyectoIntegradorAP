package com.portfolio.rrosales.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {

    @NotBlank
    private String cargo;
    @NotBlank
    private String empresa;
    @NotBlank
    private String fecha;
    @NotBlank
    private String descripcion_cargo;
    @NotBlank
    private String url_logo;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String cargo, String empresa, String fecha, String descripcion_cargo, String url_logo) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.fecha = fecha;
        this.descripcion_cargo = descripcion_cargo;
        this.url_logo = url_logo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion_cargo() {
        return descripcion_cargo;
    }

    public void setDescripcion_cargo(String descripcion_cargo) {
        this.descripcion_cargo = descripcion_cargo;
    }

    public String getUrl_logo() {
        return url_logo;
    }

    public void setUrl_logo(String url_logo) {
        this.url_logo = url_logo;
    }

    

    

}
