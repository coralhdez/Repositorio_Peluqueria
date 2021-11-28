
package com.cine.dominio;


public class Cine {
    private int idCine;
    private String nombre;
    private String telefono;
    private String ciudad;
    private int aforo;

    private static int idAuto = 1;

    public Cine() {
        this.idCine = idAuto++;
    }

    public Cine(int idCine, String nombre, String telefono, String ciudad, int aforo) {
        this();
        this.idCine = idCine;
        this.nombre = nombre;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.aforo = aforo;
    }

    public Cine(String nombre, String telefono, String ciudad, int aforo) {
        this();
        this.nombre = nombre;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.aforo = aforo;
    }

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public static int getIdAuto() {
        return idAuto;
    }

    public static void setIdAuto(int idAuto) {
        Cine.idAuto = idAuto;
    }

    @Override
    public String toString() {
        return "Cine{" + "idCine=" + idCine + ", nombre=" + nombre + ", telefono=" + telefono + ", ciudad=" + ciudad + ", aforo=" + aforo + '}';
    }

    
    
   
    
    
    
    
}
