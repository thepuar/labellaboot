<%-- 
    Document   : usuarios
    Created on : 16-feb-2017, 4:12:17
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <div class="row">
        <h3>Listado de usuarios</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">${usuarios.size()} usuarios</h3>
            </div>
            <div class="panel-body">
                <table id ="dataTable"class="table table-bordered table-stripred table-responsive">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Tienda</th>
                            <th>NºSec</th>
                            <th>Ldap</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tfoot class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Tienda</th>
                            <th>NºSecciones</th>
                            <th>Ldap</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Email</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach items="${usuarios}" var="usuario">
                            <tr>
                                <td>${usuario.id}</td>
                                <td>Tienda?</td>
                                <td>${usuario.secciones.size()}</td>
                                <td>${usuario.ldap}</td>
                                <td>${usuario.nombre}</td>
                                <td>${usuario.apellidos}</td>
                                <td><a href="#" title="Email" data-toggle="popover" data-placement="left" data-content="${usuario.email}">
                                        <span class="glyphicon glyphicon-info-sign"></span>
                                    </a>
                                    <a href="<c:url value="/usuarios/update/${usuario.id}"/>"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </div>
</div>
            
            