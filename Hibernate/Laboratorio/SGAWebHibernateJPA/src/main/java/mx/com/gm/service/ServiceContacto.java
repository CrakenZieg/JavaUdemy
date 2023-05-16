
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.ContactoDAO;
import mx.com.gm.domain.Contacto;

public class ServiceContacto {
    
    private ContactoDAO contactoDao = new ContactoDAO();
    
    public List<Contacto> listarContactos(){
        return contactoDao.listar();
    }
    
    public void guardarContacto(Contacto contacto){
        
        if(contacto!=null&&contacto.getIdContacto()==null){
    //comprobamos que el contacto es null y que tampoco se guardo en la DDBB
            contactoDao.insertar(contacto);
        } else {
    //si contacto tiene id es que lo debemos actualizar
            contactoDao.actualizar(contacto);
        }
    }
    
    public void eliminarContacto(Contacto contacto){
        contactoDao.borrar(contacto);
    }
    
    public Contacto encontrarContacto(Contacto contacto){
        return contactoDao.buscarContactoPorID(contacto);
    }
    
}
