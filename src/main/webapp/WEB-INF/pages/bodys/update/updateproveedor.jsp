<%-- 
    Document   : proveedor
    Created on : 26-ene-2017, 20:24:03
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Actualizar proveedor</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Proveedor - ${proveedorInfo.numero} - ${proveedorInfo.nombre}</h3>
            </div>
            <div class="panel-body">

                <div class="form-horizontal">
                    <fieldset disabled>
                        <div class="form-group">
                            <label class="control-label col-xs-3 ">Número de sección:</label>
                            <div class="col-xs-9">
                                <input class="form-control" id="numseccion"  placeholder="${proveedorInfo.numSeccion}"/>
                            </div>
                        </div>
                    </fieldset>
                    <c:if test="${usuario.isAdmin()}">
                        <c:url var="action" value="/proveedor/update/${proveedorInfo.id}"/>
                    </c:if>
                            <c:if test="${!usuario.isAdmin()}">
                        <c:url var="action" value="/uproveedor/update/${proveedorInfo.id}"/>
                    </c:if>
                    <form:form method="post" action="${action}" modelAttribute="proveedor">

                        <div class="form-group">
                            <form:label class="control-label col-xs-3 " path="franco">Franco:</form:label>
                                <div class="col-xs-3">
                                <form:input class="form-control" id="franco" type="number" path="franco" placeholder="Introduce el franco de la sección"/>
                                <form:errors path="franco" element="div" cssClass="text-danger"></form:errors>
                                </div>
                            <form:label class="control-label col-xs-3" path="importeMedioPalet">Importe Medio por palet:</form:label>
                                <div class="col-xs-3">
                                <form:input cssClass="form-control" id="importeMedioPalet" type="number" path="importeMedioPalet" placeholder="Introduce el importe medio del palet."/>
                            </div>  

                        </div>
                        <div class="form-group">
                            <form:label class="control-label col-xs-3 " path="estaEnReapro">En reapro:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton  path="estaEnReapro" value="true"/><span> Si</span>
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton  path="estaEnReapro" value="false"/><span> No</span>
                            </div>
                            <form:errors path="estaEnReapro" element="div" cssClass="text-danger"></form:errors>


                            <form:label class="control-label col-xs-3 " path="esTransito">Transito:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton  path="esTransito" value="true"/><span> Si</span>
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton  path="esTransito" value="false"/><span> No</span>
                            </div>
                            <form:errors path="esTransito" element="div" cssClass="text-danger"></form:errors>
                            </div>
                            <div class="form-group">
                            <form:label class="control-label col-xs-3 " path="nombreContacto">Contacto</form:label>
                                <div class="col-xs-9">
                                <form:input class="form-control" id="nombreContacto" type="text" path="nombreContacto" placeholder="Introduce el nombre de la persona de contacto."/>
                                <form:errors path="nombreContacto" element="div" cssClass="text-danger"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">
                            <form:label class="control-label col-xs-3 " path="email">Email</form:label>
                                <div class="col-xs-9">
                                <form:input class="form-control" id="email" type="text" path="email" placeholder="Introduce el email del contacto."/>
                                <form:errors path="email" element="div" cssClass="text-danger"></form:errors>
                                </div>
                            </div>
                            <div class="form-group">
                            <form:label class="control-label col-xs-3" path="telefono">Teléfono</form:label>
                                <div class="col-xs-9">
                                <form:input class="form-control" id="telefono" type="text" path="telefono" placeholder="Introduce el telefono de la persona de contacto."/>
                                <form:errors path="telefono" element="div" cssClass="text-danger"></form:errors>
                                </div>
                            </div>

                            <div class="form-group">

                            </div>

                            <div class="row text-right col-xs-12">
                                <button type="submit" class="  btn btn-primary">Actualizar</button>
                            <c:if test="${usuario.isAdmin()}">
                                <a href="<c:url value="/proveedor/${proveedorInfo.id}"/>"  class="btn btn-default">Cancelar</a>
                            </c:if>
                                <c:if test="${!usuario.isAdmin()}">
                                <a href="<c:url value="/uproveedor/${proveedorInfo.id}"/>"  class="btn btn-default">Cancelar</a>
                            </c:if>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

    </div>
</div>

