package com.peluqueria.negocio;

import com.peluqueria.dominio.*;

public interface IActividadPeluqueria {

    String iniciarHistorialActividad(String nombreFichero);
    
    void agregarServicio(String nombreFichero, Servicio servicio);
    
    String leerServicios(String nombreFichero);
    
    void mostrarPorductoNombre(String nombreFichero, String nombreServicio); 
    
    void buscarUnServicio(String nombreFichero, String buscar);
        
    String borrarHistorialActividad(String nombreFichero);
    
    void borrarUnServicio(String nombreFichero);
    
    //////
    
    double CalcularFactura(String nombreFichero);

}
