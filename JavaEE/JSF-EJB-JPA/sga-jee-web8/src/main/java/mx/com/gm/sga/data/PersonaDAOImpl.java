
package mx.com.gm.sga.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaDAOImpl implements PersonaDAO{

    @PersistenceContext(unitName="SGAPU")
    EntityManager em;
    
    
//retornamos el query que creamos en la entidad persona, y lo convertimos en lista
    @Override
    public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

//retornamos el objeto de clase persona que tiene el id brindado 
    @Override
    public Persona finPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

//creamos un query con un parametro email, y le pedimos que este sea el campo email
//del objeto provisto (persona)
    @Override
    public Persona finPersonaByEmail(Persona persona) {
        Query query = em.createQuery("FROM Persona p where p.email =: email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

//Se actualiza el estado del objeto en la DDBB y luego se lo borra
    @Override
    public void deletePersona(Persona persona) {
        em.remove(em.merge(persona));
    }
    
}
