
package web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet{
//Cuando el servlet reciba un get :
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//generamos la respuesta y definimos su contenido como un archivo de excel
        response.setContentType("application/vnd.ms-excel");
//le decimos al navegador que lo descargue cuando haces click
//param1: es el tipo de contenido; param2: descargalo;nombre de archivo
        response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
//para un uso profecional de excel recomienda la libreria poi.apache.org

//ahora le indicamos al navegador que no guarde información previa, o sea, cada vez que hagamos click
//será informacion nueva, no de cache y que tampoco lo guarde
        response.setHeader("Pragma", "no-cache");
//Pragma: para HTTP/1.0, hace que cada request del cliente sea siempre por una version fresca, no de cache de 
//servers o intermediarios, solo aplica a la request del cliente
        response.setHeader("Cache-Control", "no-store");
//Cache-Control: para HTTP/1.1, sirve tanto para request (cliente) como para response (server), en este caso 
//indica que nadie lo puede guardar en ningun cache
        response.setDateHeader("Expires", -1);
//setDateHeader: param1: header; param2: valor de fecha
//Expires: contiene la fecha y hora en la que se considerará la response caducada

//informacion hacia el cliente:
        PrintWriter out = response.getWriter();
        out.print("\tValores");//\t es tabulacion, saltea una celda
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=Suma(b2:b3)");//Total (salto a la casilla contigua) suma
        out.close();

    }
}
