package Test;

import com.peluqueria.dominio.Servicio;
import com.peluqueria.negocio.*;
import java.util.Scanner;

public class testPeluqueria {

    public static void main(String[] args) {
        var nombrefichero = "Peluqueria.txt";
        IActividadPeluqueria historialServicios = new ActividadPeluqueriaImpl();

        String nombreServicioAdd = "";
        double precioAdd = 0.0;
        int duracionAdd = 0;
        String descripcionAdd = "";
        int opcion;

        while (true) {
            System.out.println("*** MENÚ ***");
            System.out.println(" 1.- Crear Fichero");
            System.out.println(" 2.- Agregar nuevos Servicios");
            System.out.println(" 3.- Visualizar los servicios");
            System.out.println(" 4.- Buscar un servicio");
            System.out.println(" 0.- Salir");
            System.out.println("Introduzca una opción: ");
            Scanner ent = new Scanner(System.in);
            opcion = Integer.parseInt(ent.nextLine());

            switch (opcion) {
                case 1:
                    historialServicios.iniciarHistorialActividad(nombrefichero);
                    break;
                case 2:
                    System.out.print("Introduce el nombre de la servicio a agregar:\t");
                    Scanner dato = new Scanner(System.in);
                    nombreServicioAdd = dato.nextLine();

                    System.out.print("Introduce el precio de la servicio a agregar:\t");
                    precioAdd = dato.nextDouble();

                    System.out.print("Introduce la duración del servicio:\t");
                    duracionAdd = dato.nextInt();

                    System.out.println("Introduce la descripción del servicio: ");
                    descripcionAdd = dato.nextLine();

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
                default:
                    System.out.println("Introduzca un número entre 0 y 5");

            }
            System.out.println();
        }
    }
}
