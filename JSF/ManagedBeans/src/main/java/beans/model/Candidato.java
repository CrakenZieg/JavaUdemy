
package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

//lo definimos como un ManagedBean usando la anotacion @Named
@Named
//definimos el scope
@RequestScoped
public class Candidato {
    
    private String nombre = "Introduce tu nombre";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
