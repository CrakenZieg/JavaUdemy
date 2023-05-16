
package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjPersistente {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
        EntityManager em = emf.createEntityManager();
        
//Para recuperar un obj de ddbb no es necesario crear una nueva transaccion
//si lo recuperamos en el contexto de una transaccion y luego hacemos commit()
//el objeto persiste

        //definimos el obj
        Contacto contacto = null;
        //lo recuperamos
        contacto = em.find(Contacto.class, 3);
        
        System.out.println("Contacto: "+contacto);

    }
}
