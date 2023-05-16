
package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PruebaApiCriteria {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Query utilizando el api de Criteria
        //1. consulta de todas las personas
        
        //paso 1: el objeto EM crea una instancia de CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //paso 2: se crea el objeto CriteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //paso 3: creamos el obj raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //paso 4: seleccionamos lo necesario del from
        criteriaQuery.select(fromPersona);//en vez de hace select p from Persona p
                
        //paso 5: creamos el query typesafe
        query = em.createQuery(criteriaQuery);
        
        //paso 6: ejecutamos la consulta
        personas = query.getResultList();
        
        //mostrarPersonas(personas);
        
        //paso 2-a: consulta de la persona con id = 3
        //en jpql era "select p from Persona p where p.idPersona = 3"
        log.debug("\n Consulta de la Persona con id = 3:");
        
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 3));
        persona = em.createQuery(criteriaQuery).getSingleResult();
        log.debug("\n" + persona);
        
        //paso 2-b: consulta de la persona con id = 3
        log.debug("\n Consulta de la Persona con id = 3:");
        
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //usamos el concepto de predicado agregando criterios de manera dinamica
        List<Predicate> criterios = new ArrayList<Predicate>();
        //verificam,os si tenemos criterios que agregar
        Integer idPersonaParam = 3;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        //se agregan los criterios
        if(criterios.isEmpty()){
            throw new RuntimeException("Sin criterios");
        } else if(criterios.size() == 1){
            criteriaQuery.where(criterios.get(0));
        } else {
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        
        //se ejecuta el query
        
        persona = query.getSingleResult();
        log.debug("\n" + persona);
        
    }
    
    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p: personas){
            log.debug(p);
        }
    }
    
}
