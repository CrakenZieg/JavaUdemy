
package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//lo definimos como un ManagedBean usando la anotacion @Named
@Named
//definimos el scope
@RequestScoped
public class Candidato {
    
    private String nombre = "Introduce tu nombre";
//creamos una variable log para que, cuando usemos el metodo setNombre(), mandemos
//en que fase se hace al log
    Logger log = LogManager.getRootLogger();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre: " + this.nombre);
    }
    
}
