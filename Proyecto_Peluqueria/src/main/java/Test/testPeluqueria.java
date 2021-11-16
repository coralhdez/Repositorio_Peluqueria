package Test;

import com.peluqueria.dominio.Servicio;
import com.peluqueria.negocio.*;
import java.util.Scanner;

public class testPeluqueria {

    public static void main(String[] args) {
        var nombrefichero = "Peluqueria.txt";
        //ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
        IActividadPeluqueria historialServicios = new ActividadPeluqueriaImpl();

        while (true) {
            System.out.println("MENU");
            System.out.println(" 1.- Crear Fichero");
            System.out.println(" 2.- Agregar nuevos Servicios");
            System.out.println(" 3.- Visualizar los servicios");
            System.out.println(" 4.- Buscar un servicio");
            System.out.println(" 0.- Salir");
            System.out.print("Indica la opción deseada: ");
            Scanner sn = new Scanner(System.in);
            int opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    historialServicios.iniciarHistorialActividad(nombrefichero);
                    break;
                case 2:
                    System.out.print("Introduce el nombre de la servicio a agregar:\t");
                    Scanner dato = new Scanner(System.in);
                    String nombreServicioAdd = dato.nextLine();

                    System.out.print("Introduce el precio de la servicio a agregar:\t");
                    double precioAdd = dato.nextDouble();

                    System.out.print("Introduce la duración del servicio:\t");
                    int duracionAdd = dato.nextInt();
                    
                    System.out.println("Introduce la descripción del servicio: ");
                    String descripcionAdd = dato.nextLine();
                   
                    historialServicios.agregarServicio(nombrefichero, new Servicio(nombreServicioAdd, precioAdd, duracionAdd, descripcionAdd));
                    break;
                case 3:
                    historialServicios.leerServicios(nombrefichero);
                    break;
                case 4:
                    Scanner busqueda = new Scanner(System.in);
                    busqueda.nextLine();
                    System.out.printf("Intorduce el nombre de la servicio a buscar: ");
                    String pBuscar = busqueda.nextLine();
                    historialServicios.buscarUnServicio(nombrefichero, pBuscar);
                    break;
                case 0:
                    System.out.println("Gracias!, hasta la proxima");
                    break;

            }
        }

    }
}

