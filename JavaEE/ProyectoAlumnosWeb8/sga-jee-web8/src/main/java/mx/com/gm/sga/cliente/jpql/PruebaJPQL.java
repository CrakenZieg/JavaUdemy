
package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        String jpql = null;
        Query q = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> usuarios = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SGAPU");
        EntityManager em = emf.createEntityManager();
//no creamos transaccion porque seran solo consultas
        
        //1: consulta de todos los objetos de tipo persona
        log.debug("\n1.Consulta de todas las personas: ");
        jpql = "select p from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //2: consulta de Persona con Id especifico
        log.debug("\n2.Consulta de la persona con Id = 4: ");
        jpql = "select p from Persona p where p.idPersona = 4";
        persona = (Persona) em.createQuery(jpql).getSingleResult();
        log.debug(persona);
        
        //3: consulta de objeto Persona por nombre
        log.debug("\n3.Consulta de la persona con nombre Gato: ");
        jpql = "select p from Persona p where p.nombre =  'Gato'";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //4: consulta de datos individuales, se crea un arreglo (tupla) de tipo Object de 3 columnas
        log.debug("\n4.Consulta de datos individuales, se crea un arreglo (tupla) de tipo Object de 3 columnas: ");
        jpql = "select p.nombre as Nombre, p.apellido as Apellido, p.email as Email from Persona p";
        //Usamos el iterador sobre la lista que nos devuelve la consulta 
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            String nombre = (String) tupla[0];
            String apellido = (String) tupla[1];
            String email = (String) tupla[2];
            log.debug("Nombre: " + nombre +"; Apellido: " + apellido + "; Email: " + email);
        }
        //log.debug(em.createQuery(jpql).getResultList());
        
        //5: consulta para obtener el objeto persona y el id
        log.debug("\nConsulta para obtener el objeto persona y el id: ");
        jpql = "select p, p.idPersona from Persona p ";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            persona = (Persona) tupla[0];
            int idPersona = (int) tupla[1];
            log.debug("Objeto persona de id=" + idPersona + ":\n" + persona);
        }
        
        //6: consulta de todas las personas (pero constructor solo de id)
        log.debug("\nConsulta de todas los obj Persona (pero constructor solo de id): ");
        jpql = "select new mx.com.gm.sga.domain.Persona( p.idPersona ) from Persona p";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //7: regresa el valor minimo y maximo del idPersona (scaler result)
        log.debug("\nRegresa el valor minimo y maximo del idPersona (scaler result): ");
        jpql = "select min(p.idPersona) as MinId, max(p.idPersona) as MaxId, count(p.idPersona) as Contador from Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            log.debug("Id Minimo: " + idMin + "; Id Maximo: " + idMax + "; Contador: " + count);
        }
        
        //8: cuenta los nombres de las personas que son distintos
        log.debug("\nContar los nombres de las personas que son distintos: ");
        jpql = "select count(distinct p.nombre) from Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("Numero de personas con nombre distinto: " + contador);
     
        //9: concatena y convierte a mayusculas el nombre y apellido
        log.debug("\nConcatena y convierte a mayusculas el nombre y apellido: ");
        jpql = "select CONCAT(p.nombre, ' ', p.apellido) as Nombre from Persona p";
        nombres = em.createQuery(jpql).getResultList();
        for(String nombreCompleto: nombres){
            log.debug(nombreCompleto);
        }
        
        //10: obtiene el objeto Persona con id igual al proporcionado
        log.debug("\nObtiene el objeto Persona con id igual al proporcionado: ");
        int idPersona = 1;
        jpql = "select p from Persona p where p.idPersona = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idPersona);
        persona = (Persona) q.getSingleResult();
        log.debug("La persona de id " + idPersona + " es: " + persona);
        
        //11: obtiene las personas que tiene a la letra 'a' en el nombre (sin caps)
        log.debug("\nObtiene las personas que tiene a la letra 'a' en el nombre: ");
        jpql = "select p from Persona p where upper(p.nombre) like upper(:parametro)";
        String parametro = "%a%";//%es el caracter que se utiliza para like en DDBB (uno lo ubica al medio o al final, el otro al principio o al medio)
        q = em.createQuery(jpql);
        q.setParameter("parametro", parametro);
        personas = q.getResultList();
        mostrarPersonas(personas);
        
        //12: uso de between
        log.debug("\nUso de between (3 and 7): ");
        jpql = "select p from Persona p where p.idPersona between 3 and 7";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //13: uso del ordenamiento
        log.debug("\nUso del ordenamiento: ");
        jpql = "select p from Persona p where p.idPersona > 3 order by p.nombre desc, p.apellido desc";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //14: uso de subquerys (no todas las ddbb lo tienen)
        log.debug("\nUso de subquerys (query dentro de query): ");
        jpql = "select p from Persona p where p.idPersona in (select min(p1.idPersona) from Persona p1)";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersonas(personas);
        
        //15: uso de join con lazy loading
        log.debug("\nUso de join con lazy loading: ");
        jpql = "select u from Usuario u join u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
        //16: uso de left join con eager loading
        log.debug("\nUso de left join con eager loading: ");
        jpql = "select u from Usuario u left join fetch u.persona p";
        usuarios = em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
        
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p: personas){
            log.debug(p);
        }
    }
    private static void mostrarUsuarios(List<Usuario> usuario) {
        for(Usuario u: usuario){
            log.debug(u);
        }
    }
    
}
