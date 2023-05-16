
package personas.jdbc;

import java.sql.SQLException;
import java.util.List;
import personas.dto.PersonaDTO;

public interface PersonaDao {
    
    public abstract int insert(PersonaDTO persona)throws SQLException;
    
    public abstract int update(PersonaDTO persona)throws SQLException;
    
    public abstract int delete(PersonaDTO persona)throws SQLException;
    
    public abstract List<PersonaDTO> select()throws SQLException;
    
}
