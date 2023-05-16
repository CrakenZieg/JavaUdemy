
package mx.com.gm.sga.service;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Persona;

//Use of the Local annotation is required when the bean class exposes one or more 
//local business interface and any of the following is true:
//-the bean class does not implement its business interfaces
//-the bean exposes a no-interface view
//-the bean class implements more than one interface and at least one of the interfaces 
//is explicitly designated as a business interface by using the Local or Remote 
//annotation on the interface, or in the deployment descriptor

@Local
public interface PersonaService {
        
    public List<Persona> listarPersonas();
    
    public Persona encontrarPersonaPorId(Persona persona);
    
    public Persona encontrarPersonaPorEmail(Persona persona);
    
    public void registrarPersona(Persona persona);
    
    public void modificarPersona(Persona persona);
    
    public void aliminarPersona(Persona persona);

    
}
