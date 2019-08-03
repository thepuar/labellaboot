<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-custom navbar-fixed-top">

        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown active">
                    <a class="navbar-brand dropdown-toggle" data-toggle="dropdown" role="button" href="<c:url value="/tlabella/"/>"><span class="glyphicon glyphicon-globe"></span>LaBella<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/resumen"/>">Resumen</a></li>
                        <li><a href="<c:url value="/tconfig"/>">Configuración</a></li>
                    </ul>
                </li>
                <li>
                  
                    <a href="<c:url value=""/>" title="Alertas" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-fire red"></span>Alertas <span class="badge">25</span></a>
                </li>
                <li>
                    <a href="<c:url value="/tiendas/"/>" title=""><span class="glyphicon glyphicon-home"></span>Tiendas</a>
                </li>
                <li class="dropdown ">
                    <a class="dropdown-toggle" data-toggle="dropdown" role="button" href="<c:url value="/secciones/"/>" title=""><span class="glyphicon glyphicon-file"></span>Secciones<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/secciones/"/>">Todas</a></li>
                        <li><a href="<c:url value="/seccion/1"/>">01 - Materiales</a></li>
                        <li><a href="<c:url value="/seccion/2"/>">02 - Madera</a></li>
                        <li><a href="<c:url value="/seccion/3"/>">03 - Elect.font</a></li>
                        <li><a href="<c:url value="/seccion/4"/>">04 - Herramientas</a></li>
                        <li><a href="<c:url value="/seccion/5"/>">05 - Moqueta</a></li>
                        <li><a href="<c:url value="/seccion/6"/>">06 - Cerámica</a></li>
                        <li><a href="<c:url value="/seccion/7"/>">07 - Sanitario</a></li>
                        <li><a href="<c:url value="/seccion/8"/>">08 - Cocinas</a></li>
                        <li><a href="<c:url value="/seccion/9"/>">09 - Jardín</a></li>
                        <li><a href="<c:url value="/seccion/10"/>">10 - Ferretería</a></li>
                        <li><a href="<c:url value="/seccion/11"/>">11 - Pintura</a></li>
                        <li><a href="<c:url value="/seccion/12"/>">12 - Decoración</a></li>
                        <li><a href="<c:url value="/seccion/13"/>">13 - Iluminación</a></li>
                        
                    </ul>
                </li>

                <li>
                    <a href="<c:url value="/proveedores"/>" title=""><span class="glyphicon glyphicon-tent"></span>Proveedores</a>
                </li>
                <li>
                    <a href="<c:url value="/pedidos/"/>" title=""><span class="glyphicon glyphicon-file"></span>Pedidos</a>
                </li>
                
                <li class="dropdown">
                    <a class="dropdown-toggle" href="<c:url value="/etiquetas/"/>" data-toggle="dropdown" role="button" title=""><span class="glyphicon glyphicon-flag"></span>Etiquetas<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/etiquetas"/>">Ver etiquetas</a></li>
                        <li><a href="<c:url value="/etiquetas/add"/>">Añadir etiqueta</a></li>
                    </ul>
                </li>
                 <li class="dropdown">
                    <a class="dropdown-toggle" href="<c:url value="/usuarios/"/>" data-toggle="dropdown" role="button" title=""><span class="glyphicon glyphicon-user"></span>Usuarios<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value="/usuarios"/>">Ver usuarios</a></li>
                        <li><a href="<c:url value="#"/>">Añadir usuario</a></li>
                    </ul>
                </li>
                <li>
                    <a href="<c:url value="/historico/"/>" title=""><span class="glyphicon glyphicon-list-alt"></span>Historico Mov.</a>
                </li>
                <li>
                    <a href="<c:url value=""/>" title="" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-shopping-cart"></span>Articulos</a>
                </li>
            </ul>
            <ul class="navbar-text pull-right">
                <li><span class="glyphicon glyphicon-user"></span>${usuario.getLdap()}
                    <a href="#" title="Información del usuario" data-toggle="popover" data-placement="left" data-content="${usuario.getNombre()} ${usuario.getApellidos()}">
                        <span class="glyphicon glyphicon-info-sign"></span></a> / <a href="<c:url value="/logout"/>"><span class="glyphicon glyphicon-log-out"></span> </span></a>
                </li>
            </ul>

        </div>
</nav>
                        
                    