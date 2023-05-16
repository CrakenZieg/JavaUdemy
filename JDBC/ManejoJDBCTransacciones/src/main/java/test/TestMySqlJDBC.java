
package test;

import java.sql.*;

public class TestMySqlJDBC {
    public static void main(String[] args) {
//direccion a la que nos vamos a conectar desde el backend con la DDBB      
//despues de ? van los parametros de la coneccion
//useSSL=false (coneccion segura false)
//allowPublicKeysRetrieval=true (Allows special handshake round-trip to get an RSA public key directly from server)
        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //el siguiente paso es omitido en las ultimas versiones (pero puede ser requerido en aplicaciones web)
            //Class.forName("com.mysql.cj.jdbc.Driver");
//el objeto Connection representa la conexion con la DDBB 
//DriverManager es una clase estatica, gestiona el conjunto de controladores Java Database Connectivity (JDBC)
//parametros => .getConnection(url, usuario, clave)
            Connection conexion = DriverManager.getConnection(url,"root","admin");
//creamos una instruccion con la interface Statement, procesa una sentencia SQL estatica y obtiene sus resultados
//se crea a partir de un objeto Connection
            Statement instruccion = conexion.createStatement();
//solo hay un ResultSet para cada Statement en un momento, cada Statement cierra el actual ResultSet
//creamos una cadena con la instruccion
            var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
//ejecutamos la instruccion mediante la interface ResultSet, este objeto proporciona varios métodos
//para obtener los datos de columna correspondientes a un fila, formato get<Tipo>
            ResultSet resultado = instruccion.executeQuery(sql);
//el metodo .next() devuelve true si hay elementos a iterar, se posiciona en el registro a iterar
            while (resultado.next()){
                System.out.print("Id persona: "+resultado.getInt("id_persona"));
                System.out.print(", Nombre: "+ resultado.getString("nombre"));
                System.out.print(", Apellido: "+ resultado.getString("apellido"));
                System.out.print(", Email: "+ resultado.getString("email"));
                System.out.print(", Telefono: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
