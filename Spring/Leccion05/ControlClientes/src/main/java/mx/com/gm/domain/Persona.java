
package mx.com.gm.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data                   //data de lombok lo normaliza a java bean
@Entity                 //entity de jpa
@Table(name = "persona")//para que aclararle (por la dudas) que la tabla se llama 'persona'
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    
}
