
package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

//con este objeto vamos a recuperar una conexion a la DDBB desde el pool configurado
//en DataSource

public class Conexion {
//creamos las ctes de la url, user y pass para la DDBB
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";
    
    private static BasicDataSource dataSource;

//creamos un metodo que devuelve un objeto DataSource para obtener una conexion a
//una fuente de datos, en este caso una DDBB, pero podría ser un archivo, la 
//ventaja del objeto DataSource frente a los DriverManager es que admite pool de 
//conexiones y transacciones distribuidas
//inicializamos la variable dataSource, en caso de ser null, la instanciamos,
//de lo contrario usamos la que ya existe, de manera de no agotaremos los recursos
//tan rápidamente (por cada obj dataSource creamos 50 conexiones)
    public static DataSource getDataSource(){
        if(dataSource == null){
        dataSource = new BasicDataSource();
        dataSource.setUrl(JDBC_URL);//cte
        dataSource.setUsername(JDBC_USER);//cte
        dataSource.setPassword(JDBC_PASSWORD);//cte
        dataSource.setInitialSize(50);//cantidad de conexiones simultaneas
        }
        return dataSource;  
    }

//del objeto DataSource obtenemos un objeto conexion.
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
//Creamos un metodo para cerrar la conexion del ResultSet (la frase devuelta por SQL)    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
//Creamos un metodo para cerrar la conexion del PreparedStatement (la frase enviada al SQL)    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

//Creamos un metodo para cerrar la conexion del objeto Connection
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
