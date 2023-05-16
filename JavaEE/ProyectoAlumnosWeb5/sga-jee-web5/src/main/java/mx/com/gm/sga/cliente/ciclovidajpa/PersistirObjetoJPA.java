package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //inicia la transaccion 
        
        //paso 1: crea nuevo objeto
        //obj en estado transitivo
        Persona persona1 = new Persona("Perco", "Latte", "pertte@mail.com", "112233");
        
        //paso 2: inicia transaccion 
        tx.begin();
        
        //paso 3: ejecutamos SQL
        em.persist(persona1);
        
        log.debug("Objeto persistido (aun sin commit) --> " + persona1);

        //paso 4: commito o rollback
        tx.commit();
        //obj detached
        log.debug("Objeto persistido (estado detached) --> " + persona1);
        
        //paso 5: cerramos EM
        em.close();
        
    }
    
}
