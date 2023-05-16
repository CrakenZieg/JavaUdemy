
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.domain.Alumno;

public class ServiceAlumno {
    
    private AlumnoDAO alumnoDao = new AlumnoDAO();
    
    public List<Alumno> listarAlumnos(){
        return alumnoDao.listar();
    }
    
    public void guardarAlumno(Alumno alumno){
        
        if(alumno!=null&&alumno.getIdAlumno()==null){
    //comprobamos que el alumno es null y que tampoco se guardo en la DDBB
            alumnoDao.insertar(alumno);
        } else {
    //si alumno tiene id es que lo debemos actualizar
            alumnoDao.actualizar(alumno);
        }
    }
    
    public void eliminarAlumno(Alumno alumno){
        alumnoDao.borrar(alumno);
    }
    
    public Alumno encontrarAlumno(Alumno alumno){
        return alumnoDao.buscarAlumnoPorID(alumno);
    }
    
}
