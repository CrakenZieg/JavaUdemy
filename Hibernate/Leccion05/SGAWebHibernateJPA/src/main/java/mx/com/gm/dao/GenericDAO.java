
package mx.com.gm.dao;

import javax.persistence.*;

//creamos una clase abstracta ya que las diferentes implementaciones tendran las
//mismas caracteristicas
public abstract class GenericDAO {
    
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernateJPAPU";
    
    public GenericDAO(){
        if(emf==null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(em==null){
            em = emf.createEntityManager();
        }
        return em;
    }
    
}
