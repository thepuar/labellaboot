<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Listado de etiquetas</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">${etiquetas.size()} Etiquetas</h3>
            </div>
            <div class="panel-body">
                <table id="dataTable" class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Seccion</th>
                            <th>Nombre</th>
                            <th>Numero pedidos</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${etiquetas}" var="etiqueta">
                            <tr>
                                <td>${etiqueta.numSeccion}</td>
                                <td>${etiqueta.nombreEtiqueta}</td>
                                <td></td>
                                <td>
                                <a href="<c:url value="/upedido/${pedido.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                                <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                               
                                    
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>