package com.peluqueria.negocio;

import com.peluqueria.datos.*;
import com.peluqueria.dominio.*;
import com.peluqueria.excepciones.*;
import com.peluqueria.excepciones.ExcepcionesEscritura;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActividadPeluqueriaImpl implements IActividadPeluqueria {

    private final IAccesoDatosFichero datos;

    public ActividadPeluqueriaImpl() {
        this.datos = new AccesoDatosFicheroImpl();
    }

    @Override
    public String iniciarHistorialActividad(String nombreFichero) {
        if (this.datos.existeFichero(nombreFichero)) {
            this.datos.borrarFichero(nombreFichero);
        } else {
            try {
                this.datos.crearFichero(nombreFichero);
            } catch (ExcepcionesAccesoDatos ex) {
                ex.printStackTrace(System.out);
                System.out.println("Excepción intentando inicializar el historial de servicios");
            }
        }
        return "historial de servicios inicializado";
    }

    @Override
    public void agregarServicio(String nombreFichero, Servicio servicio) {
        if (this.datos.existeFichero(nombreFichero)) {
            try {
                this.datos.escribirServicioFichero(servicio, nombreFichero, true);
            } catch (ExcepcionesEscritura ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error al escribir en el historial de servicios");
            }
        } else {
            System.out.println("historial de servicios no incializado");
        }
    }

    @Override
    public String leerServicios(String nombreFichero) {
        List<Servicio> arrayServicios = new ArrayList<>();

        try {
            arrayServicios = this.datos.leerContenidoFichero(nombreFichero);

            for (int i = 0; i < arrayServicios.size(); i++) {
                System.out.println("Servicios: "
                        + arrayServicios.get(i).getNombreServicio()
                        + arrayServicios.get(i).getPrecio()
                        + arrayServicios.get(i).getDuracion()
                        + arrayServicios.get(i).getDescripcion());
            }
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error leyendo el historial de servicios");
        }
        return "";
    }

    @Override
    public void mostrarPorductoNombre(String nombreFichero, String nombreServicio) {
        List<Servicio> arrayProductos = new ArrayList<>();

        try {
            arrayProductos = this.datos.leerContenidoFichero(nombreFichero);
            for (int i = 0; i < arrayProductos.size(); i++) {
                if (arrayProductos.get(i).getNombreServicio() == nombreServicio) {
                    arrayProductos.get(i).toString();
                }
            }
        } catch (ExcepcionesLectura ex) {

        }

    }

    @Override
    public void buscarUnServicio(String nombreFichero, String buscar) {
        try {
            this.datos.buscarServicio(buscar, nombreFichero);
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al buscar servicios en el historial de servicios");
        }     
    }

    @Override
    public String borrarHistorialActividad(String nombreFichero) {
        this.datos.borrarFichero(nombreFichero);
        return "Historia de servicios borrado";
    }

    @Override
    public void borrarUnServicio(String nombreFichero) {
        try {
            this.datos.borrarServicioFichero(nombreFichero, nombreFichero);
        } catch (ExcepcionesAccesoDatos ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción al eliminar un servicio del Fichero");
        }
        System.out.println("Servicio borrado");
    }

    @Override
    public double CalcularFactura(String nombreFichero) {
        List<Servicio> servicios = new ArrayList<>();
        double total = 0.0;
        try {
            servicios = this.datos.leerContenidoFichero(nombreFichero);
            for (int i = 0; i < servicios.size(); i++) {
                total += servicios.get(i).getPrecio();
            }
        } catch (ExcepcionesLectura ex) {
           ex.printStackTrace(System.out);
            System.out.println("Excepción leyendo el fichero");
        }
        return total;
    }

}
