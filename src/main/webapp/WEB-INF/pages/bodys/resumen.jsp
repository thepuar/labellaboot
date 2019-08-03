<%-- 
    Document   : resumen
    Created on : 01-feb-2017, 19:08:25
    Author     : thepuar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <h2>Resumen de la bella</h2>
    <ul class="nav nav-tabs nav-justified">
        <li  class="active"><a data-toggle="tab" href="#pedidos">Pedidos</a></li>
        <li ><a data-toggle="tab" href="#entregas">Planificador</a></li>
        <li ><a data-toggle="tab" href="#opecom">OPECOM</a></li>
    </ul>

    <div class="tab-content">
        <div id="pedidos" class="tab-pane fade in active">
            </br>
            <c:forEach items="${numpedidos}" var="pedidos" varStatus="loop">
                <c:set var="ruta" value="pedidos${loop.index+1}"/>
                <input type="hidden" id="${ruta}" value="${pedidos}">
            </c:forEach>
            <div class="chartpedidosencamino" style="height: 300px; width: 100%">
            </div>
            </br>
            <c:forEach items="${udspedidos}" var="uds" varStatus="loop">
                <c:set var="ruta" value="uds${loop.index+1}"/>
                <input type="hidden" id="${ruta}" value="${uds}">
            </c:forEach>
            <div class="chartudsencamino" style="height: 300px; width: 100%">
            </div>
                </br>
            <c:forEach items="${valorencurso}" var="valor" varStatus="loop">
                <c:set var="ruta" value="valorencurso${loop.index+1}"/>
                <input type="hidden" id="${ruta}" value="${valor}">
            </c:forEach>
            <div class="chartvalorencurso" style="height: 300px; width: 100%">
            </div>
        </div>
        
        
        <div id="entregas" class="tab-pane fade in active">
            </br>
            <c:forEach items="${pedidosxdia}" var="numpedidos" varStatus="loop">
                <c:set var="ruta" value="numpedidos${loop.index+1}"/>
                <input type="hidden" id="${ruta}" value="${numpedidos}">
            </c:forEach>
            <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                <c:set var="dia" value="nombredia${loop.index+1}"/>
                <input type="hidden" id="${dia}" value="${nombredia}"/>
            </c:forEach>
            <div class="chartpedidosxdia" style="height: 300px; width: 100%">
            </div>
        </div>
        <div id="opecom" class="tab-pane fade">
            <h3>Tambien en desarrollo.</h3>
        </div>
    </div>
</div>
