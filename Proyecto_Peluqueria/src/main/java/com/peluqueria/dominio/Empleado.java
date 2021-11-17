
package com.peluqueria.dominio;


public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni; 
    private String telefono;
    private String categoria;
    
     private static int contadorEmpleados = 0;

    public Empleado() {
        this.idEmpleado = Empleado.contadorEmpleados++;
    }

    
    
    public Empleado(int idEmpleado, String nombre, String apellido, String apellido2, String dni, String telefono, String categoria) {
        this();
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido) {
        this.apellido1 = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido1 + ", apellido2=" + apellido2 + ", dni=" + dni + ", telefono=" + telefono + ", categoria=" + categoria + '}';
    }
    
    
    
    
    
}
