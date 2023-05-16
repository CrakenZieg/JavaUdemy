
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Persona;



@Path("/personas")
@Stateless
public class PersonaServiceRS {
    
    @Inject
    private PersonaService personaService;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> listarPersonas() {
        return personaService.listarPersonas();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//crea la opcion de llamar a la url /personas/{id}
    public Persona encontrarPersonaPorId(@PathParam("id") int id){
        return personaService.encontrarPersonaPorId(new Persona(id));
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarPersona(Persona persona){
        try {//intenta realizar el envio, si logra retorna ok() y el objeto
            personaService.registrarPersona(persona);
            return Response.ok().entity(persona).build();
        } catch(Exception ex) {
            //si no lo logra retorna el status
            ex.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
        try{
        Persona persona = personaService.encontrarPersonaPorId(new Persona(id));
        if(persona != null){
            personaService.modificarPersona(personaModificada);
            return Response.ok().entity(personaModificada).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
        } catch(Exception ex){
            ex.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id){
        try{
            personaService.eliminarPersona(new Persona(id));
            return Response.ok().build();
        } catch(Exception ex){
            ex.printStackTrace();
            return Response.status(404).build();
        }
    }
    
}
