package test;

import jakarta.persistence.*;
import java.util.List;
import mx.com.gm.domain.Persona;

public class HolaMUndoHibernate {
    
    public static void main(String[] args) {
    //creamos un query de hibernate
        String hql = "SELECT p FROM Persona p";
    //creamos una frabrica de manager
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("HibernateEjemplo1");
    //creamos un manager de entidades
        EntityManager entityManager = fabrica.createEntityManager();
    //creamos un query para que llame a la ddbb y le pida la lista de la tabla persona
        Query query = entityManager.createQuery(hql);
        List<Persona> personas = query.getResultList();
        
        for(Persona p: personas){
            System.out.println(p.toString());
        }
        
    }
    
}
/*
Trabajaremos con hibernate implementado con JPA por lo que debemos crear el archivo 
persistence en src / main / resources en el paquete meta-inf.
La diferencia con respecto a cuando trabajamos con jpa es que especificamos un 
provider, proveedor de la implementacion de jpa, que va a ser hibernate. Ademas 
especificamos la clase de entidad que vamos a usar y luego propiedades para 
conectarnos a la DDBB
*/
