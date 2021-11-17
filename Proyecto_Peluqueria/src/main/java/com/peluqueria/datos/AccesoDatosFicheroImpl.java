package com.peluqueria.datos;

import com.peluqueria.dominio.*;
import com.peluqueria.excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosFicheroImpl implements IAccesoDatosFichero {

    @Override
    public boolean existeFichero(String nombreFichero) {
        File fichero = new File(nombreFichero);
        return fichero.exists();
    }

    @Override //CREAR EL FICHERO    
    public void crearFichero(String nombreFichero) throws ExcepcionesAccesoDatos {
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
    public List<Servicio> leerContenidoFichero(String nombreFichero) throws ExcepcionesLectura {
        File fichero = new File(nombreFichero); //objeto tipo fichero
        Servicio servicioNuevo = null;
        String[] servicio = new String[5];
        List<Servicio> servicios = new ArrayList<>();

        try {
            //Objeto para entrar al fichero
            BufferedReader entrada = new BufferedReader(new FileReader(fichero));
            String lectura = null;

            while ((lectura = entrada.readLine()) != null) {
                servicio = lectura.split(",");
                servicioNuevo = new Servicio(Integer.parseInt(servicio[0]), servicio[1], Double.parseDouble(servicio[2]), Integer.parseInt(servicio[3]), servicio[4]);
                servicios.add(servicioNuevo);
            }
            entrada.close();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionesLectura("Error de lectura leyendo los servicios");
        }

        return servicios;
    }

    @Override
    public void escribirServicioFichero(Servicio servicio, String nombreFichero, boolean anexar) throws ExcepcionesEscritura {
        File fichero = new File(nombreFichero);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(nombreFichero, true)); //añade una nueva linea con la info del objeto
            String servicioTxt = servicio.getIdServicio()
                    + ", " + servicio.getNombreServicio()
                    + ", " + servicio.getPrecio()
                    + ", " + servicio.getDuracion()
                    + ", " + servicio.getDescripcion();

            salida.println(servicioTxt);
            salida.close();

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new ExcepcionesEscritura("Error de escritura al introducir un Servicio en el archivo");
        }
    }

    @Override
    public String borrarFichero(String nombreFichero) {
        File fichero = new File(nombreFichero);
        String mensaje = "";

        if (existeFichero(nombreFichero)) {
            fichero.delete();
            mensaje = "Fichero borrado";
        } else {
            mensaje = "No existe el fichero, no se ha podido borrar";
        }
        return mensaje;
    }

    @Override
    public void borrarServicioFichero(String nombreFichero, String nombreServicioBorrar) throws ExcepcionesAccesoDatos {
        File archivOriginal = new File(nombreFichero);
        File archivoCopia = new File(nombreFichero);
        String[] servicio = new String[5];

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivOriginal));
            PrintWriter salida = new PrintWriter(new PrintWriter(archivoCopia));
            String lectura = null;
            while ((lectura = entrada.readLine()) != null) {
                servicio = lectura.split(",");
                if (servicio[1] != nombreFichero) { //nombreProducto
                    salida.println(servicio);
                }
            }
            entrada.close();
            salida.close();

           //convertimos en fichero original a la copia que contiene los datos que no han sido borrados
            if (existeFichero(nombreFichero)) {
                borrarFichero(nombreFichero);
            }
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        }catch(IOException ex){
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public int buscarServicio(String buscar, String nombreFichero) throws ExcepcionesLectura {
        File fichero = new File(nombreFichero);
        String[] servicioTxt = new String[5];
        int contador = 1;
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(fichero));
            String  lectura = entrada.readLine();
            
             while (lectura != null) {
                servicioTxt = lectura.split(";"); //me devuelve un array string

                if (buscar.equalsIgnoreCase(servicioTxt[1])) { //el nombre                  
                    break;
                }
                contador++;
            }
             entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
            throw new ExcepcionesLectura("Error al buscar un servicio");
        } catch (IOException ex) {
            throw new ExcepcionesLectura("Error al buscar un servicio");
        }
        return contador;
    }
}
