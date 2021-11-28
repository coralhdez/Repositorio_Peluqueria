
package com.cine.datos;

import com.cine.dominio.Cine;
import com.cine.dominio.Producto;
import com.cine.dominio.Proveedor;
import com.cine.excepciones.ExcepcionesAccesoDatos;
import com.cine.excepciones.ExcepcionesEscritura;
import com.cine.excepciones.ExcepcionesLectura;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class AccesoDatosCineImpl implements IAccesoDatosCine {

    @Override
    public boolean existe(String nombreFichero) {
         File fichero = new File(nombreFichero);
        return fichero.exists();
    }

    @Override
    public void crear(String nombreFichero) throws ExcepcionesAccesoDatos {
        File fichero = new File(nombreFichero);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(fichero)); //creo el fichero
            salida.close(); //cierro fichero

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionesAccesoDatos("Error intentando crear el fichero");
        }
    }

    @Override
    public List<Cine> leer(String nombreFichero) throws ExcepcionesLectura {
        File fichero = new File(nombreFichero);
        List<Cine> lista = new ArrayList<Cine>();

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(fichero));

            var lectura = entrada.readLine();
            //String[] cadenaGrafica = lectura.split(";");
            while (lectura != null) {
                String[] array = lectura.split(";");
                Cine CineNuevo = new Cine(Integer.parseInt(array[0]),(array[1]), array[2] ,array[3],Integer.parseInt(array[4]));
                lista.add(CineNuevo);
                lectura = entrada.readLine();
            }
            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new ExcepcionesLectura("Error de lectura listando los cines");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        return lista;
    }

    @Override
    public void escribir(Cine cine, String nombreFichero, boolean anexar) throws ExcepcionesEscritura {
       
        File fichero = new File(nombreFichero);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(nombreFichero, true)); //añade una nueva linea con la info del objeto
            String pedidoTxt = cine.getIdCine()
                    + ";" + cine.getNombre()
                    + ";" + cine.getTelefono()
                    + ";" + cine.getCiudad()
                    + ";" + cine.getAforo();
            
            salida.println(pedidoTxt);
            salida.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionesEscritura("Error de escritura al introducir un cine en el archivo");
        }
    }

    @Override
    public String borrarFichero(String nombreFichero) {
        File fichero = new File(nombreFichero);
        String mensaje = "";

        if (existe(nombreFichero)) {
            fichero.delete();
            mensaje = "Fichero borrado";
        } else {
            mensaje = "No existe el fichero, no se ha podido borrar";
        }
        return mensaje;
    }

    @Override
    public void borrarCine(String nombreFichero, String buscar) throws ExcepcionesAccesoDatos {
        File archivo = new File(nombreFichero);

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            //Creamos el archivo
            PrintWriter salida = new PrintWriter(archivo);
            System.out.println("Se ha creado con exito el fichero");

            while (lectura != null) {
                String[] cine = lectura.split(";");

                if (cine[1].equalsIgnoreCase(buscar)) {
                    lectura = entrada.readLine();
                    continue;
                }

                //Escribimos las lineas que no queremos eliminar
                salida = new PrintWriter(new FileWriter(archivo, true));
                salida.println(lectura);
                salida.close();

                //Pasamos a la siguiente linea
                lectura = entrada.readLine();
            }

            if (lectura == null) {
                if (archivo.exists() == true) {
                    archivo.delete();
                    System.out.println("El fichero a sido eliminado");
                } else {
                    System.out.println("El fichero que quieres eliminar no existe");
                }
                System.out.println("Se han eliminado las lineas");
            }

            entrada.close();

            //convertimos en fichero original a la copia que contiene los datos que no han sido borrados
            if (existe(nombreFichero)) {
                borrarFichero(nombreFichero);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public String buscar(String buscar, String nombreFichero) throws ExcepcionesLectura {
       File archivo = new File(nombreFichero);
        String mensaje = "";
        int linea = 0;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            var lectura = entrada.readLine();

            while (lectura != null) {
                String[] cine = lectura.split(";");
                linea = linea + 1;
                if (cine[1].equalsIgnoreCase(buscar)) {
                    mensaje = "Nombre del fichero : " + nombreFichero + "\n" + "Producto : " + lectura + "\n" + "Linea : " + linea;
                    break;
                }

                lectura = entrada.readLine();
            }

            if (lectura == null) {
                System.out.println("Producto no encontrado");
            }

            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionesLectura("Error al leerlo");
        } catch (IOException ex) {
            throw new ExcepcionesLectura("No se ha encontrado el archivo");
        }

        return mensaje;
    }
    
}
