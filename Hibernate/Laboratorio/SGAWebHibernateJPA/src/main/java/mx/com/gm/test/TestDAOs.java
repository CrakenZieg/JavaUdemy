
package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.*;

public class TestDAOs {
 
    public static void main(String[] args) {
        
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("Alumnos: ");
        imprimir(alumnoDao.listar());
        
        DomicilioDAO domicilioDao = new DomicilioDAO();
        System.out.println("Domicilios: ");
        imprimir(domicilioDao.listar());
        
        ContactoDAO contactoDao = new ContactoDAO();
        System.out.println("Contactos: ");
        imprimir(contactoDao.listar());
        
        AsignacionDAO asignacionDao = new AsignacionDAO();
        System.out.println("Asignaciones: ");
        imprimir(asignacionDao.listar());
        
        CursoDAO cursoDao = new CursoDAO();
        System.out.println("Cursos: ");
        imprimir(cursoDao.listar());
        
    }
    
    private static void imprimir(List colecion){
        for(Object o: colecion){
            System.out.println("valor = "+o);
        }
    }
 
}
