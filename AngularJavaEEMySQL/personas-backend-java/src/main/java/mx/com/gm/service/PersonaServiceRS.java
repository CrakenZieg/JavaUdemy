
package mx.com.gm.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;
import mx.com.gm.data.PersonaDao;
import mx.com.gm.domain.Persona;

@Stateless
@Path("/personas")//path con el que nos conectaremos a este ws
public class PersonaServiceRS {
    
//deberíamos tener una capa de servicio en el medio
    @Inject
    private PersonaDao personaDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    public List<Persona> listarPersonas(){
        List<Persona> personas = personaDao.encontrarTodasPersonas();
        System.out.println("Personas encontradas: "+personas);
        return personas;
    }
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{id}")//hace referencia al path '/personas/{id}'
    public Persona encontrarPersona(@PathParam("id") int id){
    //indicamos al ws que el parametro id es el parametro del metodo
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        System.out.println("Persona encontrada: "+persona);
        return persona;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    public Persona agregarPersona(Persona persona){
        personaDao.insertarPersona(persona);
//como usamos flush debería insertarla, actualizarla con el key y devolverla
        System.out.println("Persona agregada: "+persona);
        return persona;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaMod){
        //recuperamos la persona de la DDBB
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        //si existe la actualizamos a la que nos pasaron
        if(persona!=null){
            personaDao.actualizarPersona(personaMod);
            System.out.println("Persona modificada: "+personaMod);
            return Response.ok().entity(personaMod).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value=MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response eliminarPersona(@PathParam("id") int id){
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        personaDao.eliminarPersona(persona);
        System.out.println("Persona eliminada: "+persona);
        return Response.ok().entity(persona).build();
    }
}
