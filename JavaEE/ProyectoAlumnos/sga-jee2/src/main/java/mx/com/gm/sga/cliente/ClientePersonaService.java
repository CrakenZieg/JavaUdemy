
package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaServiceRemote;

//Recordar
//no solo tienen que ser compatibles las versiones del proyecto, tambien revisar 
//version del server en el que las queres correr..

public class ClientePersonaService {
    
    public static void main(String[] args){
        
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        
        try {
//Creamos el contexto
            Context jndi = new InitialContext();
//Creamos el objeto extraido de ese contexto y le damos el formato que tiene (PersonaServiceRemote)
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee2/PersonaServiceImpl!mx.com.gm.sga.service.PersonaServiceRemote");
//llamamos a un metodo del objeto
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona persona: personas){
                System.out.println(persona);
            }
            
            System.out.println("\nFin de la llamada al EJB desde el cliente");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
}
