
package mx.com.gm.sga.web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.service.PersonaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

@Named("personaBean")
@RequestScoped
public class PersonaBean {
    
    Logger log = LogManager.getRootLogger();
    
    @Inject
    private PersonaService personaService;
    
    private Persona personaSeleccionada;
    
    List<Persona> personas;
    
    public PersonaBean(){
        log.debug("Iniciando el objeto PersonaBean");
    }
    
//como no podemos pedir la lista de personas en el constructor, indicamos que lo haga
//inmediatamente después de su creacion
    @PostConstruct
    public void inicializar(){
        //iniciamos las variables
        personas = personaService.listarPersonas();
        log.debug("Personas recuperadas en ManagedBean:" + this.personas);
        personaSeleccionada = new Persona();
    }
    
    public void editListener(RowEditEvent event){
        Persona persona = (Persona) event.getObject(); //Ventaja de PrimeFaces: devuelve Obj y no atributos
        personaService.modificarPersona(persona); //llamamos al service y modificamos la persona
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }
    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getPersonas() {
        return personas;
    }
    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
    public void agregarPersona(){
        this.personaService.registrarPersona(this.personaSeleccionada);//pasamos la nueva persona a la DDBB
        this.personas.add(personaSeleccionada);//lo actualizamos en el modelo
        this.personaSeleccionada = null;
    }
    
    public void eliminarPersona(){
        this.personaService.eliminarPersona(personaSeleccionada);
        this.personas.remove(this.personaSeleccionada);
        this.personaSeleccionada = null;
    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }
        
}
