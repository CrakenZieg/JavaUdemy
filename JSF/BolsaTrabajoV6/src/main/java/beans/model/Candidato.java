
package beans.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//lo definimos como un ManagedBean usando la anotacion @Named
@Named
//definimos el scope
@RequestScoped
public class Candidato {
    
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNaciemiento;
    private String codigoPostal;
    private String partido;
    private String ciudad;
    private String comentario;
    
//creamos una variable log para que, cuando usemos el metodo setNombre(), mandemos
//en que fase se hace al log
    Logger log = LogManager.getRootLogger();
    
    public Candidato(){
        log.info("Creando el objeto Candidato");
        this.setNombre("");
        this.setApellido("");
        this.setSalarioDeseado(0);
        this.setFechaNaciemiento(null);
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

    public int getSalarioDeseado() {
        return salarioDeseado;
    }
    public void setSalarioDeseado(int salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando la propiedad de salario: " + this.salarioDeseado);
    }
    
    public Date getFechaNaciemiento() {
        return fechaNaciemiento;
    }
    public void setFechaNaciemiento(Date fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
        log.info("Modificando la propiedad fecha de nacimiento: " + this.fechaNaciemiento);
    }
    
    
    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPartido() {
        return partido;
    }
    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    
}
