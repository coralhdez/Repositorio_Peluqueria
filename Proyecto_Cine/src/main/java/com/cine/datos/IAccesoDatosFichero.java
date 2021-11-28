package com.cine.datos;

import com.cine.dominio.*;
import com.cine.excepciones.*;
import java.util.*;

public interface IAccesoDatosFichero {

       boolean existe(String nombreFichero); //si existe o no el fichero

    void crear(String nombreFichero) throws ExcepcionesAccesoDatos; //crea el fichero

    List<Producto> leer (String nombreFichero) throws ExcepcionesLectura;

    void escribir(Producto producto, String nombreFichero, boolean anexar) throws ExcepcionesEscritura;

    String borrarFichero(String nombreFichero);

    void borrarProducto(String nombreFichero, String buscar) throws ExcepcionesAccesoDatos;

    String buscar(String buscar, String nombreFichero) throws ExcepcionesLectura;
}
