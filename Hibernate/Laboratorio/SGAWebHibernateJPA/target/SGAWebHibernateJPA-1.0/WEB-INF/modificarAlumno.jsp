<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modificar Alumno</title>
    </head>
    <body>
        <h1>Modificar Alumno</h1>
        <form name="form2" action="${pageContext.request.contextPath}/ServletModificar" method="post">
            Nombre: <input type="text" name="nombre" value="${alumno.nombre}">
            <input type="hidden" name="idAlumno" value="${alumno.idAlumno}"/>
            <br/>
            Apellido: <input type="text" name="apellido" value="${alumno.apellido}">
            <br/>
            <br/>
            Datos del domicilio:
            <br/>
            Calle: <input type="text" name="calle" value="${alumno.domicilio.calle}">
            <br/>
            Altura: <input type="text" name="numCalle" value="${alumno.domicilio.numCalle}">
            <br/>
            Barrio: <input type="text" name="barrio" value="${alumno.domicilio.barrio}">
            <br/>
            <br/>
            Datos de contacto:
            <br/>
            Telefono: <input type="text" name="telefono" value="${alumno.contacto.telefono}">
            <br/>
            Email: <input type="text" name="email" value="${alumno.contacto.email}">
            <br/>
            <br/>
            <input type="submit" name="Modificar" value="Modificar">
            <input type="submit" name="Eliminar" value="Eliminar">
        </form>
    </body>
</html>
