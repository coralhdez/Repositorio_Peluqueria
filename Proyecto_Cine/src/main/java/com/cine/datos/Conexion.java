
package com.cine.datos;

import java.sql.*;
import java.util.*;


public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cine?"
                +"useSSL=false&useTimezone=true&serverTimezone=UTC&"
                +"allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = ""; 
    
            //MÉTODO PARA ESTABLECER LA CONEXIÓN
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);   
    }
    
                //MÉTODOS CLOSE DE LA CONEXIÓN
    public static void close(ResultSet re) throws SQLException{
        re.close();
    }
    
    public static void close(Statement stmt)throws SQLException{
        stmt.close();
    }
    
    public static void close(PreparedStatement stmt)throws SQLException{
        stmt.close();
    }
    
    public static void close(Connection conn)throws SQLException{
        conn.close();
    }
    
    
    
}
