
package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data                   //data de lombok lo normaliza a java bean (getters, setters, constructores, etc) 
@Entity                 //entity de jpa
@Table(name = "persona")//para que aclararle (por la dudas) que la tabla se llama 'persona'
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
//validamos que nombre no puede ser vacio (a diferencia de NotNull valida que la
//no este cadena vacia)
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String apellido;
    
    @NotEmpty
    @Email
    private String email;
    
    private String telefono;
    
}
