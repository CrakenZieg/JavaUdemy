
package datos;

//en el curso de JDBC

import dominio.Cliente;
import java.sql.*;
import java.util.*;


public class ClienteDaoJDBC implements ClienteDao{

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + " FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + " FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) "
            + " VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente "
            + " SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
    
    @Override
    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            conn = Conexion.getConnection();//creamos la conexion
            stmt = conn.prepareStatement(SQL_SELECT);//le asignamos la frase
            rs = stmt.executeQuery();//Enviamos frase y escuchamos la respuesta
            while(rs.next()){//con next() leemos las filas de la respuesta, mientras las haya
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");//recuperamos los atributos del cliente
                
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);//creamos el cliente con los atributos y lo sumamos a la lista
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);//cerramos el ResultSet
            Conexion.close(stmt);//cerramos el PreparedStatement
            Conexion.close(conn);//por ultimo cerramos la Connection
        }
        return clientes;//retornamos la lista
    }
    
    @Override
    public Cliente encontrar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();//creamos la conexion
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);//le asignamos la frase
            stmt.setInt(1, cliente.getIdCliente());//le asignamos el valor del id al parametro de la frase
            rs = stmt.executeQuery();//Enviamos frase y escuchamos la respuesta
            if(rs.next()){
            //si podemos pararnos en el primer registro de la respuesta (hubo respuesta)
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");//recuperamos los atributos del cliente
            
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);//seteamos los valores en el cliente que es parametro
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);//cerramos el ResultSet
            Conexion.close(stmt);//cerramos el PreparedStatement
            Conexion.close(conn);//por ultimo cerramos la Connection
        }
        return cliente;
    }
    
    @Override
    public int insertar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();//creamos la conexion
            stmt = conn.prepareStatement(SQL_INSERT);//le asignamos la frase
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());//Completamos los parametros de la frase
            
            rows = stmt.executeUpdate();//lo enviamos a la DDBB
            //devuelve la cantidad de registros modificados (tendría que ser 1)
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);//cerramos el PreparedStatement
            Conexion.close(conn);//por ultimo cerramos la Connection
        }
        return rows;
    }

    @Override
    public int actualizar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();//creamos la conexion
            stmt = conn.prepareStatement(SQL_UPDATE);//le asignamos la frase
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());//Completamos los parametros de la frase
            
            rows = stmt.executeUpdate();//lo enviamos a la DDBB
            //devuelve la cantidad de registros modificados (tendría que ser 1)
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);//cerramos el PreparedStatement
            Conexion.close(conn);//por ultimo cerramos la Connection
        }
        return rows;
    }

    @Override
    public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();//creamos la conexion
            stmt = conn.prepareStatement(SQL_DELETE);//le asignamos la frase
            stmt.setInt(1, cliente.getIdCliente());//Completamos los parametros de la frase
            
            rows = stmt.executeUpdate();//lo enviamos a la DDBB
            //devuelve la cantidad de registros modificados (tendría que ser 1)
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);//cerramos el PreparedStatement
            Conexion.close(conn);//por ultimo cerramos la Connection
        }
        return rows;
    }   
    
}
