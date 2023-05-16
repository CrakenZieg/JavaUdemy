
package mx.com.gm.web;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
import mx.com.gm.service.PersonaServiceRS;

@ApplicationPath("/webservice")
public class JAXRSActivator extends Application{
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        resources.add(CorsFilter.class);
        resources.add(PersonaServiceRS.class);

        return resources;
    }
    
}
