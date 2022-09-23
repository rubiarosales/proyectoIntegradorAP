
package com.portfolio.rrosales.Dto;

import javax.validation.constraints.NotBlank;


public class dtoHabilidades {
   
    @NotBlank
    private String habilidad;
    @NotBlank
    private int nivel;

    public dtoHabilidades() {
    }

    public dtoHabilidades(String habilidad, int nivel) {
        this.habilidad = habilidad;
        this.nivel = nivel;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
   
    
    
    
}
