
package mx.com.gm.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/{
//autenticacion: presentacion de credenciales por parte de un usuario
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.builder()
            .username("admin")                
            .password(passwordEncoder().encode("1234"))
            .roles("ADMIN","USER")
            .build();
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("1234"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
//la herramienta de hash para ocultar el password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//autorizacion: permiso (o no) para determinado usuario de visualizacion, ejecucion, redireccion, etc. 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/editar/**", "/agregar/**"
                        , "/eliminar", "/eliminar/**").hasRole("ADMIN")
                .requestMatchers("/","/errores/**").hasAnyRole("USER","ADMIN"))
                .formLogin(form -> form.loginPage("/login").permitAll())
                .logout()
                .logoutSuccessUrl("/login").and()
                .exceptionHandling().accessDeniedPage("/errores/403");
        return http.build();
    }
        
/*
agregamos usuarios manualmente, metodo deprecado como parte de WebSecurityConfigurerAdapter,
actualmente orientan las configuraciones de seguridad basadas en componentes 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}1234")
                .roles("ADMIN","USER")
                .and()
                .withUser("user")
                .password("{noop}1234")
                .roles("USER");
    }    
otro metodo deprecado
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMarchers("/editar/**", "/agregar/**", "/eliminar", "/eliminar/**")
                .hasRole("ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "ADMIN");
    }
*/
}
