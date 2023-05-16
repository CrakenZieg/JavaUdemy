
package personas.jdbc;

import java.sql.*;

public class Conexion {
    
    private static final String JDBC_STRING = null; 
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
    }    
    
    public static void close(ResultSet result) throws SQLException{
        result.close();
    }
        
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
        
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
