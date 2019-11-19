package com.example.clubcerveceromona.model;

import static java.lang.Integer.parseInt;

public class DatosxImagen {
    //atributos
    private String imagen, nombreCerveceria, tiempo, promocion, cantidadLikes, direccion, telefono, horario, preferencia;
    private Boolean megusta;
    private Double lat, lng;
    //private int cantidadLikes;


    public DatosxImagen(String imagen, String nombreCerveceria, String tiempo , String cantidadLikes,
                        String direccion, String telefono, String horario, String preferencia, Boolean megusta, Double lat, Double lng, String promocion) {
        this.imagen = imagen;
        this.nombreCerveceria = nombreCerveceria;
        this.tiempo = tiempo;
        this.promocion = promocion;
        this.cantidadLikes = cantidadLikes;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.preferencia = preferencia;
        this.megusta = megusta;
        this.lat = lat;
        this.lng = lng;
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
    public Boolean getMegusta() {
        return megusta;
    }

    public void setMegusta(Boolean megusta) {
        this.megusta = megusta;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
