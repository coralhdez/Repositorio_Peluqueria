package com.cine.negocio;

import com.cine.datos.AccesoDatosCineImpl;
import com.cine.dominio.*;
import com.cine.excepciones.ExcepcionesAccesoDatos;
import com.cine.excepciones.ExcepcionesEscritura;
import com.cine.excepciones.ExcepcionesLectura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.cine.datos.IAccesoDatosCine;

public class ListadoCineImpl implements IListadoCine {

    private final IAccesoDatosCine datos;

    public ListadoCineImpl() {
        this.datos = new AccesoDatosCineImpl();
    }

    @Override
    public String iniciarHistorialEmpresas(String nombreFichero) {
        if (this.datos.existe(nombreFichero)) {
            this.datos.borrarFichero(nombreFichero);
        } else {
            try {
                this.datos.crear(nombreFichero);
            } catch (ExcepcionesAccesoDatos ex) {
                ex.printStackTrace(System.out);
                System.out.println("Excepción intentando inicializar el historial de cines");
            }
        }
        return "historial de pedidos inicializado";
    }

    @Override
    public void agregarUnaEmpresa(String nombreFichero, Cine cine) {
        if (this.datos.existe(nombreFichero)) {
            try {
                this.datos.escribir(cine, nombreFichero, true);
            } catch (ExcepcionesEscritura ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error al escribir en el historial de cines");
            }
        } else {
            System.out.println("historial de cines no incializado");
        }
    }

    @Override
    public String leerEmpresas(String nombreFichero) {
        List<Cine> arrayCines = new ArrayList<>();

        try {
            arrayCines = this.datos.leer(nombreFichero);
            arrayCines.forEach(cine -> {
                System.out.println("Cines:"
                        + cine.getIdCine()
                        + ";" + cine.getNombre()
                        + ";" + cine.getTelefono()
                        + ";" + cine.getCiudad()
                        + ";" + cine.getAforo()
                );
            });
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error leyendo el historial de cines");
        }
        return "Listado de cines: ";
    }

    @Override
    public void BuscarEmpresaId(String nombreFichero, int id) {
        List<Cine> arrayCines = new ArrayList<>();

        try {
            arrayCines = this.datos.leer(nombreFichero);
            for (int i = 0; i < arrayCines.size(); i++) {
                if (arrayCines.get(i).getIdCine() == id) {
                    System.out.println(arrayCines.get(i).toString());
                }
            }
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al leer un cine");
        }

    }

    @Override
    public void buscarUnaEmpresa(String nombreFichero, String buscar) {
        try {
            System.out.println(this.datos.buscar(nombreFichero, buscar));
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al buscar cines en el historial de pedidos");
        }

    }

    @Override
    public String borrarHistorialEmpresas(String nombreFichero) {
        this.datos.borrarFichero(nombreFichero);
        return "Historia de cines borrado";
    }

    @Override
    public void borrarUnaEmpresa(String nombreFichero, String busqueda) {
        try {
            this.datos.borrarCine(nombreFichero, busqueda);
        } catch (ExcepcionesAccesoDatos ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción al eliminar un cine del Fichero");
        }
        System.out.println("Pedido borrado");
    }

    @Override
    public void menosAforo(String nombreFichero) {
        List<Cine> cines = new ArrayList<>();
        int min = 1000000;
        try {
            cines = this.datos.leer(nombreFichero);
            for (int i = 0; i < cines.size(); i++) {
                if (cines.get(i).getAforo() < min) {
                    min = cines.get(i).getAforo();
                }
            }
            for (int i = 0; i < cines.size(); i++) {
                if (cines.get(i).getAforo() == min) {
                    System.out.println("El cine con menos aforo es : " + cines.get(i).getNombre());
                }
            }

        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción leyendo el fichero");
        }
        System.out.println("Su aforo es de : " + min + " €");

    }

    @Override
    public void ordenarPorAforo(String nombreArchivo) {
        List<Cine> lista = new ArrayList<>();

        try {
            lista = datos.leer(nombreArchivo);
            lista.sort((Cine nombre_1, Cine nombre_2) -> {
                return nombre_2.getAforo() - nombre_1.getAforo();
            });
            lista.forEach(cine -> {
                System.out.println("Cine: "
                        + cine.getIdCine()
                        + " ; " + cine.getNombre()
                        + " ; " + cine.getTelefono()
                        + " ; " + cine.getCiudad()
                        + " ; " + cine.getAforo()
                );
            });

        } catch (ExcepcionesLectura e) {
            e.printStackTrace(System.out);
        }
    }

}
