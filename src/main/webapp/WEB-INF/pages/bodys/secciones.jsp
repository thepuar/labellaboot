<%-- 
    Document   : secciones
    Created on : 20-ene-2017, 20:56:33
    Author     : thepuar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Listado de secciones</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title">${secciones.size()} Secciones</h3>
            </div>
            <div class="panel-body">
                <table id ="dataTable" class="table table-bordered table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Pedidos en curso</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tfoot class="thead-inverse">
                        <tr>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Pedidos en curso</th>
                            <th>Acciones</th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${secciones}" var="seccion">
                        <tr>
                            <td>${seccion.numero}</td>
                            <td>${seccion.nombre}</td>
                            <td>${seccion.pedidos.size()}</td>
                            <td><a href="<c:url value="/seccion/${seccion.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
