package com.peluqueria.datos;

import com.peluqueria.dominio.NombreServicio;
import com.peluqueria.dominio.Servicio;
import com.peluqueria.excepciones.*;
import java.util.*;

public interface IAccesoDatosFichero {

    boolean existeFichero(String nombreFichero); //si existe o no el fichero
    
    void crearFichero(String nombreFichero) throws ExcepcionesAccesoDatos; //crea el fichero
    
    List<Servicio> leerContenidoFichero(String nombreFichero)throws ExcepcionesLectura;
    
    void escribirServicioFichero(Servicio servicio, String nombreFichero, boolean anexar)throws ExcepcionesEscritura;
    
    String borrarFichero(String nombreFichero);
    
    void borrarServicioFichero(String nombreFichero, String nombreServicioBorrar) throws ExcepcionesAccesoDatos;
    
     int buscarServicio(String buscar, String nombreFichero) throws ExcepcionesLectura;
}
