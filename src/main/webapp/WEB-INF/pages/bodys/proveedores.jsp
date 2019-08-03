<%-- 
    Document   : proveedores
    Created on : 17-ene-2017, 14:41:38
    Author     : thepuar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="row">
        <h3>Listado de proveedores</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">${proveedores.size()} Proveedores</h3>
            </div>
            <div class="panel-body ">
                <table id ="dataTable" class="table table-bordered table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Sección</th>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Franco</th>
                            <th>Pedidos</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tfoot class="thead-inverse">
                        <tr>
                            <th>Sección</th>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Franco</th>
                            <th>Pedidos</th>
                            <th></th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${proveedores}" var="proveedor">
                        <tr>
                            
                            <td>${proveedor.numSeccion}</td>
                            <td>${proveedor.numero}</td>
                            <td>${proveedor.nombre}</td>
                            <td>${proveedor.franco}</td>
                            <td>${proveedor.pedidos.size()}</td>
                            <td><c:if test="${usuario.isAdmin()}">
                                <a href="<c:url value="/proveedor/${proveedor.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                                <a href="<c:url value="/proveedor/update/${proveedor.id}"/>"><span class="glyphicon glyphicon-refresh"></span></a>
                                </c:if>
                                <c:if test="${!usuario.isAdmin()}">
                                <a href="<c:url value="/uproveedor/${proveedor.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                                <a href="<c:url value="/uproveedor/update/${proveedor.id}"/>"><span class="glyphicon glyphicon-refresh"></span></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
            
            <!--Codigo para pedido -->
    </div>
</div>
