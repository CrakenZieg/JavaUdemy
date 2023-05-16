
package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado1Persistido {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
        EntityManager em = emf.createEntityManager();
        
        //1- Estado transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("peludo@");
        contacto.setTelefono("peludo's cel");
        
        //2- Persistimos el objeto
        em.getTransaction().begin();
        em.persist(contacto);
//em.flush() nos permitiria hacer 'commit' de lo actuado hasta el momento, por ejemplo
//para poder insertar en la ddbb el nuevo obj y luego recuperar el id asignado
        em.getTransaction().commit();
        
        //3- Deached 
//los cambios en el obj no representan cambios en la ddbb a menos que se sincronicen 
        
        System.out.println("Contacto nuevo: "+contacto);
    }
}
