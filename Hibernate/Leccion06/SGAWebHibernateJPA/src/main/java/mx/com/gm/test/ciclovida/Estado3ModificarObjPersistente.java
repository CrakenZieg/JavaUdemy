
package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjPersistente {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
        EntityManager em = emf.createEntityManager();
        
        //definimos el obj
        Contacto contacto = null;
        //lo recuperamos
        //1- Transitivo
        contacto = em.find(Contacto.class, 3);
        
        //modificamos
        contacto.setEmail(contacto.getEmail()+"pelusMail");
        
        //abrimos transaccion
        em.getTransaction().begin();
        //2- Persistimos (pesist() es para crear por primera vez)
        em.merge(contacto);
        //hacemos commit y cierra transaccion
        em.getTransaction().commit();
        
        //3- Detached
        
        System.out.println("Contacto actualizado: "+contacto);
    }
}
