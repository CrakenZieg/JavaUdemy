
package mx.com.gm.dao;

import mx.com.gm.domain.Asignacion;
import java.util.List;
import javax.persistence.Query;
import static mx.com.gm.dao.GenericDAO.em;

public class AsignacionDAO extends GenericDAO{
        
    public List<Asignacion> listar(){
        String hql = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Asignacion> asignaciones = query.getResultList();
        return asignaciones;
    }
    
    public void insertar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if(em!=null){
//                em.close();
//            }
        }
    }
    
    public void actualizar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if(em!=null){
//                em.close();
//            }
        }
    }
    
    public Asignacion buscarAsignacionPorID(Asignacion aId){
        em = getEntityManager();
        return em.find(Asignacion.class, aId.getIdAsignacion());
    }
    
    public void borrar(Asignacion asignacion){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
            em.getTransaction().rollback();
//        } finally {
//            if(em!=null){
//                em.close();
//            }
        }
    }
    
}
