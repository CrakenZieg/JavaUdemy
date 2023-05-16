
package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {

    Logger log = LogManager.getRootLogger();
    
//Para poder utilizarlo vamos a usar el concepto de CDI, inyectando una dependencia
//de este bean con la anotacion @ Inject. Ahora podemos utilizar este objeto dentro
//de este Bean
    @Inject
    private Candidato candidato;
    
    public VacanteForm(){
        log.info("Creando el objeto VacanteForm");
    }
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }

//haremos un redireccionamiento a otra pagina utilizando el metodo enviar(), si 
//tiene exito o no; en los return no es necesario agregar la extension ya que 
//buscara que tengan la misma que la pagina de partida
    
    public String enviar(){
        if(this.candidato.getNombre().equals("Introduce tu nombre")){
            log.info("Entrando al caso de fallo: hay que introducir un nombre");
            String msg = "Debes introducir un nombre";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String componentId = null; //Este es un mensage global
            facesContext.addMessage(componentId, facesMessage);
            return "index";
        } else {
            if(this.candidato.getApellido().equals("Introduce tu apellido")){
                log.info("Entrando al caso de fallo: hay que introducir un apellido");
//Validamos desde Java
                String msg = "Debes introducir un apellido";
//creamos un objeto FacesMessage con el nivel de severidad del error y un mensaje
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);//params: severidad, resumen, detalle
//FacesContext contiene toda la informacion de una request a un JSF
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null; //Este es un mensage global, no asociado a un componente
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            } else {
                if(this.candidato.getSalarioDeseado() == 0){
                    log.info("Entrando al caso de fallo: hay que introducir un salario deseado");
                    String msg = "Debes introducir el salario deseado";
                    FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    String componentId = null; //Este es un mensage global
                    facesContext.addMessage(componentId, facesMessage);
                    return "index";
                }
            }
            log.info("Entrando al caso de exito");
            return "exito";
        }
    }
    
    
}
