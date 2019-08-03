<%-- 
    Document   : saludo
    Created on : 27-dic-2016, 18:59:59
    Author     : thepuar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <meta  charset="UTF-8"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
    </head>
    <body>
        <h1>Estas en saludo MVC ${modelo.ldap} - ${commando.ldap}!</h1>
        <span>El valor de session ${valorsesion}</span>
        <a href="${pageContext.request.contextPath}/saludo2">Ir a session </a>
    </body>
</html>
