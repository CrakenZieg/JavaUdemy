
package mx.com.gm.dao;

import mx.com.gm.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Utilizamos la clase jpaRepository, supuestamente tiene mejoras con respecto a la CRUD
@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
//escribimos este metodo para poder usar la seguridad de spring
    Usuario findByUsername(String username);
    
}
