
package test;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaServiceRemote;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente");
    //ingresamos el archivo de configuracion que esta en la carpeta raiz
        String authFile = "login.conf";
    //indicamos que usamos la seguridad y luego el archivo
        System.setProperty("java.security.auth.login.config", authFile);
    //nos vamos a loggear programaticamente
        ProgrammaticLogin programmaticLogin = new ProgrammaticLogin();
    //con el metodo login le damos como atributos el usuario y la contrasena, 
    //pero a esta ultima debemos convertirla en caracteres porque lo solicita el api
        programmaticLogin.login("admin", "admin".toCharArray());
        
        try {
            //iniciamos el contexto del jndi para ubicar el EJB
            Context jndi = new InitialContext();
            //usamos la interface para crear el objeto que vamos a pedir al servidor (la implementacion de la interface)
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
                                                                                   
            List<Persona> personas = personaService.listarPersonas();
            
            for(Persona persona: personas){
                System.out.println("Persona: " + persona);
            }
            System.out.println("\nFin de la llamada al EJB desde el cliente");
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
