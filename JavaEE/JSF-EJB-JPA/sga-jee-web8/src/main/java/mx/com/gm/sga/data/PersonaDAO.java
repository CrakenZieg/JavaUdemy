
package mx.com.gm.sga.data;

import java.util.List;
import mx.com.gm.sga.domain.Persona;

public interface PersonaDAO {
    
    public List<Persona> findAllPersonas();
    
    public Persona finPersonaById(Persona persona);
    
    public Persona finPersonaByEmail(Persona persona);

    public void insertPersona(Persona persona);
    
    public void updatePersona(Persona persona);
    
    public void deletePersona(Persona persona);
}
