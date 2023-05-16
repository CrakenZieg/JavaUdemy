
package mx.com.gm.dao;

import mx.com.gm.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Vamos a crear una clase de repositorio para que conecte con la ddbb, antes se 
//utilizaba la anotacion repository sobre la clase que la implementaba
//de esta nueva manera, extendiendo esta interface todas las clases dao que queramos crear
//van a poder implementar esta interface
@Repository
public interface PersonaDao extends JpaRepository<Persona, Long> {
    //los parametros son la clase y el tipo (obj) del id
    //Spring crea automaticamente una implementacion de esta clase como la hubieramos 
    //creado manualmente con los metodos clasicos, ademas podemos incluir metodos a medida
}
