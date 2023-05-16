package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ActualizarObjetoSesionLarga {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        
        
        //inicia la transaccion 
        
        //paso 1: inicia transaccion
        EntityTransaction tx = em.getTransaction();
       
        tx.begin();
        
//generalmente en una TX recuperamos el objeto y en otra TX lo modificamos, 
//pero podemos simplicarlos los pasos si tenemos la TX abierta
        
        //paso 2: recuperamos el objeto
        Persona persona1 = em.find(Persona.class, 3);
        
        log.debug("Objeto id=3 recuperado: " + persona1);
        
        //paso 3: cambiamos el/los valor
        persona1.setTelefono("nuevoTelefono");
        
        persona1.setApellido("nuevoApellido");
        
        //paso 4: termina la transaccion
        tx.commit();
        
        log.debug("Objeto id=3 modificado: " + persona1);
        
        //cerramos el entity manager
        em.close();
        
    }
    
}
