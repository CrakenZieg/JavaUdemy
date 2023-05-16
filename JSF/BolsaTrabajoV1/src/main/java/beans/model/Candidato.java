
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
    
    private String nombre;
    private String apellido;
    private String salarioDeseado;
//creamos una variable log para que, cuando usemos el metodo setNombre(), mandemos
//en que fase se hace al log
    Logger log = LogManager.getRootLogger();
    
    public Candidato(){
        log.info("Creando el objeto Candidato");
        this.setNombre("Introduce tu nombre");
        this.setApellido("Introduce tu apellido");
        this.setSalarioDeseado("Introduce el salario deseado");
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre: " + this.nombre);
    }
    
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("Modificando la propiedad de apellido: " + this.apellido);
    }

    public String getSalarioDeseado() {
        return salarioDeseado;
    }
    public void setSalarioDeseado(String salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando la propiedad de salario: " + this.salarioDeseado);
    }
    
}
