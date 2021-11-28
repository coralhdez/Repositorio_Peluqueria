package com.cine.negocio;

import com.cine.dominio.*;

public interface IActividadCine {

    String iniciarHistorialCine(String nombreFichero);
    
    void agregarUnProducto(String nombreFichero, Producto producto);
    
    String leerProductos(String nombreFichero);
    
    void BuscarPorductoId(String nombreFichero, int id); 
    
    void buscarUnProducto(String nombreFichero, String buscar);
        
    String borrarHistorialProductos(String nombreFichero);
    
    void borrarUnProducto(String nombreFichero, String busqueda);
   
    void TotalPrecio(String nombreFichero);
    
    void productoMasCaro(String nombreFichero);
    
    void precioPorProducto(String nombreFichero);
    
    void ordenarPorMenosCantidad(String nombreFichero);

}
