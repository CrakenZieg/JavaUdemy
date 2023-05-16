
package datos;

import dominio.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface ClienteDao {
    
    public abstract List<Cliente> listar()throws SQLException;
    
    public abstract Cliente encontrar(Cliente cliente)throws SQLException;
    
    public abstract int insertar(Cliente cliente)throws SQLException;
    
    public abstract int actualizar(Cliente cliente)throws SQLException;
    
    public abstract int eliminar(Cliente cliente)throws SQLException;
    
    
}
