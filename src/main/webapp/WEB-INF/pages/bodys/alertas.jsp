<%-- 
    Document   : alertas
    Created on : 15-abr-2017, 17:53:46
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">

        <h3>Alertas en pedidos</h3>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="pedidosdestacadosmenos" class=" hide glyphicon glyphicon-minus-sign"></span><span id="pedidosdestacadosmas" class="  glyphicon glyphicon-plus-sign"></span> ${pedidosDestacados.size()} Pedidos destacados</h3>
            </div>
            <div class="panel-body" id="pedidosdestacadoscontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Vivo</th>
                            <th>Tipo</th>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Importe</th>
                            <th>Encontrado</th>
                            <th>Entrega</th>
                            <th>Dias restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidosDestacados}" var="pedido">
                            <tr>
                                <td>${pedido.isEnCurso()}</td>
                                <td>${pedido.getTipoPedidoDescr()}</td>
                                <td><a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank">${pedido.proveedor.nombre}</a></td>
                                <td class="text-center"><a href="<c:url value="/upedido/${pedido.id}"/>" target="_blank">${pedido.numeropedido}</a></td>
                                <td class="text-right"><fmt:formatNumber value="${pedido.importe}" type="number" minFractionDigits="2" /> €</td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaencontrado}" pattern="dd/MM/yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy"/></td>
                                <td>${pedido.getDiasRestantes()}</td>
                                <td>
                                    <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>


        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="pedidosrevisarmenos" class="hide glyphicon glyphicon-minus-sign"></span><span id="pedidosrevisarmas" class="  glyphicon glyphicon-plus-sign"></span> ${pedidosNoRevisados.size()} Pedidos por revisar</h3>
            </div>
            <div class="panel-body" id="pedidosrevisarcontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Importe</th>
                            <th>Encontrado</th>
                            <th>Entrega</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidosNoRevisados}" var="pedido">
                            <tr>
                                <td><a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank">${pedido.proveedor.nombre}</a></td>
                                <td class="text-center"><a href="<c:url value="/upedido/${pedido.id}"/>" target="_blank">${pedido.numeropedido}</a></td>
                                <td class="text-right"><fmt:formatNumber value="${pedido.importe}" type="number" minFractionDigits="2" /> €</td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaencontrado}" pattern="dd/MM/yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy"/></td>
                                <td>
                                    <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>


        </div>
    </div>
    <!-- No llegan a Franco -->
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="pedidosfrancomenos" class="hide glyphicon glyphicon-minus-sign"></span><span id="pedidosfrancomas" class="  glyphicon glyphicon-plus-sign"></span> ${pedidosNoLleganAFranco.size()} Pedidos De Cómo no llegan a Franco</h3>
            </div>
            <div class="panel-body" id="pedidosfrancocontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>ImportePc</th>
                            <th>Franco</th>
                            <th>Encontrado</th>
                            <th>Entrega</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidosNoLleganAFranco}" var="pedido">
                            <tr>
                                <td><a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank">${pedido.proveedor.nombre}</a></td>
                                <td class="text-center"><a href="<c:url value="/upedido/${pedido.id}"/>" target="_blank">${pedido.numeropedido}</a></td>
                                <td class="text-right"><fmt:formatNumber value="${pedido.importePC}" type="number" minFractionDigits="2" /> €</td>
                                <td class="text-center"><fmt:formatNumber value="${pedido.proveedor.getFranco()}" type="number" minFractionDigits="2" />€</td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaencontrado}" pattern="dd/MM/yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy"/></td>
                                <td>
                                    <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>


        </div>
    </div>

    <!-- Avisar al entrar-->
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="pedidosavisarmenos" class=" hide glyphicon glyphicon-minus-sign"></span><span id="pedidosavisarmas" class="  glyphicon glyphicon-plus-sign"></span> ${pedidosAvisar.size()} Pedidos para avisar al entrar</h3>
            </div>
            <div class="panel-body" id="pedidosavisarcontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Vivo</th>
                            <th>Tipo</th>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Importe</th>
                            <th>Encontrado</th>
                            <th>Entrega</th>
                            <th>Dias restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidosAvisar}" var="pedido">
                            <tr>
                                <td>${pedido.isEnCurso()}</td>
                                <td>${pedido.getTipoPedidoDescr()}</td>
                                <td><a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank">${pedido.proveedor.nombre}</a></td>
                                <td class="text-center"><a href="<c:url value="/upedido/${pedido.id}"/>" target="_blank">${pedido.numeropedido}</a></td>
                                <td class="text-right"><fmt:formatNumber value="${pedido.importe}" type="number" minFractionDigits="2" /> €</td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaencontrado}" pattern="dd/MM/yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy"/></td>
                                <td>${pedido.getDiasRestantes()}</td>
                                <td>
                                    <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>


        </div>
    </div>

    <!-- Pendientes de anular-->
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="pedidosanularmenos" class=" hide glyphicon glyphicon-minus-sign"></span><span id="pedidosanularmas" class="  glyphicon glyphicon-plus-sign"></span> ${pedidosAnular.size()} Pedidos pendientes de anular (Aun no disponible)</h3>
            </div>
            <div class="panel-body" id="pedidosanularcontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Vivo</th>
                            <th>Tipo</th>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Importe</th>
                            <th>Encontrado</th>
                            <th>Entrega</th>
                            <th>Dias restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidosAnular}" var="pedido">
                            <tr>
                                <td>${pedido.isEnCurso()}</td>
                                <td>${pedido.getTipoPedidoDescr()}</td>
                                <td><a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank">${pedido.proveedor.nombre}</a></td>
                                <td class="text-center"><a href="<c:url value="/upedido/${pedido.id}"/>" target="_blank">${pedido.numeropedido}</a></td>
                                <td class="text-right"><fmt:formatNumber value="${pedido.importe}" type="number" minFractionDigits="2" /> €</td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaencontrado}" pattern="dd/MM/yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy"/></td>
                                <td>${pedido.getDiasRestantes()}</td>
                                <td>
                                    <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>


        </div>
    </div>


    <!-- Pedidos en retraso--> 
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="pedidosenretrasomenos" class="hide glyphicon glyphicon-minus-sign"></span><span id="pedidosenretrasomas" class="  glyphicon glyphicon-plus-sign"></span> ${pedidosEnRetraso.size()} Pedidos en retraso</h3>
            </div>
            <div class="panel-body" id="pedidosenretrasocontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Tipo</th>
                            <th>Proveedor</th>
                            <th>Número</th>
                            <th>Importe</th>
                            <th>Encontrado</th>
                            <th>Entrega</th>
                            <th>Dias restantes</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidosEnRetraso}" var="pedido">
                            <tr>
                                <td>${pedido.getTipoPedidoDescr()}</td>
                                <td><a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank">${pedido.proveedor.nombre}</a></td>
                                <td class="text-center"><a href="<c:url value="/upedido/${pedido.id}"/>" target="_blank">${pedido.numeropedido}</a></td>
                                <td class="text-right"><fmt:formatNumber value="${pedido.importe}" type="number" minFractionDigits="2" /> €</td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaencontrado}" pattern="dd/MM/yyyy" /></td>
                                <td class="text-center"><fmt:formatDate value="${pedido.fechaentregaReal}" pattern="dd/MM/yyyy"/></td>
                                <td>${pedido.getDiasRestantes()}</td>
                                <td>
                                    <a href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>


        </div>
    </div>

    <div class="row">

        <h3>Alertas en Proveedores</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><span id="proveedoressindatosmenos" class="hide glyphicon glyphicon-minus-sign"></span><span id="proveedoressindatosmas" class="  glyphicon glyphicon-plus-sign"></span> ${proveedorNoOk.size()} Proveedores sin datos</h3>
            </div>
            <div class="panel-body" id="proveedoressindatoscontenido" style="display:none;">
                <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Número</th>
                            <th>Nombre</th>
                            <th>Franco</th>
                            <th>Contacto</th>
                            <th>Email de contacto</th>
                            <th>Telefono</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${proveedorNoOk}" var="proveedor">
                            <tr>
                                <td>${proveedor.getNumero()}</td>
                                <td><a href="<c:url value="/uproveedor/${proveedor.id}"/>" target="_blank">${proveedor.nombre}</a></td>
                                <td class="text-center">${proveedor.franco}</td>
                                <td class="text-right">${proveedor.nombreContacto}</td>
                                <td class="text-right">${proveedor.email}</td>
                                <td class="text-center">${proveedor.telefono}</td>
                                <td><a href="<c:url value="/uproveedor/${proveedor.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a>
                                    <a href="<c:url value="/uproveedor/update/${proveedor.id}"/>"><span class="glyphicon glyphicon-refresh"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    <tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">

        <h3>Alertas en Referencias</h3>
    </div>
</div>

