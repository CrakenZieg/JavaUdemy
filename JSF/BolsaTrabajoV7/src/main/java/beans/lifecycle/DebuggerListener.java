
package beans.lifecycle;

import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebuggerListener implements jakarta.faces.event.PhaseListener {
    
//Definimos la variable logger que nos va a permitir mandar mensajes a la consola
    Logger log = LogManager.getRootLogger();
    
//Antes de ejecutar fase
    @Override
    public void beforePhase(PhaseEvent pe) {
//Vamos a revisar si la configuracion del manejo de log está en INFO
        if(log.isInfoEnabled()){
            log.info("Antes de la fase: " + pe.getPhaseId().toString());
        }
    }
//Despues de ejecutar fase
    @Override
    public void afterPhase(PhaseEvent pe) {
//Idem
        if(log.isInfoEnabled()){
            log.info("Despues de la fase: " + pe.getPhaseId().toString());
        }
    }
//recupera el id de la fase
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
