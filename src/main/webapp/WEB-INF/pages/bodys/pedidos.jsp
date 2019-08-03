<%-- 
    Document   : pedidos
    Created on : 17-ene-2017, 17:05:32
    Author     : thepuar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Listado de pedidos</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title">${pedidos.size()} Pedidos</h3>
            </div>
            <div class="panel-body">
                <table id ="dataTable" class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Seccion</th>
                            <th>Tipo</th>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Etiqueta</th>
                            <th>Fecha</th>
                            <th>Dias restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                   <tfoot class="thead-inverse">
                        <tr>
                            <th>Seccion</th>
                            <th>Tipo</th>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Etiqueta</th>
                            <th>Fecha</th>
                            <th>Dias restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${pedidos}" var="pedido">
                        <tr>
                            <td>${pedido.proveedor.numSeccion}</td>
                            <td>${pedido.getTipoPedidoDescr()}</td>
                            <td>${pedido.proveedor.nombre}</td>
                            <td>${pedido.numeropedido}</td>
                            <td>${pedido.getEtiquetaString()}</td>
                            <td><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy" /></td>
                            <td>${pedido.getDiasRestantes()}</td>
                            <td>
                                <c:if test="${usuario.isAdmin()}">
                                <a href="<c:url value="/proveedor/${pedido.proveedor.id}"/>" target="_blank"><span class="glyphicon glyphicon-tent"></span></a>
                                <a href="<c:url value="/pedido/${pedido.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                                <a href="<c:url value="/pedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </c:if>
                                <c:if test="${!usuario.isAdmin()}">
                                <a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank"><span class="glyphicon glyphicon-tent"></span></a>
                                <a href="<c:url value="/upedido/${pedido.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                                <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
