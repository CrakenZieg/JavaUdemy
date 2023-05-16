
package mx.com.gm.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller 
@Slf4j
public class ControladorInicio {

//similar a injected, busca en el contenedor de Spring una clase que implemente 
//la interface que inyectamos e instacia la implementacion (la reconoce por la 
//anotacion de service)
    @Autowired 
    private PersonaService personaService;

//Con user recuperamos el usuario que loggeo
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user){
        
        var personas = personaService.listarPersonas();
        
        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario loggeado: "+ user);
        model.addAttribute("personas",personas);
        var saldoTotal = 0D;
        for(var p: personas){
            saldoTotal+=p.getSaldo();
        }
        model.addAttribute("saldoTotal",saldoTotal);
        model.addAttribute("totalClientes",personas.size());
        return "index";
    }
//Al pasarle por parametro un obj Persona Spring nos va a inyectar tal obj, este  
//va a ser creado si es que no hay uno en la fabrica y tambien va quedar en el 
//ambito de la fabrica de Spring, por eso automaticamente, al redirigir a agregar
//Spring va a crear un obj Persona y a su vez redirigira a modificar(que vamos a 
//usar para crear y update)
    @GetMapping("/agregar") 
    public String agregar(Persona persona){
        return "modificar";
    }
//anteponemos la notacion de Valid para que el metodo sepa que hay que validar el 
//parametro, si tiene errores vuelve a la vista de modificar
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }
    
//Debemos usar como nombre de variable el mismo que el atributo de la clase que 
//queremos inicializar, Spring va a buscar una variable de tipo persona y va a 
//settear el atributo que le pasamos, ademas necesitamos un parametro model para 
//continuarel camino de lo que recuperamos
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
//con la persona setteada con el id, le reasignamos la que nos devuelve el servicio
//y la agregamos al argumento model para que siga su camino hasta el formulario 
//de modificar donde va a completar los formularios con los datos de la persona
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }
//por GET
    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Persona persona){
        persona = personaService.encontrarPersona(persona);
        personaService.eliminar(persona);
        return "redirect:/";
    }
//por QueryParameter (ya reconoce que el parametro se corresponde con un atributo)
//del objeto que le pasamos (Persona)
    @GetMapping("/eliminar")
    public String eliminarQ(Persona persona){
        persona = personaService.encontrarPersona(persona);
        personaService.eliminar(persona);
        return "redirect:/";
    }
   
}
