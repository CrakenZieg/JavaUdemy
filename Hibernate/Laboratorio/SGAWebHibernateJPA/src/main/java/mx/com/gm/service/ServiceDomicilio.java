
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.DomicilioDAO;
import mx.com.gm.domain.Domicilio;

public class ServiceDomicilio {
    
    private DomicilioDAO domicilioDao = new DomicilioDAO();
    
    public List<Domicilio> listarDomicilios(){
        return domicilioDao.listar();
    }
    
    public void guardarDomicilio(Domicilio domicilio){
        
        if(domicilio!=null&&domicilio.getIdDomicilio()==null){
    //comprobamos que el domicilio es null y que tampoco se guardo en la DDBB
            domicilioDao.insertar(domicilio);
        } else {
    //si domicilio tiene id es que lo debemos actualizar
            domicilioDao.actualizar(domicilio);
        }
    }
    
    public void eliminarDomicilio(Domicilio domicilio){
        domicilioDao.borrar(domicilio);
    }
    
    public Domicilio encontrarDomicilio(Domicilio domicilio){
        return domicilioDao.buscarDomicilioPorID(domicilio);
    }
    
}
