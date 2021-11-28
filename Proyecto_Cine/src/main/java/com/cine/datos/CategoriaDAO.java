
package com.cine.datos;

import static com.cine.datos.Conexion.close;
import static com.cine.datos.Conexion.getConnection;
import com.cine.dominio.CategoriaDTO;
import com.cine.dominio.ClienteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaDAO {
    
    //VARIABLES
    private static final String SQL_SELECT = "SELECT * FROM categoria";
    private static final String SQL_INSERT = "INSERT INTO categoria (idCategoria, nombreCategoria, salario) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE categoria SET nombreCategoria = ?, salario = ?  WHERE idCategoria = ? ";
    private static final String SQL_DELETE = "DELETE FROM categoria WHERE idCategoria = ?";
    private static final String SQL_ORDER = "SELECT * FROM categoria ORDER BY nombreCategoria";
    private static final String SQL_SALARIO = "SELECT * FROM categoria WHERE salario >= 1000;";
    
  
    
    
    public List<CategoriaDTO> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CategoriaDTO> categorias = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCategoria = rs.getInt("idCategoria");
                String nombre = rs.getString("nombreCategoria");
                double salario = rs.getDouble("salario");
                
                categorias.add(new CategoriaDTO(idCategoria, nombre, salario));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return categorias;
    }
    
     public int insertar(CategoriaDTO categoria) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setInt(1,categoria.getIdCategoria());
            stmt.setString(2, categoria.getNombreCategoria());
            stmt.setDouble(3, categoria.getSalario());
           
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int actualizar(CategoriaDTO categoria) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, categoria.getNombreCategoria());
            stmt.setDouble(2, categoria.getSalario());
            stmt.setInt(3, categoria.getIdCategoria());
            

            registros = stmt.executeUpdate();
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }

    public int borrar(CategoriaDTO categoria) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            //borrar por id
            stmt.setInt(1, categoria.getIdCategoria());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            close(stmt);
            close(conn);
        }
        return registros;
    }
    
    public List<CategoriaDTO> ordenar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CategoriaDTO> categoria = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_ORDER);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCategoria = rs.getInt("idCategoria");
                String nombre = rs.getString("nombreCategoria");
                double salario = rs.getDouble("salario");
                

                categoria.add(new CategoriaDTO(idCategoria, nombre, salario));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return categoria;
    }
    
     public List<CategoriaDTO> salarioSuperior() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CategoriaDTO> categoria = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SALARIO);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCategoria = rs.getInt("idCategoria");
                String nombre = rs.getString("nombreCategoria");
                double salario = rs.getDouble("salario");
                

                categoria.add(new CategoriaDTO(idCategoria, nombre, salario));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            close(rs);
            close(stmt);
            close(conn);

        }
        return categoria;
    }
    
  
    
    
}
