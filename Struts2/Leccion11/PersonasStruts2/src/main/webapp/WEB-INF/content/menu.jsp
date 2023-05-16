<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<a href="<s:url action="bienvenidoAction"/>">Bienvenido</a>
<br/>
<a href="<s:url action="personasAction"/>">Personas</a>
<!-- Estos links iran a la accion y por lo tanto a linkAction que redirigira al jsp -->