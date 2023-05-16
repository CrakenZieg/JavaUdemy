
package test;

import domain.Persona;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.client.*;
import javax.ws.rs.core.*;

public class TestPersonaServiceRS {
    
    //Variables a utilizar:
    //URL a la que hacemos las peticiones
    private static final String URL_BASE = "http://localhost:8080/sga-jee-web/webservice";
    //principal punto de entrada, usada para crear y ejecutar peticiones
    private static Client cliente;
    //objetivo de recursos identificado mediante la uri
    private static WebTarget webTarget;
    //constructor de invocaciones, estas son requests armadas y listas para ejecutarse
    private static Invocation.Builder invocationBuilder;
    //aloja la respuesta de nuestras requests
    private static Response response;
    private static Persona persona;
    private static List<Persona> personas;
    
    
    public static void main(String[] args) {
        //inicializamos el cliente
        cliente = ClientBuilder.newClient();
        
        //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/personas");
        //Proporcionamos un idPersona valido, aclaramos que recibimos un XML, que contiene un obj Persona
        persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("Persona recuperada : " + persona);
        
        //Leer todas las personas (metodo get con readEntity de tipo List<>)
        //aclaramos que recibimos un XML, que contiene un obj respuesta que vamos a procesar, 
        //deberemos leer una entidad que sera una lista de obj Persona
        personas = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Persona>>(){});
        System.out.println("\nPersonas recuperadas: ");
        imprimirPersonas(personas);
        
        //Agregar una persona (metodo POST)
        Persona nuevaPersona = new Persona();
        nuevaPersona.setNombre("Pepe");
        nuevaPersona.setApellido("Pato");
        nuevaPersona.setEmail("pute@mail.com");
        nuevaPersona.setTelefono("55555555");
        //hacemos un peticion request al obj webTarget y se lo asignamos al invocationBuilder, especificando lo que pedimos (un XML)
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        //hacemos el post que nos va a devolver una response, la guardamos en el obj response
        response = invocationBuilder.post(Entity.entity(nuevaPersona, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos la persona recien agregada para despues modificarla y al final eliminarla
        Persona personaRecuperada = response.readEntity(Persona.class);
        System.out.println("Persona recuperada = " + personaRecuperada);
        
        //Modificar persona (metodo PUT)
        //persona recuperada anteriormente
        Persona personaModificar = personaRecuperada;
        personaModificar.setApellido("Pato Tuto");
        //generamos parte del path nuevo
        String pathId = "/" + personaModificar.getIdPersona();
        //hacemos un peticion request al obj webTarget y se lo asignamos al invocationBuilder, especificando lo que pedimos (un XML)
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        //hacemos el put que nos va a devolver una response, la guardamos en el obj response
        response = invocationBuilder.put(Entity.entity(personaModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("response = " + response.getStatus());
        System.out.println("Persona modificada = " + response.readEntity(Persona.class));
        
        //Eliminar persona (metodo DELETE)
        //recuperamos la persona creada anteriormente
        Persona personaEliminar = personaRecuperada;
        String pathEliminarId = "/"+personaEliminar.getIdPersona();
        //hacemos un peticion request al obj webTarget y se lo asignamos al invocationBuilder, especificando lo que pedimos (un XML)
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        //hacemos el put que nos va a devolver una response, la guardamos en el obj response, solo indicamos que borre el id indicado
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("Response: "+ response.getStatus());
        System.out.println("Persona eliminada: "+ personaEliminar);
        
    }

    private static void imprimirPersonas(List<Persona> personas) {
        for(Persona persona: personas){
            System.out.println("Persona = " + persona);
        }
    }
    
}
