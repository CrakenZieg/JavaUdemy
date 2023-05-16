
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SesionesServlet")
public class SesionesServlet extends HttpServlet{
//Parecido al trabajo previo con cookies
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//Vamos a responder con html
        response.setContentType("text/html;charset=UTF-8");
//creamos un objeto HttpSession
        HttpSession sesion = request.getSession();
//El metodo getSession() del objeto request devuelve un objeto HttpSession si existe o lo crea
//Gracias a ello podemos recuperar, agregar y modificar informacion de la sesion
        String titulo = null;
//Pedimos el atributo contadorVisitas a la sesion;
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
//Si es nulo quiere decir que es la primera visita
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
//agregamos el valor de contadorVisitas a la sesion, se maneja como un mapa, una coleccion de "key":"valor"
//Si el atributo existe le pone el valor nuevo, si no lo crea
        sesion.setAttribute("contadorVisitas", contadorVisitas);
//mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("numero de accesos al recurso: "+contadorVisitas);
        out.print("<br>");
        out.print("ID de la sesion: "+sesion.getId());
//el ID de sesion lo agrega automaticamente el contenedor, el servidor de apliaciones
        out.close();

//Internamente el servidor de aplicaciones utiliza 2 opciones para el manejo de sesiones
//una es agregar el ID de sesion en la URL (URL rewriting) o utiliza una cookie para guardar
//la sesion 
//Por default usa cookies, de estar prohibidas utiliza la primera opcion, el URL rewriting

//cuanto tiempo guardamos la informacion en el lado del servidor?
//creado el ebjeto HttpSession, se crea el archivo web.xml en WEB-INF, y tiene session-timeout 
//de 30 min por default, es decir, 30 min después de la última peticion, se borra la sesion 
//y si llamamos de nuevo se crea otra sesion
    }
}
