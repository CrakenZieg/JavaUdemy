package test;

import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {
        
        Connection conexion = null;
                
        try {
            conexion = Conexion.getConnection();
//por default los cambios que se realizan a traves de una Connection son commiteados automaticamente
//en la DDBB, para evitar errores, se puede desactivar esa opcion, de manera que si tenemos un conjunto
//de instucciones para la DDBB (transaccion) podamos asegurarnos que afecte a la DDBB solo si se 
//realizaron todas las instrucciones sin error
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);            
            }
            
            PersonaDAO personaJdbc = new PersonaDAO(conexion);
            
            Persona cambioPersona = new Persona();
            cambioPersona.setIdPersona(2);
            cambioPersona.setNombre("Corla");
            cambioPersona.setApellido("Lara");
            cambioPersona.setEmail("mortadela@salame.com");
            cambioPersona.setTelefono("234567");
            personaJdbc.actualizar(cambioPersona);
            
            Persona borrarPersona = new Persona(6);
            personaJdbc.eliminar(borrarPersona );
                    
            Persona nuevaPersona = new Persona("Rigo","Berto","pastron@salame.com","789123");
            personaJdbc.insertar(nuevaPersona);
            
            conexion.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
                

    }

}

            /*PersonaDAO personaDao = new PersonaDAO();
            
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
            });*/