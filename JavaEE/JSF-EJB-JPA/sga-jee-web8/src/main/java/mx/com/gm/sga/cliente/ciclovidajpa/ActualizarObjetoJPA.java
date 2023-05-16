package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ActualizarObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        
        
        //inicia la transaccion 
        
        //paso 1: inicia transaccion
        EntityTransaction tx = em.getTransaction();
       
        tx.begin();
        
        //paso 2: Ejecutamos un SQL de tipo select
        //el id debe existir
        Persona persona1 = em.find(Persona.class, 2);
//class son las declaradas en persistence.xml. son clases de entidad
        
        //paso 3: termina la transaccion:
        tx.commit();
//recuperamos el objeto, queda en estado detached
        
        log.debug("Objeto id=2 recuperado, su email es: " + persona1.getEmail());
        
        //paso 4: cambiamos el email
        persona1.setEmail("nuevoMail@mail.com");
        
        //paso 5: creamos una nueva transaccion 
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        //paso 6: modificamos el objeto
        em.merge(persona1);
                
        //paso 7: terminamos la transaccion
        tx2.commit();
//podriamos hacer el cambio sin terminar la transaccion sin terminarla utilizando em.flush(),
//que realiza todas las secuencias pendientes
        
        log.debug("Objeto id=2 modificado, su email ahora es: " + persona1.getEmail());

        //cerramos el entity manager
        em.close();
        
    }
    
}
