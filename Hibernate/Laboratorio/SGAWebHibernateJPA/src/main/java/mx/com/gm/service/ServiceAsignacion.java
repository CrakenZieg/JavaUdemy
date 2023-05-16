
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.AsignacionDAO;
import mx.com.gm.domain.Asignacion;

public class ServiceAsignacion {
    
    private AsignacionDAO asignacionDao = new AsignacionDAO();
    
    public List<Asignacion> listarAsignacions(){
        return asignacionDao.listar();
    }
    
    public void guardarAsignacion(Asignacion asignacion){
        
        if(asignacion!=null&&asignacion.getIdAsignacion()==null){
    //comprobamos que el asignacion es null y que tampoco se guardo en la DDBB
            asignacionDao.insertar(asignacion);
        } else {
    //si asignacion tiene id es que lo debemos actualizar
            asignacionDao.actualizar(asignacion);
        }
    }
    
    public void eliminarAsignacion(Asignacion asignacion){
        asignacionDao.borrar(asignacion);
    }
    
    public Asignacion encontrarAsignacion(Asignacion asignacion){
        return asignacionDao.buscarAsignacionPorID(asignacion);
    }
    
}
