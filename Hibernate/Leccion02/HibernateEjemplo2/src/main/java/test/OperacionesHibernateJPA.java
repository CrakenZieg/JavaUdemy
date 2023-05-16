
package test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernateJPA {
    
    public static void main(String[] args) {
        
        PersonaDAO personaDAO = new PersonaDAO();
        
        personaDAO.listar();
        System.out.println("---------------------------------");
        System.out.println("Insertando a Carlos!");
        Persona persona1 = new Persona();
        persona1.setNombre("Carlos");
        persona1.setApellido("Laranja");
        persona1.setEmail("Carlos@tuvieja.com");
        persona1.setTelefono("12341234");
        personaDAO.insertar(persona1);
        System.out.println("---------------------------------");
        personaDAO.listar();
        System.out.println("---------------------------------");
        System.out.println("Modificando el Mail de Carlos!");
        persona1.setIdPersona(10);
        persona1 = personaDAO.buscarPersonaPorID(persona1);
        System.out.println("Buscamos a Carlos: "+ persona1.toString());
        System.out.println("Setteamos el nuevo mail!");
        persona1.setEmail("Carlos@tuviejaNuevo.com");
        personaDAO.modificar(persona1);
        System.out.println("---------------------------------");
        personaDAO.listar();
        System.out.println("---------------------------------");
        System.out.println("Eliminamos a Carlos!");
        personaDAO.borrar(persona1);
        System.out.println("---------------------------------");
        personaDAO.listar();

        
    }
    
}
