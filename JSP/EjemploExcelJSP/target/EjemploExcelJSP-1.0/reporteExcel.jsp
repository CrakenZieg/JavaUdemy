<%-- la pagina de error la incluimos en la carpeta WEB-INF para que no sea 
accesible desde el navegador.
será privada, solo los componentes de la aplicacion puede acceder a JSP o recursos 
dentro de esta carpeta--%>
<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vd.ms-excel" %>
<% 
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel!</h1>
        <br>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descriccion</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <th>1. Fundamentos de Java</th>
                <th>Aprenderemos la sintaxis basica</th>
                <th><%= Conversiones.format("500") %></th>
            </tr>
<!-- 
al querer formatear el String "500" y no poder devuelve un 'Http Status 500 - Internal Server Error' 
Vamos a crear un JSP que maneje lo errores para poder recuperarnos de ciertos errores
-->
            <tr>
                <th>2. Programacion con Java</th>
                <th>Pondremos en practica conceptos de la programacion orientada a objetos</th>
                <th><%= Conversiones.format(new Date()) %></th>
            </tr>
        </table>
    </body>
</html>
