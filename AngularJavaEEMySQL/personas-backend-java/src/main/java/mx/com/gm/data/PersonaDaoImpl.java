
package mx.com.gm.data;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;

//lo convierte en un EJB
@Stateless
public class PersonaDaoImpl implements PersonaDao{

    @PersistenceContext(unitName="PersonaPU")
    EntityManager em;
    
    @Override
    public List<Persona> encontrarTodasPersonas() {
        return em.createNamedQuery("Persona.EncontrarTodasPersonas").getResultList();
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
        em.flush();//para que me duvuelva la primary key que le asigno en DDBB
    }

    @Override
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        em.remove(em.merge(persona));//borramos(sincronizamos)
    }
    
}
