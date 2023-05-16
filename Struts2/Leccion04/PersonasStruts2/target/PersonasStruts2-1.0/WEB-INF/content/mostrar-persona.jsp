<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!-- Usamos los tags de struts -->

<!DOCTYPE html>
<html>
    <head>
<!-- se pueden recuperar textos de archivos property usando el que jsp llama el metodo get(Value) -->
        <title><s:property value="titulo"/></title>
    </head>
    <body>
        <h1><s:property value="titulo"/></h1>
        <s:form>
            <s:textfield name="nombre" />
<!-- otra forma de recuperarlos es llamarlos directamente usando key -->
            <s:submit key="persona.boton" name="submit" />
            <div>
                <s:property value="valor"/>: 
                <s:property value="nombre"/>
            </div>
        </s:form>
    </body>
</html>
