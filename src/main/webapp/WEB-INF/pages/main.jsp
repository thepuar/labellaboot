<%-- 
    Document   : saludo
    Created on : 27-dic-2016, 18:59:59
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
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

        <div class="container">
            <h1>Hello World MVC!</h1>
            <div class="row">
                <div class="col-xs-6 col-md-4"></div>
                <div class="col-xs-6 col-md-4">
                    <form:form method="GET" action="${pageContext.request.contextPath}/saludo" >
                        <div class="form-group">
                            <form:label path="ldap">LDAP</form:label>
                            <form:input type="number" path="ldap" class="form-control" placeholder="Introduce tu LDAP"/>
                        </div>
                        <div class="form-group">
                            <form:label path="password">Password</form:label>
                            <form:input type="password" class="form-control" path="password" placeholder="Introduce tu password"/>
                        </div>
                        <button type="submit" class="btn btn-default">Login</button>
                    </form:form>

                </div>
                <div class="col-xs-6 col-md-4"></div>
            </div>
    </body>
</html>
