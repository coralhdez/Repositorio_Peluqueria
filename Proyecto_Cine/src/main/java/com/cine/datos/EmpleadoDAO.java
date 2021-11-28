package com.cine.datos;

import static com.cine.datos.Conexion.close;
import static com.cine.datos.Conexion.getConnection;
import com.cine.dominio.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class EmpleadoDAO {

    //VARIABLES
    private static final String SQL_SELECT = "SELECT * FROM empleado";
    private static final String SQL_INSERT = "INSERT INTO empleado (idEmpleado, nombre, apellido1, apellido2, dni, email, Categoria_idCategoria, cines_idcines) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE empleado SET nombre = ? , apellido1 = ? , apellido2 = ? , dni = ? ,  email = ?,  Categoria_idCategoria = ? , cines_idcines = ? WHERE idEmpleado = ? ";
    private static final String SQL_DELETE = "DELETE FROM empleado WHERE idEmpleado = ?";
    private static final String SQL_ORDER = "SELECT * FROM empleado ORDER BY nombre";
    private static final String SQL_INNER = "SELECT * FROM empleado INNER JOIN categoria ON empleado.Categoria_idCategoria = categoria.idCategoria WHERE  categoria.idCategoria = 3;";

    public List<EmpleadoDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> empelados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int fk = rs.getInt("Categoria_idCategoria");
                int fk2 = rs.getInt("cines_idcines");
                

                empelados.add(new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, fk, fk2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return empelados;
    }

    public int insertar(EmpleadoDTO empleado) throws SQLException {

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
            stmt.setString(6, empleado.getEmail());
            stmt.setInt(7, empleado.getFk());
            stmt.setInt(8, empleado.getCines_idcines());
            
            

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int actualizar(EmpleadoDTO empleado) throws SQLException {

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
            stmt.setString(5, empleado.getEmail());
            stmt.setInt(6, empleado.getFk());
            stmt.setInt(7, empleado.getCines_idcines());
            stmt.setInt(8, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int borrar(EmpleadoDTO empleado) throws SQLException {
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

    public List<EmpleadoDTO> ordenar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> empleados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_ORDER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int fk = rs.getInt("Categoria_idCategoria");
                int fk2 = rs.getInt("cines_idcines");

                empleados.add(new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, fk, fk2));
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
    
    public List<EmpleadoDTO> empleadoCategoriaBase() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<EmpleadoDTO> empleados = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INNER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmpleado = rs.getInt("idEmpleado");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String email = rs.getString("email");
                int fk = rs.getInt("Categoria_idCategoria");
                int fk2 = rs.getInt("cines_idcines");

                empleados.add(new EmpleadoDTO(idEmpleado, nombre, apellido1, apellido2, dni, email, fk, fk2));
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

}
