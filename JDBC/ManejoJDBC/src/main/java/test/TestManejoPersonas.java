package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        
        //Persona persona1 = new Persona("Carlos", "Roberto", "bondiola@salame.com", "345678");
        //personaDao.insertar(persona1);
        
        //Persona persona2 = new Persona(4,"Juan Carlos","Roberto","bondiola@salame.com","345678");
        //personaDao.actualizar(persona2);
        
        Persona persona3 = new Persona("Juan Carlos","Roberto","bondiola@salame.com","345678");
        personaDao.insertar(persona3);
        
        List<Persona> personas = personaDao.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
        
        persona3 = new Persona(5,"Juan Carlos","Roberto","bondiola@salame.com","345678");
        personaDao.eliminar(persona3);
        
        personas = personaDao.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });

    }

}
