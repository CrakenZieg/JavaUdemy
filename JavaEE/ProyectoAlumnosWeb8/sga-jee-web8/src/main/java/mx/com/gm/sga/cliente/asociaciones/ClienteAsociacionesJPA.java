
package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClienteAsociacionesJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        em.close();
        
//es posible relacionar entidades al igual que se relacionan campos de tablas, en este caso
//varios usuarios pueden pertenecer a una misma persona, es decir, entre usuarios y personas
//hay una relacion ManyToOne. Es posible relacionar mediante ManyToMany pero no es para nada 
//recomendado, generalmente se pueden crear intermediarios para "normalizar" la relacion a 
//ManyToOne
//al relacionar las 2 entidades, si la relacion es 'lazy' espera a que se llame el campo para pedir
//el dato, si es 'eager', cuando se pide el dato se piden a su vez los relacionados,
//esto ultimo genera mas carga en la DDBB, 'lazy' es la posicion por default, se cambia incluyendo
//fetch = FetchType.EAGER como atributo de la anotacion relacional

//También se pueden relacionar las entidades en cuanto a persistencia, es decir, si creo 
//un obj persona, luego creo 2 obj usuario y se los asocio, bastaria con persistir la persona
//para que guarde tambien los 2 usuarios asociados, esto se logra agregando cascade = CascadeType.ALL
//como atributo de la anotacion relacional
        
        for (Persona persona : personas){
            log.debug("Persona " + persona.getIdPersona() + ": " + persona);
            for (Usuario usuario : persona.getUsuarioList()){
                log.debug("Usuario " + usuario.getIdUsuario() + ": " + usuario);
            }
        }
        
    }
    
}
