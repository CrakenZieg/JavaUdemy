
package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.CursoDAO;
import mx.com.gm.domain.Curso;

public class ServiceCurso {
    
    private CursoDAO cursoDao = new CursoDAO();
    
    public List<Curso> listarCursos(){
        return cursoDao.listar();
    }
    
    public void guardarCurso(Curso curso){
        
        if(curso!=null&&curso.getIdCurso()==null){
    //comprobamos que el curso es null y que tampoco se guardo en la DDBB
            cursoDao.insertar(curso);
        } else {
    //si curso tiene id es que lo debemos actualizar
            cursoDao.actualizar(curso);
        }
    }
    
    public void eliminarCurso(Curso curso){
        cursoDao.borrar(curso);
    }
    
    public Curso encontrarCurso(Curso curso){
        return cursoDao.buscarCursoPorID(curso);
    }
    
}
