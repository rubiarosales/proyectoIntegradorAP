
package com.portfolio.rrosales.Entity;

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
    private long id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String institucion;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String titulo;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String fecha;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String url_logo;

    public Educacion() {
    }

    public Educacion(String institucion, String titulo, String fecha, String url_logo) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.fecha = fecha;
        this.url_logo = url_logo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
