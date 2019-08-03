<%-- 
    Document   : updateusuario
    Created on : 17-may-2017, 14:56:48
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Actualizar usuario</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">${user.ldap} - ${user.nombre} ${user.apellidos}</h3>
            </div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <c:url var="action" value="/usuarios/update/${user.id}"/>
                    <form:form method="post" modelAttribute="user" action="${action}">
                        <div class="form-group" >
                            <form:label class="control-label col-md-2" path ="ldap" >LDAP:</form:label>
                                <div class="col-md-10">
                                <form:input class="form-control" id="ldap" path="ldap" placeholder="Introduce un LDAP"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <form:label class="control-label col-md-2" path ="nombre" >Nombre:</form:label>
                                <div class="col-md-10">
                                <form:input class="form-control" id="nombre" path="nombre" placeholder="Introduce un nombre"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <form:label class="control-label col-md-2" path ="apellidos" >Apellidos:</form:label>
                                <div class="col-md-10">
                                <form:input class="form-control" id="apellidos" path="apellidos" placeholder="Introduce los apellidos"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <form:label class="control-label col-md-2" path ="email" >Email</form:label>
                                <div class="col-md-10">
                                <form:input class="form-control" id="email" path="email" placeholder="Introduce un email"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <form:label class="control-label col-md-2" path ="password" >Contraseña</form:label>
                                <div class="col-md-10">
                                <form:input class="form-control" id="password" path="password" placeholder="Introduce una contraseña"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <form:label class="control-label col-md-2" path ="secciones" >Añadir seccion:</form:label>
                                <div class="col-md-10">
                                <form:select path="secciones" class="form-control">
                                    <form:options items="${seccionesTienda}"/>
                                </form:select>
                            </div>
                        </div>
                        <div class="row text-right col-md-12">
                            <button type="submit" class="btn btn-primary">Actualizar</button>
                        </div>
                        ${User.secciones[0].tienda.nombre}
                    </form:form>
                </div>

            </div>
        </div>
    </div>
</div>