<!-- Solo vamos a refrescar la pagina y llamar al Servlet Controlador, se va a refrescar en 0 segundos
y se redirigirá a la \${direccion de la pagina}/ServletControlador (agrego '\' antes de la expresion 
language de la direccion de la pagina porque, aunque esta en comentario, el IDE la identifica)
-->
<meta http-equiv="refresh" content="0;url=${pageContext.request.contextPath}/ServletControlador">
