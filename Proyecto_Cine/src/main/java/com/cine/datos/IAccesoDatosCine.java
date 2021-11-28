
package com.cine.datos;

import com.cine.dominio.Cine;
import com.cine.dominio.Producto;
import com.cine.excepciones.ExcepcionesAccesoDatos;
import com.cine.excepciones.ExcepcionesEscritura;
import com.cine.excepciones.ExcepcionesLectura;
import java.util.List;


public interface IAccesoDatosCine {
    boolean existe(String nombreFichero); //si existe o no el fichero

    void crear(String nombreFichero) throws ExcepcionesAccesoDatos; //crea el fichero

    List<Cine> leer (String nombreFichero) throws ExcepcionesLectura;

    void escribir(Cine pedido, String nombreFichero, boolean anexar) throws ExcepcionesEscritura;

    String borrarFichero(String nombreFichero);

    void borrarCine(String nombreFichero, String buscar) throws ExcepcionesAccesoDatos;

    String buscar(String buscar, String nombreFichero) throws ExcepcionesLectura;
}
