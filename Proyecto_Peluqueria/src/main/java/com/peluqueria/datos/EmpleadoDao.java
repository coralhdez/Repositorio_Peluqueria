package com.peluqueria.datos;

import static com.peluqueria.datos.Conexion.close;
import static com.peluqueria.datos.Conexion.getConnection;
import com.peluqueria.dominio.*;
import java.sql.*;
import java.util.*;

public class EmpleadoDao {

    //VARIABLES
    private static final String SQL_SELECT = "SELECT * FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado (idempleado, nombre, apellido1, apellido2, dni, telefono, categoria) VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre = ? , apellido1 = ? , apellido2 = ? , dni = ? , telefono = ? , categoria = ? WHERE idempleado = ? ";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE idempleado = ?";

    public List<Empleado> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Empleado> empleados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idempleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String categoria = rs.getString("categoria");

                empleados.add(new Empleado(idEmpleado, nombre, apellido1, apellido2, dni, telefono, categoria));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return empleados;
    }

    public int insertar(Empleado empleado) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1, empleado.getIdEmpleado());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getApellido1());
            stmt.setString(4, empleado.getApellido2());
            stmt.setString(5, empleado.getDni());
            stmt.setString(6, empleado.getTelefono());
            stmt.setString(7, empleado.getCategoria());;

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int actualizar(Empleado empleado) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getApellido1());
            stmt.setString(3, empleado.getApellido2());
            stmt.setString(4, empleado.getDni());
            stmt.setString(5, empleado.getTelefono());
            stmt.setString(6, empleado.getCategoria());
            stmt.setInt(7, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int borrar(Empleado empleado) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            //borrar por id
            stmt.setInt(1, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

}
