package com.cine.dominio;

import java.awt.Menu;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Producto {

    private static int idAuto = 1;

    private int idProducto; //0
    String nombre;//1
    Proveedor proveedor; //2
    int cantidad; //3
    double precio; //4
    String fechaCaducidad;//5



    public Producto() {
        this.idProducto = idAuto++;
    }

    public Producto(int idProducto, String nombre, Proveedor proveedor, int cantidad, double precio) {
        this();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Producto(String nombre, Proveedor proveedor, int cantidad, double precio, String fechaCaducidad) {
        this();
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
    }

    public Producto(int idProducto, String nombre,  Proveedor proveedor, int cantidad, double precio, String fechaCaducidad) {
        this();
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaCaducidad = fechaCaducidad;
    }

    public static void setIdAuto(int idAuto) {
        Producto.idAuto = idAuto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

  
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
//
//    public static int getContadorProductos() {
//        return contadorProductos;
//    }
//
//    public static void setContadorProductos(int contadorProductos) {
//        Producto.contadorProductos = contadorProductos;
//    }

   
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombreProductoSuelto=" + nombre + ", proveedor=" + proveedor + ", cantidad=" + cantidad + ", precio=" + precio + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

}
