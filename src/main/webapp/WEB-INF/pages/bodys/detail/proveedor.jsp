<%-- 
    Document   : proveedor
    Created on : 23-ene-2017, 20:00:15
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Resumen del proveedor</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading" >
                <div class="row">
                    <div class="col-md-11">
                        <h3 class="panel-title "> Proveedor - ${proveedor.numero} - ${proveedor.nombre} </h3>
                    </div>
                    <div class="col-md-1 text-right ">
                        <c:if test="${usuario.isAdmin()}">
                            <a class="btn btn-warning btn-xs" href="<c:url value="/proveedor/update/${proveedor.id}"/>" role="button">Actualizar</a>
                        </c:if>
                        <c:if test="${!usuario.isAdmin()}">
                            <a class="btn btn-warning btn-xs" href="<c:url value="/uproveedor/update/${proveedor.id}"/>" role="button">Actualizar</a>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="panel panel-body ">
                <div class="col-md-4">
                    <div class=" panel panel-default ">
                        <div class="panel-heading">
                            <strong>Detalle</strong>
                        </div>
                        <div class="panel-body">
                            <p>Número sección: <strong>${proveedor.numSeccion}</strong></p>
                            <p>Franco: <strong>${proveedor.franco}</strong></p>
                            <p>Transito: <strong>${proveedor.esTransito}</strong></p>
                            <p>Esta en reapro: <strong>Que dias?</strong></p>
                            <p>Importe medio por palet: <strong><fmt:formatNumber value="${proveedor.importeMedioPalet}" maxFractionDigits="2" groupingUsed="false"/> €</strong></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class=" panel panel-default ">
                        <div class="panel-heading">
                            <strong>Contacto</strong>
                        </div>
                        <div class="panel-body">
                            <p><span class="glyphicon glyphicon-user"></span> Persona de contacto: <strong>${proveedor.nombreContacto}</strong></p>
                            <p><span class="glyphicon glyphicon-phone"></span> Telefono: <strong>${proveedor.telefono}</strong></p>
                            <p><span class="glyphicon glyphicon-envelope"></span> Email: <strong>${proveedor.email}</strong></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class=" panel panel-default ">
                        <div class="panel-heading">
                            <strong>Pedidos</strong>
                        </div>
                        <div class="panel-body">
                            <p>Número de pedidos: <strong>${proveedor.pedidos.size()}</strong></p>
                            <p>Pedidos sin revisar: <strong>${proveedor.getNumPedidosSinRevisar()}</strong></p>
                            <p>Pedidos en retraso: <strong>${proveedor.getNumPedidosEnRetraso()}</strong></p>
                            <p>Importe de pedidos: <strong><fmt:formatNumber value="${proveedor.getValorEnCamino()}" maxFractionDigits="2" groupingUsed="false"/>€</strong></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <!-- Codigo para pedidos-->
    <c:forEach items="${proveedor.pedidos}" var="pedido">
        <div class="row">
            <c:if test="${pedido.isRetraso()}">
                <div class="panel panel-danger">
                </c:if>
                <c:if test="${!pedido.isRetraso()}">
                    <div class="panel panel-default">
                    </c:if>
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-md-6">
                                <fmt:formatDate value="${pedido.fechaentregaReal}" var ="fechaentrega" type="date" pattern="dd-MM-yyyy"/>
                                <c:if test="${usuario.isAdmin()}">
                                    <h3 class="panel-title"> Pedido - <a href="<c:url value="/pedido/${pedido.id}"/>">${pedido.numeropedido}</a> - Fecha de entrega: ${fechaentrega}</h3>
                                </c:if>
                                <c:if test="${!usuario.isAdmin()}">
                                    <h3 class="panel-title"> Pedido - <a href="<c:url value="/upedido/${pedido.id}"/>">${pedido.numeropedido}</a> - Fecha de entrega: ${fechaentrega}</h3>
                                </c:if>
                            </div>
                            <div class="col-md-6 text-right ">
                                <c:if test="${usuario.isAdmin()}">
                                    <a class="btn btn-warning btn-xs" href="<c:url value="/pedido/update/${pedido.id}"/>" role="button">Actualizar</a>
                                </c:if>
                                <c:if test="${!usuario.isAdmin()}">
                                    <a class="btn btn-warning btn-xs" href="<c:url value="/upedido/update/${pedido.id}"/>" role="button">Actualizar</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">

                        <div class="panel panel-default ">

                            <ul class="nav nav-tabs nav-justified">
                                <li class="active"><a data-toggle="tab" href="#detalle${pedido.id}"><strong>Detalle</strong></a></li>
                                <li><a data-toggle="tab" href="#alertas${pedido.id}"><strong>Alertas</strong></a></li>
                                <li><a data-toggle="tab" href="#historico${pedido.id}"><strong>Historico</strong></a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="panel-body tab-pane fade in active" id="detalle${pedido.id}">
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class=""><p>Revisado: <strong>${pedido.revisado}</strong></p></div>
                                            <div class=""><p>Tipo pedido: <strong>${pedido.getTipoPedidoDescr()}</strong></p></div>
                                            <div class=""><p>Número de palets: <strong>${pedido.numPalets}</strong></p></div>
                                            <div class=""><p>Entrega en tienda: <strong>${pedido.entregaEnTienda}</strong></p></div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class=""><p>Avisar al entrar: <strong>${pedido.avisarAlLlegar}</strong></p></div>
                                            <fmt:formatDate value="${pedido.fechaencontrado}" var ="fechaencontrado" type="date" pattern="dd-MM-yyyy"/>
                                            <div class=""><p>Fecha encontrado: <strong>${fechaencontrado}</strong></p></div>

                                            <fmt:formatDate value="${pedido.fechaentrega}" var ="fechaentrega" type="date" pattern="dd-MM-yyyy"/>
                                            <div class=""><p>Fecha de entrega: <strong>${fechaentrega}</strong></p></div>
                                            <fmt:formatDate value="${pedido.fechaentregaReal}" var ="fechaentregaReal" type="date" pattern="dd-MM-yyyy"/>
                                            <div class=""><p>Fecha de entrega real: <strong>${fechaentregaReal}</strong></p></div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class=""><p>Número referencias: <strong>${pedido.getLineas().size()}</strong></p></div>
                                            <div class=""><p>Número unidades <strong>${pedido.getUds()}</strong></p></div>
                                            <div class=""><p>Valor PC/PVP <strong>${pedido.getImportePC()} € / ${pedido.getImporte()} €</strong></p></div>
                                            <div class=""><p>Etiqueta: <strong>${pedido.getEtiquetaString()}</strong></p></div>
                                        </div>
                                    </div>
                                            <c:if test="${pedido.getObservacion()!=null}">
                                    <div class="row">
                                        <div class="col-md-12">

                                            <div class="form-group">
                                                <label for="comment">Observaciones:</label>
                                                <textarea class="form-control" readonly>${pedido.getObservacion()}</textarea>
                                            </div>
                                        </div>

                                    </div>
                                            </c:if>
                                </div>
                                <div class="panel-body tab-pane fade " id="alertas${pedido.id}">

                                </div>
                                <div class="panel-body tab-pane fade " id="historico${pedido.id}">
                                    <table class="table table-bordered table-striped">
                                        <thead class="thead-inverse">
                                            <tr>
                                                <th>Fecha</th>
                                                <th>Usuario</th>
                                                <th>Descripción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${pedido.getHistorico()}" var="historico">
                                                <tr>
                                                    <td><fmt:formatDate value="${historico.fecha}" type="date" pattern="dd-MM-yyyy HH:mm"/></td>
                                                    <td>${historico.idUser}</td>
                                                    <td>${historico.descripcion}</td>
                                                </tr>
                                            </c:forEach>

                                        </tbody>
                                    </table>

                                </div>
                            </div>


                        </div>
                        <table class="table table-bordered table-striped">
                            <thead class="thead-inverse">
                                <tr>
                                    <th>ID</th>
                                    <th>Referencia</th>
                                    <th>Designacion</th>
                                    <th>Pvp</th>
                                    <th>En Curso</th>
                                    <th>Valor</th>
                                    <th>Top</th>
                                    <th>Gama</th>
                                    <th>20/80</th>
                                    <th>PP</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${pedido.lineas}" var="linea">
                                    <tr>
                                        <td>${linea.id}</td>
                                        <td>${linea.referencia}</td>
                                        <td>${linea.designacion}</td>
                                        <td>${linea.pvp}</td>
                                        <td>${linea.encurso}</td>
                                        <td><fmt:formatNumber pattern="0.00" value="${linea.getValorLinea()}"/>€</td>
                                        <td>${linea.top}</td>
                                        <td>${linea.gama}</td>
                                        <td>${linea.irrenunciable}</td>
                                        <td>${linea.primerprecio}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
