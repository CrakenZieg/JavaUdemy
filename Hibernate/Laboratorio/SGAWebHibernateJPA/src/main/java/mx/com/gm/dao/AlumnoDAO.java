
package mx.com.gm.dao;

import mx.com.gm.domain.Alumno;
import java.util.List;
import javax.persistence.Query;
import static mx.com.gm.dao.GenericDAO.em;

public class AlumnoDAO extends GenericDAO{
    
    public List<Alumno> listar(){
        String hql = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Alumno> alumnos = query.getResultList();
        return alumnos;
    }
    
    public void insertar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
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
    
    public void actualizar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
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
    
    public Alumno buscarAlumnoPorID(Alumno aId){
        em = getEntityManager();
        return em.find(Alumno.class, aId.getIdAlumno());
    }
    
    public void borrar(Alumno alumno){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
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
