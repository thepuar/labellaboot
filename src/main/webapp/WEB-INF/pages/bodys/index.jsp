<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <c:forEach var="seccion" items="${secciones}">
            <div class="col-md-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">${seccion.getNumero()} - ${seccion.getNombre()}</h3>
                    </div>

                    <div class="panel-body">
                        <c:set var="vivos" value="${seccion.getNumPedidosVivos()}"/>
                        <c:set var="revisados" value="${seccion.getNumPedidosVivosRevisados()}"/>
                        <c:if test="${revisados==0}">
                            <c:set var="revisados" value="${0.00001}"/>
                        </c:if>
                        <fmt:formatNumber var="porcentaje" value="${revisados/vivos}" type = "percent" minFractionDigits="0"/>
                        <c:set var="tipobarra"/>
                        <c:choose>
                            <c:when test = "${revisados/vivos <0.4}"><c:set var="tipobarra" value="progress-bar-danger"/></c:when>
                            <c:when test = "${revisados/vivos >=0.4 && revisados/vivos <0.8 }"><c:set var="tipobarra" value="progress-bar-warning"/></c:when>
                            <c:when test = "${revisados/vivos >=0.8 && revisados/vivos < 1}"><c:set var="tipobarra" value="progress-bar-info"/></c:when>
                            <c:when test = "${revisados/vivos ==1}"><c:set var="tipobarra" value="progress-bar-success"/></c:when>
                        </c:choose>
                        <span>Vivos: ${vivos}</span>
                        <span>Revisados: <fmt:formatNumber minFractionDigits="0" type="number" value="${revisados}"/></span>
                        <div class="progress">

                            <div class="progress-bar <c:out value="${tipobarra}"/> progress-bar-striped active" role="progressbar" aria-valuenow="${revisados}"
                                 aria-valuemin = "0" aria-valuemax="${vivos}" style="width:<c:out value="${porcentaje}"/>">
                                <c:out value="${porcentaje}"/> Revisados</div>

                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Tienda ${tienda.getNumero()} - ${tienda.getNombre()}</h3>
                </div>
                <div class="panel-body">
                    <span>Vivos: ${pedidosVivos}</span>
                    <span>Revisados: ${pedidosRevisados}</span>
                    <c:set var="vivos" value="${pedidosVivos}"/>
                    <c:set var="revisados" value="${pedidosRevisados}"/>
                    <c:if test="${revisados==0}">
                        <c:set var="revisados" value="${0.00001}"/>
                    </c:if>
                    <c:choose>
                        <c:when test = "${revisados/vivos <0.4}"><c:set var="tipobarra" value="progress-bar-danger"/></c:when>
                        <c:when test = "${revisados/vivos >=0.4 && revisados/vivos <0.8 }"><c:set var="tipobarra" value="progress-bar-warning"/></c:when>
                        <c:when test = "${revisados/vivos >=0.8 && revisados/vivos < 1}"><c:set var="tipobarra" value="progress-bar-info"/></c:when>
                        <c:when test = "${revisados/vivos ==1}"><c:set var="tipobarra" value="progress-bar-success"/></c:when>
                    </c:choose>
                    <div class="progress">
                        <fmt:formatNumber var="porcentaje" value="${revisados/vivos}" type = "percent" minFractionDigits="0"/>
                        <div class="progress-bar <c:out value="${tipobarra}"/> progress-bar-striped active" role="progressbar" aria-valuenow="${revisados}"
                             aria-valuemin = "0" aria-valuemax="${vivos}" style="width:<c:out value="${porcentaje}"/>">
                            <c:out value="${porcentaje}"/> Revisados</div>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading text-center">
                    <h3 class="panel-title">Actualizado con LPRE</h3>
                </div>
                <div class="panel-body text-center">
                    </br>
                    <fmt:formatDate var="fecha" value="${tienda.getFechaLPRE()}" type="both" dateStyle = "long"/>
                    <stong><span class="glyphicon glyphicon-calendar"></span> ${fecha}</strong>
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-primary">
                <div class="panel-heading text-center">
                    <h3 class="panel-title">Actualizado con Segmentación</h3>
                </div>
                <div class="panel-body text-center">
                    </br>
                    <fmt:formatDate var="fecha" value="${tienda.getFechaLPRE()}" type="both" dateStyle = "long"/>
                    <stong><span class="glyphicon glyphicon-calendar"></span> ${fecha}</strong>
                </div>
            </div>
        </div>

    </div>
</div>
