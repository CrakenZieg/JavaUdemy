
package mx.com.gm.sga.cliente;

import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaServiceRemote;
import org.apache.logging.log4j.*;

public class PruebaManejoTransacciones {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
    
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web2/PersonaServiceImpl!mx.com.gm.sga.service.PersonaServiceRemote");
            
            log.debug("Iniciando Prueba: Manejo transaccional PersonaService.");
            
            //Buscar objeto Persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(3));
            
            log.debug("Persona de id = 3 recuperada: " + persona1);
            
            //Cambiamos el apellido de la persona (modificamos Persona.class para que no controle el tamaño)
            persona1.setApellido("Buscando error en DDBB - Buscando error en DDBB");
            
            personaService.modificarPersona(persona1);
            log.debug("Objeto modificado: " + persona1);
            log.debug("Fin de la Prueba de EJB transaccional");
            
            
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
        
        
    }
    
}
