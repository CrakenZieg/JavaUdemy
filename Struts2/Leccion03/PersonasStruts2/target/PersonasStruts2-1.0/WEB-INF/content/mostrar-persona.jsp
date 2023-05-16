<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!-- Usamos los tags de struts -->

<!DOCTYPE html>
<html>
    <head>
        <title>Mostrar Persona con Struts2</title>
    </head>
    <body>
        <!-- accedemos a la variable saludosAtr de la clase HolaMundoStruts mediante su getter -->
        <h1>Personas con Struts2</h1>
        <!-- como no especificamos que accion se iba a llamar al hacer submit, 
        por default se llama a la que está relacionada por convencion -->
        <s:form>
            <s:textfield name="nombre" />
            <s:submit valur="Enviar" />
            <div>
                Nombre proporcionado: <s:property value="nombre"/>
            </div>
        </s:form>
    </body>
</html>
