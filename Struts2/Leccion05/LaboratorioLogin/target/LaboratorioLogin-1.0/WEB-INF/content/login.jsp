<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name="form.titulo" /></title>
    </head>
    <body>
        <h1><s:text name="form.titulo" /></h1>
        <s:form action="validarUsuario">
            <div>
            <s:textfield key="form.usuar" name="usuario" />
            <s:password key="form.contra" name="password" />
            <s:submit key="form.boton" name="submit" />
            </div>
        </s:form>
    </body>
</html>
