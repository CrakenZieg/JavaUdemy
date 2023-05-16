
package mx.com.gm.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.service.ServiceAlumno;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String idAlumnoS = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);
        
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);
        
        ServiceAlumno service = new ServiceAlumno();
        alumno = service.encontrarAlumno(alumno);
        
        //request.setAttribute("alumno", alumno);
//Para no perder los datos de id de contacto, domicilio y alumno, de manera que se 
//modifiquen los existentes y no se creen nuevos, vamos a guardar los datos del alumno
//(y por ende los de contacto y domicilio asociados) en la sesion, cuando hagamos el post
//vamos a trabajar sobre los objetos guardados en la sesion, no nuevos recien creados
//como cuando agregamos un alumno desde cero
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);
        
        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        ServiceAlumno serviceAlumno = new ServiceAlumno();
//si se presiona 'Modificar', modificar va a tener el value de modificar que recuperamos
//de la request, si se presiona 'Eliminar' modificar va a tener el valor de null
//ya que la request no va a tener el parametro de modificar y por lo tanto vamos
//a saber que el boton que se presiono fue el de eliminar
        String modificar = request.getParameter("Modificar");
        
        if(modificar!=null){
    //recupero los datos del formulario
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String numCalle = request.getParameter("numCalle");
            String barrio = request.getParameter("barrio");
            String telefono = request.getParameter("telefono");
            String email = request.getParameter("email");

    //recuperamos el objeto alumno de la sesion
            HttpSession sesion = request.getSession();

    //creo alumno
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

    //re setteo los valores del objeto en el formulario
            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNumCalle(numCalle);
            alumno.getDomicilio().setBarrio(barrio);
            alumno.getContacto().setTelefono(telefono);
            alumno.getContacto().setEmail(email);

    //llamo al servicio y persisto la data
            serviceAlumno.guardarAlumno(alumno);

    //eliminamos el obj alumno de la sesion, para que no se siga propagando
            sesion.removeAttribute("alumno");
        } else {
    //recuperamos el idAlumno
            String idAlumnoS = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);
    //creo el obj Alumno
            Alumno alumno = new Alumno(idAlumno);
    //llamo al servicio y elimino el alumno
            serviceAlumno.eliminarAlumno(alumno);
        }
    //redirecciono
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }
    
}
