package com.peluqueria.dominio;

public class Servicio {

    private int idServicio; //0
    private String nombreServicio; //1
    private double precio; //2
    private int duracion; //3
    private String descripcion; //4
    
     private static int contadorServicios = 0;

    public Servicio() {
        this.idServicio = Servicio.contadorServicios++;
    }

    public Servicio(String nombreServicio, double precio, int duracion, String descripcion) {
        this();
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public Servicio(int idServicio, String nombreServicio, double precio, int duracion, String descripcion) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.duracion = duracion;
        this.descripcion = descripcion;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static int getContadorServicios() {
        return contadorServicios;
    }

    public static void setContadorServicios(int contadorServicios) {
        Servicio.contadorServicios = contadorServicios;
    }

    @Override
    public String toString() {
        return "Servicio: " + "Identificador: " + idServicio 
                + ", Nombre del Servicio: " + nombreServicio 
                + ", Precio: " + precio 
                + ", Duración: " + duracion 
                + ", Descripción: " + descripcion;
    }

    

}
