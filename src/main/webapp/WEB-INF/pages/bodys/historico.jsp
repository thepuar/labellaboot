<%-- 
    Document   : historico
    Created on : 09-feb-2017, 0:24:10
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Lista de movimientos</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title">${historico.size()} Movimientos</h3>
            </div>
            <div class="panel-body">
                <table id ="dataTable" class="table table-bordered table-striped"  width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Objeto</th>
                            <th>Tipo</th>
                            <th>Dato</th>
                            <th>Fecha</th>
                            <th>Descripcion</th>
                        </tr>
                    </thead>
                    <tfoot class="thead-inverse">
                        <tr>
                            <th>ID</th>
                            <th>Objeto</th>
                            <th>Tipo</th>
                            <th>Dato</th>
                            <th>Fecha</th>
                            <th>Descripcion</th>
                        </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach items="${historico}" var="hist">
                        <tr>
                            <td>${hist.id}</td>
                            <td>${hist.tipoObjeto}</td>
                            <td>${hist.tipoMovimiento}</td>
                            <td>${hist.dato}</td>
                            <td>${hist.fecha}</td>
                            <td>${hist.descripcion}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

