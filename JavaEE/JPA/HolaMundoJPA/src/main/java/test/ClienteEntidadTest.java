
package test;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ClienteEntidadTest {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
//EntityManagerFactory: Interface used to interact with the entity manager factory for the persistence unit
//cierra todos los entity manager que abrio
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
//EntityManager (EM): Interface used to interact with the persistence context, este es un grupo de instancias de
//entidades de persistencia (EP) en el que por cada identidad de EP existe una unica instancia de EP
//EM maneja las instancias de EP y su ciclo de vida, las crea, remueve, encuentra por PK y las consulta (query)
        EntityManager em = emf.createEntityManager();
//EntityTransaction (ET): Interface used to control transactions on resource-local entity managers
        EntityTransaction tx = em.getTransaction();
        
        //inicia la transaccion
        tx.begin();
        //no se debe especificar el ID de la DDBB
        Persona persona1 = new Persona("Mau7","Mau7A","Mau7@mail.com","6789012345");
        log.debug("Objeto a persistir: "+ persona1);
        //persistimos el objeto en la DDBB
        em.persist(persona1);
        //terminamos la transaccion
        tx.commit();
        log.debug("Objeto persistido: "+ persona1);
        //cerramos el EM
        em.close();
    }
    
}
