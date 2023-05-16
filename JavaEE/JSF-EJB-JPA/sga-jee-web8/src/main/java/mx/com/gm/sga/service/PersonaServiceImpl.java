
package mx.com.gm.sga.service;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.gm.sga.data.PersonaDAO;
import mx.com.gm.sga.domain.Persona;

@Stateless

public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{

//Accdedemos a la capa de datos mediante la interface
    @Inject
    private PersonaDAO personaDao;
//Mediante la variable de contexto podremos hacer rollback 
    @Resource
    private SessionContext contexto;

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.finPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.finPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try{
            personaDao.updatePersona(persona);
        } catch(Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
        
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
