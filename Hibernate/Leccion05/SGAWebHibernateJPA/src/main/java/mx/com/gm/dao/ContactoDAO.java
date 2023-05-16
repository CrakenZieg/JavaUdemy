
package mx.com.gm.dao;

import mx.com.gm.domain.Contacto;
import java.util.List;
import javax.persistence.Query;
import static mx.com.gm.dao.GenericDAO.em;

public class ContactoDAO extends GenericDAO{
    
    public List<Contacto> listar(){
        String hql = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Contacto> contactos = query.getResultList();
        return contactos;
    }
    
    public void insertar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
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
    
    public void actualizar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contacto);
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
    
    public Contacto buscarContactoPorID(Contacto cId){
        em = getEntityManager();
        return em.find(Contacto.class, cId.getIdContacto());
    }
    
    public void borrar(Contacto contacto){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
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
