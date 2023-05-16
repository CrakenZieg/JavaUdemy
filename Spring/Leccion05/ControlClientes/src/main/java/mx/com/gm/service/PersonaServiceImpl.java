
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.com.gm.dao.PersonaDao;
import org.springframework.transaction.annotation.Transactional;

//Spring reconoce esta clase a partir de la anotacion (tambien extiende component)
@Service
public class PersonaServiceImpl implements PersonaService{

//Como esta clase de servicio podria manejar mas de un obj DAO y ya de por si debe 
//entablar relaciones con la DDBB debe necesariamente tener en cuenta que puede
//haber situaciones de commit o de rollback, es decir, debe ser transaccional
//Por eso lo metodos que tengan que hacer contacto con la DDBB deberan estar anotados 
//como 'transactional'
    
    @Autowired //similar a injected 
    private PersonaDao personaDao;
    
    @Override
    @Transactional(readOnly=true)//aclaramos que solo lee, no abre transaccion
    public List<Persona> listarPersonas() {
    //Hay que castear el retorno de findAll porque es tipo Object
        return (List<Persona>)personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly=true)//aclaramos que solo lee, no abre transaccion
    public Persona encontrarPersona(Persona persona) {
//devuelve un objeto tipo Optional<Persona>, tiene metodos para throwear exceptions o, 
//como en este caso, devolver null si el obj que buscamos no esta
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
