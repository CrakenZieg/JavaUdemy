
package datos;

import java.sql.*;

public class Conexion {
//3 capas: capa presentacion, debajo negocio, debajo datos 
//codigo reutilizable en diferentes proyectos
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    } 

    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
//generalmente vamos a trabajar con la interface PreparedStatement, tiene mejor performance
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
    
}
