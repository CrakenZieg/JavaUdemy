
package testClienteWS;

import ClienteEMS.servicio.Persona;
import ClienteEMS.servicio.PersonaServiceImplService;
import ClienteEMS.servicio.PersonaServiceWs;
import java.util.List;

public class TestPersonaServiceWS {
 
    public static void main(String[] args) {
        
        PersonaServiceWs personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
        
        System.out.println("Ejecutando servicio listar personas ws");
        
        List<Persona> personas = personaService.listarPersonas();
        
        for(Persona persona: personas){
            System.out.println("Persona: " + persona);
        }
        
        System.out.println("Fin del servicio listar personas ws");
        
    }
    
}
