package com.cine.datos;

import static com.cine.datos.Conexion.close;
import static com.cine.datos.Conexion.getConnection;
import com.cine.dominio.*;
import java.sql.*;
import java.util.*;

public class ClienteDao {

    //VARIABLES
    private static final String SQL_SELECT = "SELECT * FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente (idcliente, nombre, apellido1, apellido2, dni, telefono, email, cines_idcines) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ? , apellido1 = ? , apellido2 = ? , dni = ? , telefono = ? , email = ? , cines_idcines = ? WHERE idcliente = ? ";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE idcliente = ?";
    private static final String SQL_ORDER = "SELECT * FROM cliente ORDER BY nombre";

    public List<ClienteDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteDTO> clientes = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("idcliente");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                int fk = rs.getInt("cines_idcines");
              

                clientes.add(new ClienteDTO(idCliente, nombre, apellido1, apellido2, dni, telefono, email, fk));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return clientes;
    }

    public int insertar(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1,cliente.getIdCliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getApellido1());
            stmt.setString(4, cliente.getApellido2());
            stmt.setString(5, cliente.getDni());
            stmt.setString(6, cliente.getTelefono());
            stmt.setString(7, cliente.getEmail());
            stmt.setInt(8,cliente.getCines_idcines());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int actualizar(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido1());
            stmt.setString(3, cliente.getApellido2());
            stmt.setString(4, cliente.getDni());
            stmt.setString(5, cliente.getTelefono());
            stmt.setString(6, cliente.getEmail());
            stmt.setInt(7,cliente.getCines_idcines());
            stmt.setInt(8, cliente.getIdCliente());
            

            registros = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int borrar(ClienteDTO cliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            //borrar por id
            stmt.setInt(1, cliente.getIdCliente());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public List<ClienteDTO> ordenar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ClienteDTO> clientes = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_ORDER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("idcliente");
                String nombre = rs.getString("nombre");
                String apellido1 = rs.getString("apellido1");
                String apellido2 = rs.getString("apellido2");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                int fk = rs.getInt("cines_idcines");

                clientes.add(new ClienteDTO(idCliente, nombre, apellido1, apellido2, dni, telefono, email,fk));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return clientes;
    }

}
