
package com.cine.dominio;


public class CategoriaDTO {
    int idCategoria;
    String nombreCategoria;
    double salario;

    public CategoriaDTO() {
    }

    public CategoriaDTO(int idCategoria, String nombreCategoria, double salario) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.salario = salario;
    }

   

    public CategoriaDTO(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    

    @Override
    public String toString() {
        return  "ID: " + idCategoria + ",  " + nombreCategoria + ", Salario según categoría: " + salario + " €" ;
    }
    
    
    
}
