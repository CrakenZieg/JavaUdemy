
package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObj {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
        EntityManager em = emf.createEntityManager();
        
        //definimos el obj
        Contacto contacto = null;
        //lo recuperamos
        //1- Transitivo
        contacto = em.find(Contacto.class, 3);
        
        //abrimos transaccion
        em.getTransaction().begin();
        //2- Eliminamos (siempre merge primero para actualizar por las dudas)
        em.remove(em.merge(contacto));
        //hacemos commit y cierra transaccion
        em.getTransaction().commit();
        
        //3- transitivo
        
        System.out.println("Contacto eliminado: "+contacto);
    }
}
