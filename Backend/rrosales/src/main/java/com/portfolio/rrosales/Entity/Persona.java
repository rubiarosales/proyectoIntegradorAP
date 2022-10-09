package com.portfolio.rrosales.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size (min=1,max=50,message="No cumple con la longitud")
    private String nombre;
    @NotNull
    @Size (min=1,max=50,message="No cumple con la longitud")
    private String apellido;
    @NotNull
    @Size (min=1,max=50,message="No cumple con la longitud")
    private String titulo;
    @NotNull
    @Size (min=1,max=50,message="No cumple con la longitud")
    private String domicilio;
    @NotNull
    @Size (min=8,max=12,message="No cumple con la longitud")
    private String telefono;
    @NotNull
    @Size (min=1,max=50,message="No cumple con la longitud")
    private String email;
    @NotNull
    @Size (min=1,max=350,message="No cumple con la longitud")
    private String sobre_mi;
    @NotNull
    @Size (min=1,max=200,message="No cumple con la longitud")
    private String url_foto;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String titulo, String domicilio, String telefono, String email, String sobre_mi, String url_foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
        this.sobre_mi = sobre_mi;
        this.url_foto = url_foto;
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
