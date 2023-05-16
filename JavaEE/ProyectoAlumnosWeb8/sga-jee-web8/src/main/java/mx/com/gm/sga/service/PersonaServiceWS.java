
package mx.com.gm.sga.service;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import mx.com.gm.sga.domain.Persona;

@WebService
public interface PersonaServiceWS {
    
    @WebMethod
    public List<Persona> listarPersonas();
//al anotarla con webmethod dentro de una clase webservice, y luego implementadola
//podemos exponer el metodo dentro de nuestros servicios web, pero para lograrlo 
//debemos también poder convertir esta clase a XML
    
}
