
package mx.com.gm.test.cascade;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.*;

public class PersistenciaCascadaTest {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
        EntityManager em = emf.createEntityManager();
        
        //creamos un domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Sanata");
        domicilio.setNumCalle("1234");
        domicilio.setBarrio("javietu");
        
        //creamos un contacto
        Contacto contacto = new Contacto();
        contacto.setEmail("@mail.com");
        contacto.setTelefono("112255");
        
        //creamos el alumno
        Alumno alumno = new Alumno();
        alumno.setNombre("pepe");
        alumno.setApellido("pipo");
        
        //le asignamos lo creado previamente
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
//cuando persistamos el alumno creado veremos que primero persiste el contacto y el domicilio
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        
        System.out.println("Alumno: " + alumno);
        
    }
}
