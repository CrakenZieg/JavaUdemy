
package testClienteWS;

import ClienteEMS.servicio.Persona;
import ClienteEMS.servicio.PersonaServiceImplService;
import ClienteEMS.servicio.PersonaServiceWs;
import java.util.List;
import javax.xml.ws.BindingProvider;

public class TestPersonaServiceWS {
 
    public static void main(String[] args) {
        
        PersonaServiceWs personaService = new PersonaServiceImplService().getPersonaServiceImplPort();
//casteamos personaService al obj binding provider para pedir el contexto y agregarle usuario y contraseña
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)personaService).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");
        
        System.out.println("Ejecutando servicio listar personas ws");
        
        List<Persona> personas = personaService.listarPersonas();
        
        for(Persona persona: personas){
            System.out.println("Persona: " + persona);
        }
        
        System.out.println("Fin del servicio listar personas ws");
        
    }
    
}
