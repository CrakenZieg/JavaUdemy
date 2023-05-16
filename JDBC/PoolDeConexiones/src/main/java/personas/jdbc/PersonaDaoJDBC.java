
package personas.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import personas.dto.PersonaDTO;
import static personas.jdbc.Conexion.*;

public class PersonaDaoJDBC implements PersonaDao{
    
    private Connection userConn;
    private static final String SQL_INSERT = "INSERT INT personas(nombre, apellido) VALUES( ?, ?)";
    private static final String SQL_UPDATE = "UPDATE personas SET nombre = ?, apellido = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM personas WHERE id_persona = ?";
    private static final String SQL_SELECT = "SELECT id_personas, nombre, apellido FROM personas";
    
    public PersonaDaoJDBC(){};
    
    public PersonaDaoJDBC(Connection conn) throws SQLException{
        this.userConn = Conexion.getConnection();
    }

    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.userConn != null ? this.userConn : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            registros = stmt.executeUpdate();
            
        } finally {
            try {
                close(stmt);
                if(this.userConn == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return registros;
                
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.userConn != null ? this.userConn : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getIdPersona());
            registros = stmt.executeUpdate();
            
        } finally {
            try {
                close(stmt);
                if(this.userConn == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return registros;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = this.userConn != null ? this.userConn : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());
            registros = stmt.executeUpdate();
            
        } finally {
            try {
                close(stmt);
                if(this.userConn == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return registros;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet result = null;
        List<PersonaDTO> personas1 = new ArrayList<>();
        
        try {
            conn = this.userConn != null ? this.userConn : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            result = stmt.executeQuery();
            while(result.next()){
                int idPersona = result.getInt("id_personas");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");     
                PersonaDTO persona = new PersonaDTO(idPersona, nombre, apellido);
                personas1.add(persona);
            }
        } finally {
            try {
                close(result);
                close(stmt);
                if(this.userConn == null){
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);            
            }
        }
        return personas1;
    }
}
