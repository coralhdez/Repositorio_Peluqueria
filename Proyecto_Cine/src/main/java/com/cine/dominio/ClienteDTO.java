package com.cine.dominio;

public class ClienteDTO {

    private int idCliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String telefono;
    private String email;
    int cines_idcines;

    private static int contadorClientes = 0;

    public ClienteDTO() {
        this.idCliente = ClienteDTO.contadorClientes++;
    }

    public ClienteDTO(int idCliente, String nombre, String apellido, String apellido2, String dni, String telefono, String email) {
        this();
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido1 = apellido;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }

    public ClienteDTO(int idCliente, String nombre, String apellido1, String apellido2, String dni, String telefono, String email, int cines_idcines) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.cines_idcines = cines_idcines;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido) {
        this.apellido1 = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCines_idcines() {
        return cines_idcines;
    }

    public void setCines_idcines(int cines_idcines) {
        this.cines_idcines = cines_idcines;
    }

    public static int getContadorClientes() {
        return contadorClientes;
    }

    public static void setContadorClientes(int contadorClientes) {
        ClienteDTO.contadorClientes = contadorClientes;
    }

    @Override
    public String toString() {
        return "ID Cliente: " + idCliente + ", Nombre: " + nombre + ", Apellido 1: " + apellido1 + ", Apellido 2: " + apellido2 + ", DNI: " + dni + ", Teléfono: " + telefono + ", Email: " + email + ", Identificación cine: " + cines_idcines;
    }

   
}
