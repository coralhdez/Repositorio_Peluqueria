package com.cine.negocio;

import com.cine.datos.*;
import com.cine.dominio.*;
import com.cine.excepciones.*;
import com.cine.excepciones.ExcepcionesEscritura;
import java.text.SimpleDateFormat;
import java.util.*;

public class ActividadCineImpl implements IActividadCine {

    private final IAccesoDatosFichero datos;

    public ActividadCineImpl() {
        this.datos = new AccesoDatosFicheroImpl();
    }

    @Override
    public String iniciarHistorialCine(String nombreFichero) {
        if (this.datos.existe(nombreFichero)) {
            this.datos.borrarFichero(nombreFichero);
        } else {
            try {
                this.datos.crear(nombreFichero);
            } catch (ExcepcionesAccesoDatos ex) {
                ex.printStackTrace(System.out);
                System.out.println("Excepción intentando inicializar el historial de productos");
            }
        }
        return "historial de productos inicializado";
    }

    @Override
    public void agregarUnProducto(String nombreFichero, Producto producto) {
        if (this.datos.existe(nombreFichero)) {
            try {
                this.datos.escribir(producto, nombreFichero, true);
            } catch (ExcepcionesEscritura ex) {
                ex.printStackTrace(System.out);
                System.out.println("Error al escribir en el historial de productos");
            }
        } else {
            System.out.println("historial de productoss no incializado");
        }
    }

    @Override
    public String leerProductos(String nombreFichero) {
        List<Producto> arrayProductos = new ArrayList<>();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String dateToStr = formatoFecha.format(date);

        try {
            arrayProductos = this.datos.leer(nombreFichero);
            arrayProductos.forEach(producto -> {
                System.out.println("Producto:"
                        + producto.getIdProducto()
                        + ";" + producto.getnombre()
                        + ";" + producto.getProveedor()
                        + ";" + producto.getCantidad()
                        + ";" + producto.getPrecio()
                        + ";" + producto.getFechaCaducidad()
                );
            });
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error leyendo el historial de productos");
        }
        return "Listado de productos: ";
    }

    @Override
    public void BuscarPorductoId(String nombreFichero, int id) {
        List<Producto> arrayProductos = new ArrayList<>();

        try {
            arrayProductos = this.datos.leer(nombreFichero);
            for (int i = 0; i < arrayProductos.size(); i++) {
                if (arrayProductos.get(i).getIdProducto() == id) {
                    System.out.println(arrayProductos.get(i).toString());
                }
            }
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al leer un producto");
        }

    }

    @Override
    public void buscarUnProducto(String nombreFichero, String buscar) {
        try {
            System.out.println(this.datos.buscar(nombreFichero, buscar));
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Error al buscar productos en el historial de productos");
        }
    }

    @Override
    public String borrarHistorialProductos(String nombreFichero) {
        this.datos.borrarFichero(nombreFichero);
        return "Historia de productos borrado";
    }

    @Override
    public void borrarUnProducto(String nombreFichero, String busqueda) {
        try {
            this.datos.borrarProducto(nombreFichero, busqueda);
        } catch (ExcepcionesAccesoDatos ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción al eliminar un servicio del Fichero");
        }
        System.out.println("Producto borrado");
    }

    @Override
    public void TotalPrecio(String nombreFichero) {
        List<Producto> productos = new ArrayList<>();
        double total = 0.0;
        try {
            productos = this.datos.leer(nombreFichero);
            for (int i = 0; i < productos.size(); i++) {
                total += productos.get(i).getPrecio();
            }
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción leyendo el fichero");
        }
        System.out.println("El importe total es: " + total + " €");
    }

    @Override
    public void productoMasCaro(String nombreFichero) {
        List<Producto> productos = new ArrayList<>();
        double max = -1000;
        try {
            productos = this.datos.leer(nombreFichero);
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).getPrecio() > max) {
                    max = productos.get(i).getPrecio();
                }
            }
            for (int i = 0; i < productos.size(); i++) {
                if (productos.get(i).getPrecio() == max) {
                    System.out.println("El producto más caro del almacén es: : " + productos.get(i).getnombre());
                }
            }
            
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción leyendo el fichero");
        }
        System.out.println("Su precio es de : " + max + " €");

    }


    public void precioPorProducto(String nombreFichero) {
        List<Producto> productos = new ArrayList<>();

        try {
            productos = this.datos.leer(nombreFichero);
            for (int i = 0; i < productos.size(); i++) {
                System.out.println(productos.get(i).getnombre() + " es: " + (productos.get(i).getCantidad() * productos.get(i).getPrecio()) + " €");
            }
        } catch (ExcepcionesLectura ex) {
            ex.printStackTrace(System.out);
            System.out.println("Excepción leyendo el fichero");
        }
    }
    
    
        @Override
    public void ordenarPorMenosCantidad(String nombreArchivo) {
        List<Producto> lista = new ArrayList<>();

        try {
            lista = datos.leer(nombreArchivo);
            lista.sort((Producto nombre_1, Producto nombre_2) -> {
                return nombre_1.getCantidad() - nombre_2.getCantidad();
            });
            lista.forEach(producto -> {
                System.out.println("Producto: "
                        + producto.getIdProducto()
                        + " ; " + producto.getnombre()
                        + " ; " + producto.getProveedor()
                        + " ; " + producto.getCantidad()
                        + " ; " + producto.getPrecio()
                        + " ; " + producto.getFechaCaducidad());
            });

        } catch (ExcepcionesLectura e) {
            e.printStackTrace(System.out);
        }
    }

}
