<%-- 
    Document   : seccion
    Created on : 23-ene-2017, 19:49:51
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3><a href="<c:url value="/useccion/info/${seccion.id}"/>"><span class="glyphicon glyphicon-info-sign"></span></a> Detalle de la sección </h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title"> Seccion - ${seccion.numero} - ${seccion.nombre}</h3>
            </div>
            <div class="panel-body">
                <!-- Datos para grafico de revisados-->
                <input type="hidden"  id="numRevisados" value="${numRevisados}"/>
                <input type="hidden"  id="numNoRevisados" value="${numNoRevisados}"/>
                <input type="hidden"  id="porcRevisados" value="${porcRevisados}"/>
                <input type="hidden"  id="porcNoRevisados" value="${porcNoRevisados}"/>
                <!-- Datos para grafico de tipo de pedidos-->
                <input type="hidden"  id="numPedTienda" value="${numPedTienda}"/>
                <input type="hidden"  id="numPedPC" value="${numPedPC}"/>
                <input type="hidden"  id="numPedOpecom" value="${numPedOpecom}"/>
                <input type="hidden"  id="numPedRM" value="${numPedRM}"/>
                <input type="hidden"  id="porcTienda" value="${porcTienda}"/>
                <input type="hidden"  id="porcPC" value="${porcPC}"/>
                <input type="hidden"  id="porcOpecom" value="${porcOpecom}"/>
                <input type="hidden"  id="porcRM" value="${porcRM}"/>
                <div id="chartRevisados" class="chartRevisados left" style="height:300px; width: 50%">
                </div>
                <div id="chartTipoPedidos" class="chartTipoPedidos right" style="height:300px; width: 50%">
                </div>

            </div>
        </div>
    </div>
    <div clas="row"><!-- Aqui estaban los tabs de los graficos-->
        <ul class="nav nav-tabs nav-justified">
            <li  class="active"><a data-tab="1" data-toggle="tab" href="#entregas">Numero de pedidos</a></li>
            <li id="tab_numpalets_seccion"class="tab_actualizable"><a data-tab="2" data-toggle="tab" href="#palets">Nº Palets</a></li>
            <li id="tab_unidades_seccion"class="tab_actualizable"><a data-tab="3" data-toggle="tab" href="#unidades">Unidades</a></li>
            <li id="tab_importe_seccion"class="tab_actualizable"><a data-tab="4" data-toggle="tab" href="#importe">Importe</a></li>
        </ul>

        <div class="tab-content">
            <div id="entregas" data-content="1" class="tab-pane fade in active">
                </br>
                <!-- Datos para la Grafica de planning de pedidos -->
                <c:forEach items="${pedidosxdia}" var="numpedidos" varStatus="loop">
                    <c:set var="ruta" value="numpedidos${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpedidos}">
                </c:forEach>
                <c:forEach items="${pedidosxdiasitienda}" var="numpedidos" varStatus="loop">
                    <c:set var="ruta" value="numpedidossitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpedidos}">
                </c:forEach>
                <c:forEach items="${pedidosxdianotienda}" var="numpedidos" varStatus="loop">
                    <c:set var="ruta" value="numpedidosnotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpedidos}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div class="chartpedidosxdia" style="height: 300px; width: 100%">
                </div>
            </div>
            <div id="palets" data-content="2" class="tab-pane fade">
                </br>
                <!-- Datos para la Grafica de numero de palets -->
                <c:forEach items="${paletsxdia}" var="numpalets" varStatus="loop">
                    <c:set var="ruta" value="numpalets${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpalets}">
                </c:forEach>
                <c:forEach items="${paletsxdiasitienda}" var="numpalets" varStatus="loop">
                    <c:set var="ruta" value="numpaletssitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpalets}">
                </c:forEach>
                <c:forEach items="${paletsxdianotienda}" var="numpalets" varStatus="loop">
                    <c:set var="ruta" value="numpaletsnotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpalets}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div id="chartpaletsxdia" class="chartpaletsxdia " style="height: 300px; width: 100%">
                </div>
            </div>
            <div id="unidades" data-content="3" class="tab-pane fade ">
                Para la grafica de unidades por tienda
                </br>
                <!-- Datos para la Grafica de numero de unidades -->
                <c:forEach items="${unidadesxdia}" var="numunidades" varStatus="loop">
                    <c:set var="ruta" value="numunidades${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numunidades}">
                </c:forEach>
                <c:forEach items="${unidadesxdiasitienda}" var="numunidades" varStatus="loop">
                    <c:set var="ruta" value="numunidadessitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numunidades}">
                </c:forEach>
                <c:forEach items="${unidadesxdianotienda}" var="numunidades" varStatus="loop">
                    <c:set var="ruta" value="numunidadesnotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numunidades}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div id="chartunidadesxdia" class="chartunidadesxdia " style="height: 300px; width: 100%">
                </div>
            </div>
            <div id="importe" data-content="4" class="tab-pane fade ">
                Para la grafica de importe a tienda
                </br>
                <!-- Datos para la Grafica de importe -->
                <c:forEach items="${importexdia}" var="numimporte" varStatus="loop">
                    <c:set var="ruta" value="numimporte${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numimporte}">
                </c:forEach>
                <c:forEach items="${importexdiasitienda}" var="numimporte" varStatus="loop">
                    <c:set var="ruta" value="numimportesitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numimporte}">
                </c:forEach>
                <c:forEach items="${importexdianotienda}" var="numimporte" varStatus="loop">
                    <c:set var="ruta" value="numimportenotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numimporte}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div id="chartimportexdia" class="chartimportexdia " style="height: 300px; width: 100%">
                </div>
            </div>

        </div>
    </div>
    </br>

    <div class="row" >
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"> Resumen</h3>
            </div>
            <div id="datos_seccion" class="panel-body">
                <table>
                    <thead></thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>

</div>