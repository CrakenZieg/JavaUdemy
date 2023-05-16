
package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIInput;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {
    
    private boolean comentarioEnviado;

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
        if(this.candidato.getNombre().equals("")){
            log.info("Entrando al caso de fallo: hay que introducir un nombre");
            String msg = "Debes introducir un nombre";
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String componentId = null; //Este es un mensage global
            facesContext.addMessage(componentId, facesMessage);
            return "index";
        } else {
            if(this.candidato.getApellido().equals("")){
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
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
        //recuperamos la instancia actual (la face)
        FacesContext facesContext = FacesContext.getCurrentInstance();
        //buscamos un componente dentro del formulario
        UIViewRoot uiViewRoot = facesContext.getViewRoot();
        //recuperamos el codigo postal (devuelve obj y casteamos a string)
        String nuevoCodigoPostal = (String) valueChangeEvent.getNewValue();
        //si recibimos el codigo 8000
        if("8000".equals(nuevoCodigoPostal)){
        //recuperamos el componente de id partido del formulario vacanteForm del JSF
            UIInput provinciaInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:provinciaId");
        //nombre partido
            int provinciaId = 1;
        //seteamos el valor de la vista
            provinciaInputText.setValue(provinciaId);
        //seteamos el valor del submit
            provinciaInputText.setSubmittedValue(provinciaId);
        //recuperamos el componente de id partido del formulario vacanteForm del JSF
            UIInput partidoInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:partido");
        //nombre partido
            String partido = "Partido de Bahía Blanca";
        //seteamos el valor de la vista
            partidoInputText.setValue(partido);
        //seteamos el valor del submit
            partidoInputText.setSubmittedValue(partido);
        //recuperamos el componente de id partido del formulario vacanteForm del JSF
            UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        //nombre partido
            String ciudad = "Bahía Blanca";
        //seteamos el valor de la vista
            ciudadInputText.setValue(ciudad);
        //seteamos el valor del submit
            ciudadInputText.setSubmittedValue(ciudad);
        
        //Le decimos que se renderice de nuevo
            facesContext.renderResponse();
            
        }
    }
    
    public void ocultarComentario(ActionEvent actionEvent){
        this.comentarioEnviado = !this.comentarioEnviado;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }
    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
    }
    
    
}
