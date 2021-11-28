package com.cine.negocio;

import com.cine.datos.AccesoDatosFicheroImpl;
import com.cine.datos.IAccesoDatosFichero;
import com.cine.dominio.Cine;
import com.cine.datos.IAccesoDatosCine;

public interface IListadoCine {

    String iniciarHistorialEmpresas(String nombreFichero);

    void agregarUnaEmpresa(String nombreFichero, Cine pedido);

    String leerEmpresas(String nombreFichero);

    void BuscarEmpresaId(String nombreFichero, int id);

    void buscarUnaEmpresa(String nombreFichero, String buscar);

    String borrarHistorialEmpresas(String nombreFichero);

    void borrarUnaEmpresa(String nombreFichero, String busqueda);

    void menosAforo(String nombreFichero);

    void ordenarPorAforo(String nombreArchivo);

}
