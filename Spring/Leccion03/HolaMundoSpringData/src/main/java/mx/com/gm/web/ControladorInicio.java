
package mx.com.gm.web;

import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.IPersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
@Slf4j
public class ControladorInicio {
    
    @Autowired //similar a injected 
    private IPersonaDao iPersonaDao;
    
    @GetMapping("/")
    public String inicio(Model model){//Spring va a crear un 
        
        var personas = iPersonaDao.findAll(); //genial
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas",personas);
        
        return "index";
    }
    
}
