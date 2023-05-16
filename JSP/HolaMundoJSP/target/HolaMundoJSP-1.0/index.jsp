<%-- 
    Document   : index
    Created on : 16 oct. 2022, 16:27:25
    Author     : cocoz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--abajo vemos la directiva, nos sirve para especificar el tipo de contenido a desplegar en el navegador--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--En los servlets, al objeto response también le podiamos aclarar que tipo de contenidos devolviamos
hay directivas para devolver archivos, paginas, taglib, etc
Los JSP se enfocan en el HTML e incrustar codigo JAVA, a diferencia de los Servlet que se enfocan en JAVA
e incrustan HTML--%>

<%--Un JSP es un componente del lado del servidor, no es solo un HTML, si no que se va a traducir en un 
servlet y va a cumplir con su ciclo de vida.
Haciendo click derecho en index.jsp podemos luego ir a View Servlet y nos lleva al servlet que se genera 
automaticamente cuando hacemos correr la aplicacion web, alli vemos el codigo html incrustado, la llamada 
a clases importadas, etc
El JSP se transforma en Servlet, el Servlet responde con HTML al cliente
--%>

<!DOCTYPE html>
<html>
    <head>
        <title>HolaMUndo JSP</title>
    </head>
    <body>
        <h1>HolaMUndo JSP</h1>
<%--tenemos, como para javascript el <script></script>, los scriplet '<% %>' para insertar codigo
Java en nuestro HTML, además, a diferencia del caso de los Servlets, tenemos tambien algunas variables
automaticamente, como out, de tipo JspWriter (equivalente a PrintWriter)
Con Expression Language (EL) podemos acceder a datos del back de manera dinamica mediannte ${} 
podemos mandar a imprimir informacion, llamar metodos, meter condicionales, etc
Con Expression Tag <%=  %> podemos imprimir directamente (salteando out.print(""))
Con la librería de JSTL (JavaServer Pages Standard Tag Library) debemos abrir arriba con la directiva 
taglib, luego nombramos la libreria con prefix="", elegimos la libreria con uri="", nos permite personalizar 
etiquetas y encapsular acciones con codigo Java, en el ejemplo vemos que accedemos a :out (que asumo es out.print..)
--%>
        <ul>
            <li> <% out.print("HolaMundo con Scriplets");%> </li>
            <li> ${"HolaMundo con Expression Language (EL)"} </li>
            <li> <%= "HolaMundo con Expression Tag" %> </li>
            <li> <c:out value="HolaMundo con JSTL"/> </li>
        </ul>
    </body>
</html>