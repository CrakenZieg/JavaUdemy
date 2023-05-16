
package personas.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import personas.dto.PersonaDTO;
import personas.jdbc.*;

public class TestPersonas {
    
    public static void main(String[] args) {
        
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
//de nuevo, usando la interface como tipo de la variable, logramos que sea lo más generica posible
            PersonaDao personaDAO = new PersonaDaoJDBC(conexion);
            
            List<PersonaDTO> personas = personaDAO.select();
            
            for (PersonaDTO persona: personas){
                System.out.println("Persona: " + persona);
            }
            
            conexion.commit();
            System.out.println("Se realizaron las transacciones");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Ocurrio un error, revirtiendo cambios");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
                System.out.println("A ocurrido un Error!");
            }
            
        }
        
    }
    
}
