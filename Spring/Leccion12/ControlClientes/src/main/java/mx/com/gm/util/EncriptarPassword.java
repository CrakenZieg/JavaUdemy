
package mx.com.gm.util;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncriptarPassword {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
//    public static void main(String[] args) {
////Creamos una psvm para poder encriptar nuestro password aquí y guardarlo en la ddbb
////No hacemos todo el camino para crear un usuario
//        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
//        String password = "1234";
//        System.out.println("Password: "+password);
//        System.out.println("Password encriptado: "+encriptarPassword(password));
//    }
//    public static String encriptarPassword(String password){
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }
}
