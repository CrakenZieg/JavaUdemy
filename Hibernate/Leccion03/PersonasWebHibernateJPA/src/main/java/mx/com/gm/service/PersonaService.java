/*
Esta clase es la que podemos usar como EJB o como clase transaccional en Spring
*/
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class PersonaService {
    
    private PersonaDAO personaDAO;
    
    public PersonaService(){
        this.personaDAO = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas(){
        return this.personaDAO.listar();
    }
    
}
