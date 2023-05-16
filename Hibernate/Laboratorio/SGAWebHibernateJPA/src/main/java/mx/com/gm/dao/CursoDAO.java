
package mx.com.gm.dao;

import mx.com.gm.domain.Curso;
import java.util.List;
import javax.persistence.Query;
import static mx.com.gm.dao.GenericDAO.em;

public class CursoDAO extends GenericDAO{
    
    public List<Curso> listar(){
        String hql = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        List<Curso> cursos = query.getResultList();
        return cursos;
    }
    
    public void insertar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
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
    
    public void actualizar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
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
    
    public Curso buscarCursoPorID(Curso cId){
        em = getEntityManager();
        return em.find(Curso.class, cId.getIdCurso());
    }
    
    public void borrar(Curso curso){
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso));
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
