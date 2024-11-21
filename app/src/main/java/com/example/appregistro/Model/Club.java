package com.example.appregistro.Model;

public class Club {
    private String nombre;
    private String descripcion;
    private int logoId; // ID del recurso drawable para el logo

    public Club(String nombre, String descripcion, int logoId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.logoId = logoId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLogoId() {
        return logoId;
    }
}
