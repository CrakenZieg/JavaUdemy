
package personas.jdbc;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    
    private static final String JDBC_STRING = null; 
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
//<dependency><groupId>org.apache.commons</groupId><artifactId>commons-dbcp2</artifactId><version>2.9.0</version></dependency>
//nos da un pool de conexiones, este las administra de manera más eficiente
    public static DataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        ds.setInitialSize(5);//establecemos 5 conexiones maximas
        return ds;
    }
    
    public static Connection getConnection() throws SQLException{
        
        return getDataSource().getConnection();
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
