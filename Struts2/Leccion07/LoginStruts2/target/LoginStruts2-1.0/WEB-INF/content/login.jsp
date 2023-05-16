<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="form.titulo" /></title>
        <!-- Agregamos esta etiqueta para que agregar los CSS de struts -->
        <s:head/>
    </head>
    <body>
        <h1><s:text name="form.titulo" /></h1>
        <!-- Esta etiqueta despliega los mensajes de error que le enviemos al jsp -->
        <s:actionerror />
        <s:form action="ValidarUsuario">
            <div>
            <s:textfield key="form.usuar" name="usuario" />
            <s:password key="form.contra" name="password" />
            <s:submit key="form.boton" name="submit" />
            </div>
        </s:form>
    </body>
</html>
