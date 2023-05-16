
package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import mx.com.gm.service.PersonaService;


@Controller 
@Slf4j
public class ControladorInicio {

//similar a injected, busca en el contenedor de Spring una clase que implemente 
//la interface que inyectamos e instacia la implementacion (la reconoce por la 
//anotacion de service)
    @Autowired 
    private PersonaService personaService;
    
    @GetMapping("/")
    public String inicio(Model model){
        
        var personas = personaService.listarPersonas();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas",personas);
        
        return "index";
    }
    
}
