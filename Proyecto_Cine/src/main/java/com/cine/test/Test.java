package com.cine.test;

import com.cine.datos.*;
import com.cine.dominio.*;
import com.cine.negocio.*;
import java.sql.SQLException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main(String[] args) throws SQLException, ParseException {

        //clientes();
        //empleados();
        //fichero();
        //categorias();
        menuPrincipal();
        //empresas();

    }

    public static void menuPrincipal() throws SQLException, ParseException {
        IActividadCine historialProductos = new ActividadCineImpl();
        int opcion;
        System.out.println("\t******************************\n"
                + "\t           MENÚ EMPRESA"
                + "\n\t*******************************\n"
                + "\t1. Accede al fichero de Inventario \n"
                + "\t2. Accede al fichero de Cines \n"
                + "\t3. Accede a la BBDD \n"
                + "\t0. Salir\n"
                + "Introduzca una opcion: "
        );
        do {
            Scanner sn = new Scanner(System.in);
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    fichero();
                    break;
                case 2:
                    empresas();
                    break;
                case 3:
                    menuBBDD();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    return;
                default:
                    System.out.println("Valor erroneo");
            }
        } while (opcion != 0);
    }

    public static void menuBBDD() throws SQLException, ParseException {
        IActividadCine historialProductos = new ActividadCineImpl();
        int opcion;
        System.out.println("\t*****************************\n"
                + "\t           BASE DE DATOS"
                + "\n\t*******************************\n"
                + "\t1. Socios \n"
                + "\t2. Empleados \n"
                + "\t3. Puestos laborales \n"
                + "\t0. Salir\n"
                + "Introduzca una opcion: "
        );
        do {
            Scanner sn = new Scanner(System.in);
            opcion = sn.nextInt();
            switch (opcion) {
                case 1:
                    clientes();
                    break;
                case 2:
                    empleados();
                    break;
                case 3:
                    categorias();
                    break;
                case 0:
                    menuPrincipal();
                    return;
                default:
                    System.out.println("Valor erroneo");
            }
        } while (opcion != 0);
    }

    public static void fichero() throws SQLException, ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaComoCadena = formatoFecha.format(new Date());
        var nombrefichero = "Cine.txt";
        IActividadCine historialProductos = new ActividadCineImpl();

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("*** INVENTARIO ***");
            System.out.println(" 1.- Crear Fichero");
            System.out.println(" 2.- Agregar productos");
            System.out.println(" 3.- Visualizar productos");
            System.out.println(" 4.- Buscar Productos");
            System.out.println(" 5.- Borrar un productos");
            System.out.println(" 6.- Visualizar precio/producto del almacén");
            System.out.println(" 7.- Producto más caro");
            System.out.println(" 8.- Precio por Producto");
            System.out.println(" 9.- Ordenar por menor cantidad");
            System.out.println(" 0.- Volver al menú principal");
            System.out.println("Seleccione una opción: ");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    historialProductos.iniciarHistorialCine(nombrefichero);
                    break;
                case 2:
                    agregar();
                    break;
                case 3:
                    historialProductos.leerProductos(nombrefichero);
                    break;
                case 4:
                    buscar();
                    break;
                case 5:
                    System.out.println("Intorduce el nombre del producto a borrar: ");
                    Scanner buscar = new Scanner(System.in);
                    String borrar = buscar.nextLine();
                    historialProductos.borrarUnProducto(nombrefichero, borrar);
                    break;
                case 6:
                    historialProductos.TotalPrecio(nombrefichero);
                    break;
                case 7:
                    historialProductos.productoMasCaro(nombrefichero);
                    System.out.println("");
                    break;
                case 8:
                    System.out.println("El importe contabilizado en: ");
                    historialProductos.precioPorProducto(nombrefichero);
                    System.out.println("");
                case 9:
                    historialProductos.ordenarPorMenosCantidad(nombrefichero);
                    break;
                case 0:
                    System.out.println("Volver al Menú Principal");
                    menuPrincipal();
                    break;
            }

        }
    }

    public static void empresas() throws SQLException, ParseException {

        var ficheroCine = "empresas.txt";
        IListadoCine historialCines = new ListadoCineImpl();

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("*** CINES ***");
            System.out.println(" 1.- Crear Fichero");
            System.out.println(" 2.- Agregar cines");
            System.out.println(" 3.- Visualizar cines");
            System.out.println(" 4.- Buscar cines");
            System.out.println(" 5.- Borrar un cines");
            System.out.println(" 6.- Cine con menor aforo");
            System.out.println(" 7.- Ordenar por de mayor a menor aforo");
            System.out.println(" 0.- Salir");
            System.out.println("Seleccione una opción: ");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    historialCines.iniciarHistorialEmpresas(ficheroCine);
                    break;
                case 2:
                    agregarCines();
                    break;
                case 3:
                    historialCines.leerEmpresas(ficheroCine);
                    break;
                case 4:
                    System.out.println("Introduce el ID del cine: ");
                    Scanner busquedaId = new Scanner(System.in);
                    int id = busquedaId.nextInt();
                    historialCines.BuscarEmpresaId(ficheroCine, id);
                    break;
                case 5:
                    System.out.println("Intorduce el nombre del cine a borrar: ");
                    Scanner buscar = new Scanner(System.in);
                    String borrar = buscar.nextLine();
                    historialCines.borrarUnaEmpresa(ficheroCine, borrar);
                    break;
                case 6:
                    historialCines.menosAforo(ficheroCine);
                    break;
                case 7:
                    historialCines.ordenarPorAforo(ficheroCine);
                    break;
                case 0:
                    System.out.println("Volver al Menú Principal");
                    menuPrincipal();
                    break;
            }

        }
    }

    public static void agregarCines() throws SQLException, ParseException {
        var ficheroCine = "empresas.txt";
        IListadoCine historialCines = new ListadoCineImpl();
        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("¿Cómo desea agregar? ");
            System.out.println("1.- Introducir datos guardados en el sistema");
            System.out.println("2.- Introducir nuevo producto manualmente");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    historialCines.agregarUnaEmpresa(ficheroCine, new Cine("YelmoIdeal", "633855201", "Madrid", 3000));
                    historialCines.agregarUnaEmpresa(ficheroCine, new Cine("YelmoPalafox", "6301587520", "Madrid", 1000));
                    historialCines.agregarUnaEmpresa(ficheroCine, new Cine("YelmoBahia", "637410201", "Cádiz", 5000));                  
                    System.out.println("Se han agregado correctamente");
                    break;
                case 2:

                    String nombreAdd = "",
                     tel = "",
                     ciudad = "";
                    int aforo = 0;

                    Scanner dato = new Scanner(System.in);
                    Scanner dato2 = new Scanner(System.in);

                    System.out.println("Introduce el nombre del cine:\t");
                    nombreAdd = dato.nextLine();

                    System.out.println("Elija el teléfono:\t");
                    tel = dato.nextLine();

                    System.out.println("Introduce la ciudad:\t");
                    ciudad = dato.nextLine();

                    System.out.println("Introduce el aforo:\t");
                    aforo = dato2.nextInt();

                    Cine c = new Cine(nombreAdd, tel, ciudad, aforo);
                    historialCines.agregarUnaEmpresa(ficheroCine, c);

                    break;
                case 0:
                    System.out.println("Pulse 0 para volver al fichero");
                    empresas();
                    break;

            }

        }

    }

    public static void agregar() throws SQLException, ParseException {
        var nombrefichero = "Cine.txt";
        IActividadCine historialProductos = new ActividadCineImpl();

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("¿Cómo desea agregar? ");
            System.out.println("1.- Introducir productos guardados en el sistema");
            System.out.println("2.- Introducir nuevo producto manualmente");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    historialProductos.agregarUnProducto(nombrefichero, new Producto("kit kat", Proveedor.NESTLE, 7, 3.2, "25/09/2023"));
                    historialProductos.agregarUnProducto(nombrefichero, new Producto("fanta", Proveedor.COCACOLA, 20, 5.2, "25/11/2023"));
                    historialProductos.agregarUnProducto(nombrefichero, new Producto("coca cola", Proveedor.COCACOLA, 25, 5.2, "27/05/2023"));
                    System.out.println("Se han agregado los productos");
                    break;
                case 2:

                    String nombreProductoAdd = "";

                    double precioAdd = 0.0;
                    int cantidadAdd = 0;
                    Scanner dato = new Scanner(System.in);
                    Scanner dato2 = new Scanner(System.in);

                    System.out.println("Introduce el nombre de la producto a agregar:\t");
                    nombreProductoAdd = dato.nextLine();

                    System.out.println("Elija el proveedor del producto:\t");
                    Proveedor prov = proveedor();

                    System.out.println("Introduce la cantidad del producto:\t");
                    cantidadAdd = dato.nextInt();

                    System.out.println("Introduce el precio de la producto a agregar:\t");
                    precioAdd = dato2.nextDouble();

                    System.out.println("Introduce la fecha de caducidad o validez: \t");
                    String fecha = dato2.next();

                    Producto p = new Producto(nombreProductoAdd, prov, cantidadAdd, precioAdd, fecha);
                    historialProductos.agregarUnProducto(nombrefichero, p);
                    break;
                case 0:
                    System.out.println("Pulse 0 para volver al fichero");
                    fichero();
                    break;

            }

        }

    }

    public static void buscar() throws SQLException, ParseException {
        var nombrefichero = "Cine.txt";
        IActividadCine historialProductos = new ActividadCineImpl();

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("¿Cómo desea hacer la búsqueda? ");
            System.out.println("1.- Buscar por Nombre");
            System.out.println("2.- Buscar por ID");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Intorduce el nombre del producto a buscar: ");
                    Scanner busqueda = new Scanner(System.in);
                    String pBuscar = busqueda.nextLine();
                    historialProductos.buscarUnProducto(nombrefichero, pBuscar);
                    break;
                case 2:
                    System.out.println("Introduce el ID del producto: ");
                    Scanner busquedaId = new Scanner(System.in);
                    int id = busquedaId.nextInt();
                    historialProductos.BuscarPorductoId(nombrefichero, id);
                    break;
                case 0:
                    System.out.println("Pulse 0 para volver al fichero");
                    fichero();
                    break;

            }

        }

    }

//    public static void buscarEmpresa() throws SQLException, ParseException {
//        var ficheroCine = "empresas.txt";
//        IListadoCine historialCines = new ListadoCineImpl();
//
//        int opcion;
//        Scanner scn = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("¿Cómo desea hacer la búsqueda? ");
//            System.out.println("1.- Buscar por Nombre");
//            System.out.println("2.- Buscar por ID");
//            System.out.println("0.- Salir");
//            System.out.println("Seleccione una opción");
//
//            opcion = scn.nextInt();
//
//            switch (opcion) {
//                case 1:
//                    System.out.println("Intorduce el nombre del cine a buscar: ");
//                    Scanner busqueda = new Scanner(System.in);
//                    String pBuscar = busqueda.nextLine();
//                    historialCines.buscarUnaEmpresa(ficheroCine, pBuscar);
//                    break;
//                case 2:
//                    System.out.println("Introduce el ID del cine: ");
//                    Scanner busquedaId = new Scanner(System.in);
//                    int id = busquedaId.nextInt();
//                    historialCines.BuscarEmpresaId(ficheroCine, id);
//                    break;
//                case 0:
//                    System.out.println("Pulse 0 para volver al fichero");
//                    empresas();
//                    break;
//
//            }
//
//        }
//
//    }
    public static void clientes() throws SQLException, ParseException {
        ClienteDao objetosClienteDAO = new ClienteDao();
        //OBJETOS CLASE PRODUCTO
        ClienteDTO c1 = new ClienteDTO(1, "Lara", "Iglesias", "Santos", "54125987-W", "605070070", "lara@gmail.com", 0);
        ClienteDTO c2 = new ClienteDTO(2, "Iván", "Ramos", "Gutierrez", "51789352-H", "630120480", "ivan@gmail.com", 0);

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("*** CLIENTES *** ");
            System.out.println("1.- Dar de alta un socio");
            System.out.println("2.- Actualizar socio");
            System.out.println("3.- Borrar socio de la Base de Datos");
            System.out.println("4.- Listado de socios");
            System.out.println("5.- Ordenar socios alfabéticamente");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    //objetosClienteDAO.insertar(c1);
                    objetosClienteDAO.insertar(c2);
                    break;
                case 2:
                    objetosClienteDAO.actualizar(new ClienteDTO(2, "Ivánnnn", "Ramos", "Gutierrez", "51789352-H", "630120480", "ivan@gmail.com", 0));
                    break;
                case 3:
                    objetosClienteDAO.borrar(c2);
                    System.out.println("Socio Borrado con éxito");
                    break;
                case 4:
                    List<ClienteDTO> clientes = objetosClienteDAO.seleccionar();
                    clientes.forEach(cliente -> {
                        System.out.println("Cliente: " + cliente);
                    });
                    System.out.println("");
                    break;
                case 5:
                    List<ClienteDTO> clientes2 = objetosClienteDAO.ordenar();
                    clientes2.forEach(cliente -> {
                        System.out.println("Cliente: " + cliente);
                    });
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Volver al Menú de la BBDD");
                    menuBBDD();
                    break;

            }

        }
    }

    public static void empleados() throws SQLException, ParseException {

        EmpleadoDAO objetosEmpleadosDAO = new EmpleadoDAO();
        //OBJETOS CLASE PRODUCTO
        EmpleadoDTO e1 = new EmpleadoDTO(4, "Carlos", "Ocaña", "Santos", "57410320F", "carlos@gmail.com", 3, 0);
        EmpleadoDTO e2 = new EmpleadoDTO(5, "Miguel", "Costas", "Encabo", "57410000F", "miguel@gmail.com", 3, 0);
        EmpleadoDTO e3 = new EmpleadoDTO(6, "Lucas", "García", "Roldán", "54103258P", "lucas@gmail.com", 3, 0);

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("*** MENÚ EMPLEADOS*** ");
            System.out.println("1.- Dar de alta un empleado");
            System.out.println("2.- Actualizar empleados");
            System.out.println("3.- Dar de baja un empleado");
            System.out.println("4.- Listado de empleados");
            System.out.println("5.- Ordenar empleados alfabéticamente");
            System.out.println("6.- Empleados de Categoria Personal Base");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    //objetosEmpleadosDAO.insertar(e1);
                    objetosEmpleadosDAO.insertar(e2);                 
                    break;
                case 2:
                    objetosEmpleadosDAO.actualizar(new EmpleadoDTO(5, "Migueeeeel", "Costas", "Encabo", "57410000F", "miguel@gmail.com", 3, 0));
                    System.out.println("Se han actualizado los datos");
                    break;
                case 3:
                    objetosEmpleadosDAO.borrar(e2);
                    System.out.println("Empleado Borrado con éxito");
                    break;
                case 4:
                    List<EmpleadoDTO> empleados = objetosEmpleadosDAO.seleccionar();
                    empleados.forEach(empleado -> {
                        System.out.println("Empleado: " + empleado);
                    });
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Listado de empleados ordenados");
                    List<EmpleadoDTO> empleados2 = objetosEmpleadosDAO.ordenar();
                    empleados2.forEach(empleado -> {
                        System.out.println("Empleado: " + empleado);
                    });
                    System.out.println("");
                    break;
                case 6:
                    List<EmpleadoDTO> empleados3 = objetosEmpleadosDAO.empleadoCategoriaBase();
                    empleados3.forEach(empleado -> {
                        System.out.println("Empleado: " + empleado);
                    });
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Volver al menú principal");
                    menuBBDD();
                    break;

            }

        }
    }

    public static void categorias() throws SQLException, ParseException {

        CategoriaDAO objetosCategoriaDAO = new CategoriaDAO();

        CategoriaDTO cat1 = new CategoriaDTO(4, "Mantenimiento", 1100);
        CategoriaDTO cat2 = new CategoriaDTO();

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("*** CATEGORÍAS *** ");
            System.out.println("1.- Añadir nuevos puestos");
            System.out.println("2.- Actualizar");
            System.out.println("3.- Borrar puestos");
            System.out.println("4.- Listado de puestos de trabajo");
            System.out.println("5.- Ordenar puestos alfabéticamente");
            System.out.println("6.- Puestos con salarios superiores a 1000€");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");

            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    objetosCategoriaDAO.insertar(cat1);

                    break;
                case 2:
                    objetosCategoriaDAO.actualizar(new CategoriaDTO(4, "Mantenimientooo", 1100));
                    break;

                case 3:
                    objetosCategoriaDAO.borrar(cat1);
                    System.out.println("Empleado Borrado con éxito");
                    break;
                case 4:
                    List<CategoriaDTO> categorias = objetosCategoriaDAO.seleccionar();
                    categorias.forEach(categoria -> {
                        System.out.println("Empleado: " + categoria);
                    });
                    System.out.println("");
                    break;
                case 5:
                    List<CategoriaDTO> categoria2 = objetosCategoriaDAO.ordenar();
                    categoria2.forEach(categoria -> {
                        System.out.println("Empleado: " + categoria);
                    });
                    System.out.println("");
                    break;
                case 6:
                    List<CategoriaDTO> categoria3 = objetosCategoriaDAO.salarioSuperior();
                    categoria3.forEach(categoria -> {
                        System.out.println("Empleado: " + categoria);
                    });
                    System.out.println("");
                    break;
                case 0:
                    System.out.println("Volver al Menú de la BBDD");
                    menuBBDD();
                    break;

            }

        }
    }

    public static Proveedor proveedor() throws SQLException {
        var nombrefichero = "Cine.txt";
        IActividadCine historialProductos = new ActividadCineImpl();
        Scanner menu = new Scanner(System.in);
        Scanner lectura = new Scanner(System.in);
        Scanner sn = new Scanner(System.in);

        Proveedor proveedor = null;

        int opcion;
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("¿De qué proveedor es? ");
            System.out.println("1.- COCA COLA");
            System.out.println("2.- CONWAY");
            System.out.println("3.- MATUTANO");
            System.out.println("4.- NESTLE");
            System.out.println("0.- Salir");
            System.out.println("Seleccione una opción");
            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    return Proveedor.COCACOLA;

                case 2:
                    return Proveedor.CONWAY;
                case 3:
                    return Proveedor.MATUTANO;
                case 4:
                    return Proveedor.NESTLE;

            }

        }

    }

}
