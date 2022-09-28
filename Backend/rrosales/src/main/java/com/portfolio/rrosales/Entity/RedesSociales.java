
package com.portfolio.rrosales.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RedesSociales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    @Size(min = 1, max = 20, message = "No cumple con la longitud")
    String nombre;
    @NotNull
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    String url_red;
        @NotNull
    @Size(min = 1, max = 100, message = "No cumple con la longitud")
    String url_logo;

    public RedesSociales() {
    }

    public RedesSociales(String nombre, String url_red, String url_logo) {
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

    public String getUrl_red() {
        return url_red;
    }

    public void setUrl_red(String url_red) {
        this.url_red = url_red;
    }
    
    
}
