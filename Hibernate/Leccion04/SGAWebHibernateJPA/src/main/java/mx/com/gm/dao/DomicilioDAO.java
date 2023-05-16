
package mx.com.gm.dao;

import mx.com.gm.domain.Domicilio;
import java.util.List;
import javax.persistence.Query;
import static mx.com.gm.dao.GenericDAO.em;

public class DomicilioDAO extends GenericDAO{
    
    public List<Domicilio> listar(){
        String hql = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Domicilio> domicilios = query.getResultList();
        return domicilios;
    }
    
    public void insertar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if(em!=null){
                em.close();
            }
        }
    }
    
    public void actualizar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if(em!=null){
                em.close();
            }
        }
    }
    
    public Domicilio buscarDomicilioPorID(Domicilio dId){
        em = getEntityManager();
        return em.find(Domicilio.class, dId.getIdDomicilio());
    }
    
    public void borrar(Domicilio domicilio){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
        } finally {
            if(em!=null){
                em.close();
            }
        }
    }
    
}
