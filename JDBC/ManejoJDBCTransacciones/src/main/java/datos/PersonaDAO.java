
package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO {
    
    private Connection coexionTransaccional;
//clase de de acceso a datos de la clase persona, sigue el modelo Data Access Object
//uno por cada clase
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
//es conveniente probar las sentencias fuera de JAVA para ver que estén bien escritas
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
//creamos la instruccion con 4 parametros que se corresponden  con los VALUES que le vamos a dar
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
    
    public PersonaDAO(){}
    
    public PersonaDAO(Connection conexionTransaccional){
        this.coexionTransaccional = conexionTransaccional;
    }
    
    public List<Persona> seleccionar() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Persona> personas = new ArrayList<>();
        
        try {
            //conn = getConnection();            //creo conexion
            conn = this.coexionTransaccional != null ? this.coexionTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);   //creo statement
            rs = stmt.executeQuery();                   //lo "escucho"
            while (rs.next()){                          
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                Persona persona = new Persona(idPersona,nombre,apellido,email,telefono);
                personas.add(persona);
            }
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                if (this.coexionTransaccional == null){
                    close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return personas;
    }
    
    public int insertar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.coexionTransaccional != null ? this.coexionTransaccional : getConnection();;
            stmt = conn.prepareStatement(SQL_INSERT);
//hasta acá igual que antes, creamos la conexion, creamos el Statement, 
//pero ahora lo completamos con los datos de Persona
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
//ahora le damos informacion a la DDBB, por eso usamos .executeUpdate()
//Este metodo puede hacer INSERT, UPDATE o DELETE
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.coexionTransaccional == null){
                    close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }    
        }
        return registros;
    }
    
    public int actualizar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.coexionTransaccional != null ? this.coexionTransaccional : getConnection();;
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.coexionTransaccional == null){
                    close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }    
        }
        return registros;
    }
    
    public int eliminar(Persona persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.coexionTransaccional != null ? this.coexionTransaccional : getConnection();;
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.coexionTransaccional == null){
                    close(conn);}
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }    
        }
        return registros;
    }
    
}
