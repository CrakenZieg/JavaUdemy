package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class EliminarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        
        
        //inicia la transaccion 
        
        //paso 1: inicia transaccion
        EntityTransaction tx = em.getTransaction();
       
        tx.begin();
        
        //paso 2: Ejecutamos un SQL de tipo select
        Persona persona1 = em.find(Persona.class, 2);
        //en una sola transaccion seria:
        //recuperas el objeto con find
        //lo eliminas con remove
        //em.remove(persona1);
        //haces commit y cerras la transaccion
        //tx.commit();
        //cerras el EM
        
        //paso 3: termina la transaccion:
        tx.commit();
//recuperamos el objeto, queda en estado detached
        
        log.debug("Objeto id=2 recuperado: " + persona1);
        
        //paso 4: creamos una nueva transaccion 
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //paso 5: borramos el objeto
        em.remove(em.merge(persona1));
    //primero sincronizamos el obj con la DDBB y luego lo borramos
                
        //paso 6: terminamos la transaccion (se borra en DDBB)
        tx2.commit();

//el objeto todavía existe en forma detached
        
        log.debug("Objeto id=2 eliminado: " + persona1);

        //cerramos el entity manager
        em.close();
        
    }
    
}
