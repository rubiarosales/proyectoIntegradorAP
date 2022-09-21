package com.portfolio.rrosales.Entity;

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
    private long id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String cargo;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String empresa;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String fecha;
    @NotNull
    @Size(min = 1, max = 300, message = "No cumple con la longitud")
    private String descripcion_cargo;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String url_logo;

    public Experiencia() {
    }

    public Experiencia(String cargo, String empresa, String fecha, String descripcion_cargo, String url_logo) {
        this.cargo = cargo;
        this.empresa = empresa;
        this.fecha = fecha;
        this.descripcion_cargo = descripcion_cargo;
        this.url_logo = url_logo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
