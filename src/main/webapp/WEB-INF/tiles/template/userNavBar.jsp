<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">

    <div id="navbar" class="collapse navbar-collapse">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <!--<li class="dropdown active">-->
                <li>
                    <a class="navbar-brand "  href="<c:url value="/uprincipal"/>"><span class="glyphicon glyphicon-globe"></span>LaBella</a>
                    <ul class="dropdown-menu">
                        <!--
                        <li><a href="<c:url value="/resumen"/>">Resumen</a></li>
                        <li><a href="<c:url value="/tconfig"/>">Configuración</a></li>
                        -->
                    </ul>
                </li>
                <li>

                    <a href="<c:url value="/ualertas"/>" title="Alertas" role="button"><span class="glyphicon glyphicon-fire red"></span>Alertas <span class="badge">25</span></a>
                </li>
                <li class="dropdown ">
                    <a  class="dropdown-toggle" data-toggle="dropdown" role="button" href="<c:url value="/secciones/"/>" title=""><span class=" glyphicon glyphicon-file"></span>Mis secciones<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <c:forEach var="seccion" items="${usuario.getSecciones()}">
                            <li><a href='<c:url value="/useccion/${seccion.getId()}"/>'/>${seccion.getNumero()} - ${seccion.getNombre()}</a></li>
                            </c:forEach>
                    </ul>

                </li>

                <li>
                    <a href="<c:url value="/uproveedores"/>" title=""><span class="glyphicon glyphicon-tent"></span>Proveedores</a>
                </li>
                <li>
                    <a href="<c:url value="/upedidos/"/>" title=""><span class="glyphicon glyphicon-file"></span>Pedidos vivos</a>
                </li>

                <li class="dropdown">
                    <a class="dropdown-toggle" href="<c:url value="/etiquetas/"/>" data-toggle="dropdown" role="button" title=""><span class="glyphicon glyphicon-flag"></span>Etiquetas<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/uetiquetas"/>">Ver etiquetas</a></li>
                        <li><a href="<c:url value="/uetiquetas/add"/>">Añadir etiqueta</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-left">
                <c:url var="action" value="/spedido"/>
                <form:form  method="post" action="${action}"  cssClass="navbar-form navbar-right">
                    <div class="form-group">
                        <input type="number" min="100000" max="99999999" id="buscar" name="buscar" class="form-control" placeholder="Pedidos y referencias"/>
                    </div>
                    <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Buscar</button>
                </form:form>
            </ul>

            <ul class="navbar-text pull-right">
                <li><span class="glyphicon glyphicon-user"></span><span>${usuario.getLdap()}</span>
                    <a href="#" title="Información del usuario" data-toggle="popover" data-placement="left" data-content="${usuario.getNombre()} ${usuario.getApellidos()}">
                        <span class="glyphicon glyphicon-info-sign"></span></a> /<a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> </span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

