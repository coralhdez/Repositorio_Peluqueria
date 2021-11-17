package Test;

import com.peluqueria.datos.EmpleadoDao;
import com.peluqueria.dominio.Empleado;
import com.peluqueria.dominio.Servicio;
import com.peluqueria.negocio.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class testPeluqueria {

    public static void main(String[] args) throws SQLException {

        //empleados();
        fichero();
//        var nombrefichero = "Peluqueria.txt";
//        IActividadPeluqueria historialServicios = new ActividadPeluqueriaImpl();
//
//        String nombreServicioAdd = "";
//        double precioAdd = 0.0;
//        int duracionAdd = 0;
//        String descripcionAdd = "";
//        int opcion;
//
//        while (true) {
//            System.out.println("*** MENÚ ***");
//            System.out.println(" 1.- Crear Fichero");
//            System.out.println(" 2.- Agregar nuevos Servicios");
//            System.out.println(" 3.- Visualizar los servicios");
//            System.out.println(" 4.- Buscar un servicio");
//            System.out.println(" 0.- Salir");
//            System.out.println("Introduzca una opción: ");
//            Scanner ent = new Scanner(System.in);
//            opcion = Integer.parseInt(ent.nextLine());
//
//            switch (opcion) {
//                case 1:
//                    historialServicios.iniciarHistorialActividad(nombrefichero);
//                    break;
//                case 2:
//                    System.out.print("Introduce el nombre de la servicio a agregar:\t");
//                    Scanner dato = new Scanner(System.in);
//                    nombreServicioAdd = dato.nextLine();
//
//                    System.out.print("Introduce el precio de la servicio a agregar:\t");
//                    precioAdd = dato.nextDouble();
//
//                    System.out.print("Introduce la duración del servicio:\t");
//                    duracionAdd = dato.nextInt();
//
//                    System.out.println("Introduce la descripción del servicio: ");
//                    descripcionAdd = dato.nextLine();
//
//                    historialServicios.agregarServicio(nombrefichero, new Servicio(nombreServicioAdd, precioAdd, duracionAdd, descripcionAdd));
//                    break;
//                case 3:
//                    historialServicios.leerServicios(nombrefichero);
//                    break;
//                case 4:
//                    Scanner busqueda = new Scanner(System.in);
//                    busqueda.nextLine();
//                    System.out.printf("Intorduce el nombre de la servicio a buscar: ");
//                    String pBuscar = busqueda.nextLine();
//                    historialServicios.buscarUnServicio(nombrefichero, pBuscar);
//                    break;
//                default:
//                    System.out.println("Introduzca un número entre 0 y 5");
//
//            }
//            System.out.println();
//        }

    }

    public static void fichero() throws SQLException {
        var nombrefichero = "Peluqueria.txt";
        IActividadPeluqueria historialServicios = new ActividadPeluqueriaImpl();

        String nombreServicioAdd = "";
        double precioAdd = 0.0;
        int duracionAdd = 0;
        String descripcionAdd = "";
        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("*** MENÚ ***");
            System.out.println(" 1.- Crear Fichero");
            System.out.println(" 2.- Agregar nuevos Servicios");
            System.out.println(" 3.- Visualizar los servicios");
            System.out.println(" 4.- Buscar un servicio");
            System.out.println(" 0.- Salir");
            System.out.println("Seleccione una opción: ");
            
            opcion = scn.nextInt();

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
                    System.out.printf("Intorduce el nombre de la servicio a buscar: ");
                    Scanner busqueda = new Scanner(System.in);
                    busqueda.nextLine();
                    String pBuscar = busqueda.nextLine();
                    historialServicios.buscarUnServicio(nombrefichero, pBuscar);
                    break;

                case 0:

                    break;
            }

        }
    }

    public static void empleados() throws SQLException {
        EmpleadoDao objetosPersonasDAO = new EmpleadoDao();
        //OBJETOS CLASE PRODUCTO
        Empleado empleado1 = new Empleado(3, "Cristina", "Benito", "Sánchez", "50998745-S", "644558877", "Peluquera");
        Empleado empleado2 = new Empleado(4, "Lucía", "Pérez", "García", "50145874-T", "63855421", "Esteticien");
        Empleado empleado3 = new Empleado(5, "Carlos", "Alonso", "Martín", "50124896-H", "65145872", "Peluquero");

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione el alumno para calcular su media");
            System.out.println("1.-Añadir Empleados");
            System.out.println("2.-Actualizar datos");
            System.out.println("3.- Borrar empleado de la Base de Datos");
            System.out.println("4.- Acceder a los empleados");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");
            
            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    objetosPersonasDAO.insertar(empleado1);
                    objetosPersonasDAO.insertar(empleado2);
                    objetosPersonasDAO.insertar(empleado3);
                    break;
                case 2:
                    objetosPersonasDAO.actualizar(new Empleado(5, "Carlossss", "Alonso", "Martín", "50124896-H", "65145872", "Peluquero"));
                    break;

                case 3:
                    objetosPersonasDAO.borrar(empleado2);
                    break;

                case 4:
                    List<Empleado> productos = objetosPersonasDAO.seleccionar();
                    productos.forEach(empleado -> {
                        System.out.println("Producto: " + empleado);
                    });
                    break;

                case 0:

                    break;

            }

        }
    }
}
