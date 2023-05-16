package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class EncontrarObjetoJPA {
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
//class son las declaradas en persistence.xml. son clases de entidad
        
        //paso 3: termina la transaccion:
        tx.commit();
        
        log.debug("Objeto id=2 recuperado: " + persona1);
        
        //cerramos el entity manager
        em.close();
        
    }
    
}
