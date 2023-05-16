<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Alumno</title>
    </head>
    <body>
        <h1>Agregar Alumno</h1>
        <form name="form1" action="${pageContext.request.contextPath}/ServletAgregar" method="post">
            Nombre: <input type="text" name="nombre">
            <br/>
            Apellido: <input type="text" name="apellido">
            <br/>
            <br/>
            Datos del domicilio:
            <br/>
            Calle: <input type="text" name="calle">
            <br/>
            Altura: <input type="text" name="numCalle">
            <br/>
            Barrio: <input type="text" name="barrio">
            <br/>
            <br/>
            Datos de contacto:
            <br/>
            Telefono: <input type="text" name="telefono">
            <br/>
            Email: <input type="text" name="email">
            <br/>
            <br/>
            <input type="submit" name="Agregar" value="Agregar">
        </form>
    </body>
</html>
