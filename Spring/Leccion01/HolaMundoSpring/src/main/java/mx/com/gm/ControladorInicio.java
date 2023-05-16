
package mx.com.gm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring reconoce esta clase por la anotacion
//RestController está anotada como Controller a su vez anotada como Component 
//lo que la hace plausible de introducir en el contenedor de Spring
@RestController 
//Lombok es un logger, nos permite enviar mensajes a consola entre otras cosas
@Slf4j
public class ControladorInicio {

//la anotacion especifica que responde a un GET al llamar a, en este caso, LocalHost:8080'/'
    @GetMapping("/")
    public String inicio(){
        log.info("Ejecutando el controlador REST");
        return "Hola Mundo con Spring";
    }
    
}
