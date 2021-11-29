
package com.cine.dominio;

import java.util.*;


public class EmpleadoDTO {
     private static int idAuto = 1;
     
    int idEmpleado;
    String nombre;
    String apellido1;
    String apellido2;
    String dni;
    String email;
    int Categoria_idCategoria;
    int cines_idcines;

    public EmpleadoDTO() {
        this.idEmpleado = idAuto++;
    }

    public EmpleadoDTO(int idEmpleado, String nombre, String apellido1, String apellido2, String dni, String email, int Categoria_idCategoria, int cines_idcines) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.Categoria_idCategoria = Categoria_idCategoria;
        this.cines_idcines = cines_idcines;
    }

      
    public EmpleadoDTO(int idEmpleado, String nombre, String apellido1, String apellido2, String dni, String email) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
    }

    public EmpleadoDTO(String nombre, String apellido1, String apellido2, String dni, String email, int Categoria_idCategoria, int cines_idcines) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.email = email;
        this.Categoria_idCategoria = Categoria_idCategoria;
        this.cines_idcines = cines_idcines;
    }
    

    public int getFk() {
        return Categoria_idCategoria;
    }

    public void setFk(int fk) {
        this.Categoria_idCategoria = fk;
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

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
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



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCategoria_idCategoria() {
        return Categoria_idCategoria;
    }

    public void setCategoria_idCategoria(int Categoria_idCategoria) {
        this.Categoria_idCategoria = Categoria_idCategoria;
    }

    public int getCines_idcines() {
        return cines_idcines;
    }

    public void setCines_idcines(int cines_idcines) {
        this.cines_idcines = cines_idcines;
    }

    @Override
    public String toString() {
        return  "ID Empleado: " + idEmpleado + ", Nombre: " + nombre + ", Pimer Apellido: " + apellido1 + ", Segundo Apellido: " + apellido2 + ", DNI: " + dni + ", Email: " + email + ", Identidicador Puesto Laboral: " + Categoria_idCategoria + ", Identificador Cine: " + cines_idcines;
    }
    
    

    

  
    
    
            
}
