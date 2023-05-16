
package mx.com.gm.dao;

import javax.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;

public class PersonaDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("HibernatePU");
        em = emf.createEntityManager();
    }
    
    public List<Persona> listar(){
        String hql = "SELECT p FROM Persona p";
        Query query = em.createQuery(hql);
        List<Persona> personas = query.getResultList();
//        for(Persona p: personas){
//            System.out.println(p.toString());
//        }
        return personas;
    }
//si usamos un servidor para desplegar una aplicacion empresarial, es este el que
//crea y cierra las transacciones, de no usar servidor, debemos nosotros abrir y 
//cerrar las transacciones
    public void insertar(Persona persona){
        try {
            em.getTransaction().begin();
            em.persist(persona);//guarda
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if(em!=null){
//                em.close();
//            }
//        }
    }
    
    public void modificar(Persona persona){
        try {
            em.getTransaction().begin();
            em.merge(persona);//en base a la id_persona
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if(em!=null){
//                em.close();
//            }
//        }
    }
    
    public Persona buscarPersonaPorID(Persona pId){
        return em.find(Persona.class, pId.getIdPersona());
    }
    
    public void borrar(Persona persona){
        try {
            em.getTransaction().begin();
            em.remove(em.merge(persona));//sincronizamos con la DDBB y luego borramos el registro
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
//        finally {
//            if(em!=null){
//                em.close();
//            }
//        }
    }
    
    
}
