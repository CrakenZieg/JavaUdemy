
package test;

import datos.Conexion;
import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        
        Connection conexion = null;
                
        try {
            
            conexion = Conexion.getConnection();
            
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);            
            }
            
            UsuarioDAO usuarioDao = new UsuarioDAO(conexion);
            
            Usuario usuario1 = new Usuario("admin","carlos1");
            usuarioDao.insertar(usuario1);
        
            Usuario usuario2 = new Usuario("carlos2","carlos2");
            usuarioDao.insertar(usuario2);
            Usuario usuario3 = new Usuario("carlos3","carlos3");
            usuarioDao.insertar(usuario3);
            Usuario usuario4 = new Usuario("carlos4","carlos4");
            usuarioDao.insertar(usuario4);

            List<Usuario> usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario -> {
                System.out.println("Usuario: " + usuario);
            });

            usuarioDao.eliminar(usuario3);
            usuario4 = new Usuario(4,"carlos5","carlos5");
            usuarioDao.actualizar(usuario4);

            usuarios = usuarioDao.seleccionar();
            usuarios.forEach(usuario -> {
                System.out.println("Usuario: " + usuario);
            });
        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
    }
}
