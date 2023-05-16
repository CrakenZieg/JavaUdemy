
package mx.com.gm.domain;

import lombok.Data;

@Data
public class Persona {
//Lombok nos permite, usando la anotacion data, incluir de manera automatica los 
//metodos getters, setters, hashCode e equals, es decir, te lo 'normaliza' al estadar
//de un java bean
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
