
package mx.com.gm.sga.service;

import java.util.List;
import javax.ejb.Remote;
import mx.com.gm.sga.domain.Persona;
//The Remote interface serves to identify interfaces whose methods may be invoked 
//from a non-local virtual machine. Any object that is a remote object must directly 
//or indirectly implement this interface. 
//Puede ser necesario que se incluya remote cuando se hacen llamados desde diferentes 
//aplicaciones dentro de la misma maquina virtual
@Remote
public interface PersonaServiceRemote {
    
    public List<Persona> listarPersonas();
    
    public Persona encontrarPersonaPorId(Persona persona);
    
    public Persona encontrarPersonaPorEmail(Persona persona);
    
    public void registrarPersona(Persona persona);
    
    public void modificarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
}
