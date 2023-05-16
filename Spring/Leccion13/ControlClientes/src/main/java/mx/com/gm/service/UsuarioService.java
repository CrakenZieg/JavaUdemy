
package mx.com.gm.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.dao.UsuarioDao;
import mx.com.gm.domain.Rol;
import mx.com.gm.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Esta clase va a ser un bean de servicio de Spring, por mas que la clase no se 
//llame de esa manera, con la notacion service spring lo reconoce como userDetailsService
@Service
@Slf4j
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//recuperamos el usuario por username
        Usuario usuario = usuarioDao.findByUsername(username);
        if(usuario==null){
            throw new UsernameNotFoundException(username);
        } 
//recuperamos los roles asociados al usuario, los roles van wrapeados en grantedAuthority
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
//devolvemos el usuario nuevo
        return new User(usuario.getUsername(),usuario.getPassword(),roles);
    }
    
}
