<%-- 
    Document   : tiendas
    Created on : 20-ene-2017, 21:18:40
    Author     : thepuar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Listado de tiendas</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title">${tiendas.size()} tiendas</h3>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Secciones</th>
                            <th>Última actualización</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${tiendas}" var="tienda">
                        <tr>
                            <td><a href="<c:url value="/tienda/${tienda.id}"/>">${tienda.id}</a></td>
                            <td>${tienda.numero}</td>
                            <td>${tienda.nombre}</td>
                            <td>${tienda.secciones.size()}</td>
                            <td>${tienda.getFechaLPRE()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>