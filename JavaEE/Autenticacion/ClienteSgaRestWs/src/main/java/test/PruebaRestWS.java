
package test;

import domain.Persona;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

public class PruebaRestWS {
    public static void main(String[] args) {
        
        //pasamos la autenticacion a un obj http...
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder().nonPreemptive().credentials("admin", "admin").build();
        //cramos obj configuracion de cliente
        ClientConfig clientConfig = new ClientConfig();
        //asignmos el obj http.. a la configuracion del cliente 
        clientConfig.register(feature);
        //creamos el cliente y le pasamos el obj clientConfig
        Client cliente = ClientBuilder.newClient(clientConfig);
        //llamamos al metodo listar personas
        WebTarget webTarget = cliente.target("http://localhost:8080/sga-jee-web/webservice").path("/personas");
        //proporcionamos un idPersona valido
        Persona persona = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Persona.class);
        System.out.println("persona recuperada = " + persona );
        
    }
}
