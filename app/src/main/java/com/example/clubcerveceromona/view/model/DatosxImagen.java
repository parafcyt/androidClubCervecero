package com.example.clubcerveceromona.view.model;

public class DatosxImagen {
    //atributos
    private String imagen, nombreCerveceria, tiempo, promocion,cantidadLikes;

    public DatosxImagen(String imagen, String nombreCerveceria, String tiempo, String promocion, String cantidadLikes) {
        this.imagen = imagen;
        this.nombreCerveceria = nombreCerveceria;
        this.tiempo = tiempo;
        this.promocion = promocion;
        this.cantidadLikes = cantidadLikes;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreCerveceria() {
        return nombreCerveceria;
    }

    public void setNombreCerveceria(String nombreCerveceria) {
        this.nombreCerveceria = nombreCerveceria;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getCantidadLikes() {
        return cantidadLikes;
    }

    public void setCantidadLikes(String cantidadLikes) {
        this.cantidadLikes = cantidadLikes;
    }
}
