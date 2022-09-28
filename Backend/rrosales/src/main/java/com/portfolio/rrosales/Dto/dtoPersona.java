
package com.portfolio.rrosales.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String titulo;
    @NotBlank
    private String domicilio;
    @NotBlank
    private String telefono;
    @NotBlank
    private String email;
    @NotBlank
    private String sobre_mi;
    @NotBlank
    private String url_foto;

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String apellido, String titulo, String domicilio, String telefono, String email, String sobre_mi, String url_foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.sobre_mi = sobre_mi;
        this.url_foto = url_foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSobre_mi() {
        return sobre_mi;
    }

    public void setSobre_mi(String sobre_mi) {
        this.sobre_mi = sobre_mi;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }
    
    
    
}
