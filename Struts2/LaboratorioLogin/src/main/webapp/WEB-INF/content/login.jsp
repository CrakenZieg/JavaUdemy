<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:property value="titulo" /></title>
    </head>
    <body>
        <h1><s:property value="titulo" /></h1>
        <s:form>
            <div>
            <s:textfield key="form.usuar" name="usuario" />
            <s:password key="form.contra" name="password" />
            <s:submit key="form.boton" name="submit" />
            </div>
        </s:form>
            <br/>
            <div>
                <s:text name="form.valor"/>: <br/>
                <s:property value="usuar" />: <s:property value="usuario"/> <br/>
                <s:property value="contra" />: <s:property value="password"/>
            </div>
    </body>
</html>
