<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="bienvenido.titulo" /></title>
        <s:head/>
    </head>
    <body>
        <h1><s:text name="bienvenido.titulo" /></h1>
        <!-- Esta etiqueta despliega los mensajes de error que le enviemos al jsp -->
        <s:actionmessage/>
        <h2>
            <s:text name="bienvenido.mensaje" />
        </h2>
        </br>
        <s:text name="form.usuar" />: <s:property value="usuario" />
        </br>
        <s:text name="form.contra" />: <s:property value="password" />
        </br>
        <a href="<s:url action="login" />"><s:text name="bienvenido.regresar"/></a>
    </body>
</html>
