package com.silvia.animales.models;

import jakarta.validation.constraints.*;

public class Animal {
    private Integer id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min=3, max=15, message = "El tamaño debe estar entre 3 y 15")
    private String nombre;

    @Min(value=0, message = "La vida media debe ser positiva")
    @Max(value=600, message = "La vida media no puede ser mayor a 600 años")
    private int vidaMedia;

    private boolean extinto;

    public Animal( Integer id, String nombre, int vidaMedia, boolean extinto){
        this.id=id;
        this.nombre=nombre;
        this.vidaMedia=vidaMedia;
        this.extinto=extinto;
    }
    public Animal(){}

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVidaMedia() {
        return vidaMedia;
    }
    public void setVidaMedia(int vidaMedia) {
        this.vidaMedia = vidaMedia;
    }

    public boolean isExtinto() {
        return extinto;
    }
    public void setExtinto(boolean extinto) {
        this.extinto = extinto;
    }
}
