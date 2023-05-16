
package beans.configuracion;
/*

No necesitamos este archivo de configuracion porque JSF 2.3 está incluido en Glassfish
a partir de su version 5*/

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import static jakarta.faces.annotation.FacesConfig.Version.JSF_2_3;

//Indica la version:
@FacesConfig (
        //esto activa el CDI build-in beans que vamos a agregar
        version = JSF_2_3
)

//Indica el scope:
@ApplicationScoped

/*Tambien debemos agregar la carpeta 'resources' en src/main y dentro el archivo 
log4j2.xml
*/
public class ConfigurationJSF {
    
    
    
}
