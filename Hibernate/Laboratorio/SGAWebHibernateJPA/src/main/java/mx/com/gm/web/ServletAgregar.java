
package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.service.ServiceAlumno;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    //recupero los datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String numCalle = request.getParameter("numCalle");
        String barrio = request.getParameter("barrio");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        
    //creo domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNumCalle(numCalle);
        domicilio.setBarrio(barrio);
    //creo contacto
        Contacto contacto = new Contacto();
        contacto.setTelefono(telefono);
        contacto.setEmail(email);
    //creo alumno
        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
    //llamo al servicio y persisto la data
        ServiceAlumno serviceAlumno = new ServiceAlumno();
        serviceAlumno.guardarAlumno(alumno);
    //redirecciono
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
    
}
