
package mx.com.gm.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PersistenciaCascadaJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //paso 1: abrimos transaccion
        tx.begin();
        
        //Paso 2: creamos objetos (estado transitivo)
        Persona persona1 = new Persona("Gato", "maula", "misero@mail.com", "99999999");
        Usuario usuario1 = new Usuario("GMaula", "tuvieja", persona1);
        
        //paso 3: persistimos el obj usuario (y como activamos persistencia en cascada persiste obj persona)
        em.persist(usuario1);
        
        //paso 4: commit de la transaccion
        tx.commit();
        
        //obj en estado detached
        log.debug("Objeto Persona persistido: " + persona1);
        log.debug("Objeto Usuario persistido: " + usuario1);
        
        //paso 5: cerramos la transaccion
        em.close();
    }
}
