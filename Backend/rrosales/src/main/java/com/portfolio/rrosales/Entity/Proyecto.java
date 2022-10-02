
package com.portfolio.rrosales.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String titulo;
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String fecha;
    @NotNull
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    private String url_img;
    @NotNull
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    private String url_proyecto;

    public Proyecto() {
    }

    public Proyecto(String titulo, String fecha, String url_img, String url_proyecto) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.url_img = url_img;
        this.url_proyecto = url_proyecto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
