<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Información de la sección</h3>        
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                <div class="col-md-3">
                    <h3 class="panel-title">Detalle</h3>
                </div>
                <div class="col-md-9 text-right">
                    <a class="btn btn-warning btn-xs" href="<c:url value="/useccion/update/${seccion.id}"/>" target="_blank" role="button">Actualizar</a>
                </div>
                </div>
            </div>
            <div class="panel-body">
                <p>Tienda: ${seccion.tienda.nombre}</p>
                <p>Nombre: ${seccion.nombre}</p>
                <p>Email: ${seccion.email}</p>
            </div>
        </div>
    </div>
</div>
