
package mx.com.gm.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

//anotamos la clase con bean de configuracion
@Configuration
public class WebConfig implements WebMvcConfigurer{
//mediante esta clase podemos implementar la internacionalizacion de los textos, 
//asi como tambien otro
    
//anotado como bean se agrega automaticamente al contenedor de Spring
//con el slr configurado con el lenguaje local, Spring sabra con que lenguaje 
//llenar por default
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    
//mediante este bean logramos llamar a un interceptor que de manera dinamica cambia
//el lenguaje de la pagina
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
//registramos nuestro interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
    
}
