<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Actualizar la sección</h3>        
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-3">
                        <h3 class="panel-title">Detalle</h3>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <p>Tienda: ${seccionInfo.tienda.nombre}</p>
                <p>Nombre: ${seccionInfo.nombre}</p>
                <c:url var="action" value="/useccion/update/${seccion.id}"/>

                <form:form method="post" action="${action}" modelAttribute="seccion">
                    <div class="form-group">
                        <form:label class="control-label" path="email">Email:</form:label>
                        <form:input class="form-control" id="email" type="text" path="email" placeholder="Introduce un email"/>
                        <form:errors path="email" element="div" cssClass="text-danger"></form:errors>

                    </div>
                    <div class="text-right row col-xs-12">
                        <button type="submit" class="btn btn-primary">Actualizar</button>
                    </div>
                </form:form>

            </div>
        </div>
    </div>
</div>
