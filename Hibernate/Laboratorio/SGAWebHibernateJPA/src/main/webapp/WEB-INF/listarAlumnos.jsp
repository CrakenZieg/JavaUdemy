<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Alumnos</title>
    </head>
    <body>
        <h1>Listado de Alumnos</h1>
<!-- Aunque podriamos redireccionar directamente al jsp, para mantener el patron MVC 
se recomienda hacerlo a traves de un sarvlet -->
        <a href="${pageContext.request.contextPath}/ServletRedireccionar">Agregar</a>
        <br/>
        <br/>
        <table border="1">
            <tr>
                <th>Alumno Id</th>
                <th>Nombre</th>
                <th>Domicilio</th>
                <th>Telefono</th>
                <th>Email</th>
            </tr>
            <c:forEach var="alumno" items="${alumnos}">
                <tr>
                    <td>
                        <a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">
                            ${alumno.idAlumno}
                        </a>
                    </td>
                    <td>${alumno.nombre} ${alumno.apellido}</td>
                    <td>${alumno.domicilio.calle} ${alumno.domicilio.numCalle}, barrio ${alumno.domicilio.barrio}</td>
                    <td>${alumno.contacto.telefono}</td>
                    <td>${alumno.contacto.email}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
