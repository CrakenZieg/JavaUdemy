
package mx.com.gm;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Spring reconoce esta clase por la anotacion
//Controller sirve para introducirlo como parte de Spring MVC
//aunque toda esta tecnologia esta basada en servlets, ya no es necesario extender
//las clases de ellos ya que lo hace a partir de la anotaciones
@Controller 
//Lombok es un logger, nos permite enviar mensajes a consola entre otras cosas
@Slf4j
public class ControladorInicio {

//creamos una variable para almacenar el saludo de application.properties y se la 
//asignamos con la anotacion de value (de Spring)
    @Value("${index.saludo}")
    private String saludo;
    
//la anotacion especifica que responde a un GET al llamar a, en este caso, LocalHost:8080'/'
    @GetMapping("/")
//Por inyeccion de dependencias, como Controller es parte de la fabrica de Spring
//cualquier metodo anotado como Mapping puede recibir diferentes argumentos solo 
//declarandolos, Spring las va a instanciar por nosotros y nos las va a devolver
//En este caso un obj tipo model
    public String inicio(Model model){//Spring va a crear un 
        log.info("Ejecutando el controlador Spring MVC");
//en ves de usar recibir data a traves de httpServletRequest/Response (aunque se puede)
//la vamos a usar para enviar informacion a index
        var mensaje = "Hola mundo con Thymeleaf!";
        
        var persona1 = new Persona();
        persona1.setNombre("Roberto1");
        persona1.setApellido("Ricardo1");
        persona1.setEmail("Ruben1@mail.com");
        persona1.setTelefono("112233");
        var persona2 = new Persona();
        persona2.setNombre("Roberto2");
        persona2.setApellido("Ricardo2");
        persona2.setEmail("Ruben2@mail.com");
        persona2.setTelefono("223344");
        var persona3 = new Persona();
        persona3.setNombre("Roberto3");
        persona3.setApellido("Ricardo3");
        persona3.setEmail("Ruben3@mail.com");
        persona3.setTelefono("334455");
        
        //var personas = new ArrayList<Persona>;
        var personas = Arrays.asList(persona1, persona2, persona3);
        
        model.addAttribute("mensaje",mensaje);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        
        return "index";//nos redirigira a index . html, ya que Thymeleaf trabaja directamente con html
        //Dentro desrc/main/resources, en el paquete static incluiremos recursos como .js o imagenes
        //en templates incluiremos los html
    }
    
}
