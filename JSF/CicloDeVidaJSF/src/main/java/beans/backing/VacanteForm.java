
package beans.backing;

import beans.model.Candidato;
import jakarta.enterprise.context.RequestScoped;
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
    
    public void setCandidato(Candidato candidato){
        this.candidato = candidato;
    }

//haremos un redireccionamiento a otra pagina utilizando el metodo enviar(), si 
//tiene exito o no; en los return no es necesario agregar la extension ya que 
//buscara que tengan la misma que la pagina de partida
    
    public String enviar(){
        if(this.candidato.getNombre().equals("")){
            log.info("Entrando al caso de fallo");
            return "fallo";
        } else {
            log.info("Entrando al caso de exito");
            return "exito";
        }
    }
    
    
}
