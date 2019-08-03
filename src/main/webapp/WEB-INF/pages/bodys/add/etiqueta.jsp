<%-- 
    Document   : addetiqueta
    Created on : 06-feb-2017, 11:54:51
    Author     : thepuar
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Crear etiqueta</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Nueva etiqueta</h3>
            </div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <c:url var="action" value="/etiquetas/add"/>
                    <form:form method="post" action ="${action}" modelAttribute="etiqueta">
                        <div class="form-group">
                            <form:label  path="numSeccion" class="control-label col-xs-3">Número de sección:</form:label>
                                <div class="col-xs-9">
                                    <div class="row">
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="1"/> 1.-Materiales</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="2"/> 2.-Madera</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="3"/> 3.-Electricidad/Fontanería</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="4"/> 4.-Herramientas</div>
                                </div>
                                <div class="row">
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="5"/> 5.-Moqueta</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="6"/> 6.-Cerámica</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="7"/> 7.-Sanitario</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="8"/> 8.-Cocinas</div>
                                </div>
                                <div class="row">
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="9"/> 9.-Jardín</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="10"/> 10.-Ferretería</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="11"/> 11.-Pintura</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="12"/> 12.-Decoración</div>
                                </div>
                                <div class="row">
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="13"/> 13.-Iluminacion</div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="100"/> <strong>Opecom</strong></div>
                                <div class="col-xs-3"><form:radiobutton path="numSeccion" value="101"/> <strong>RM</strong></div>
                                </div>
                                <form:errors path="numSeccion" element="div" cssClass="text-danger"></form:errors>

                            </div>
                        </div>
                        <div class="form-group">
                            <form:label  path="nombreEtiqueta" class="control-label col-xs-3">Descripción</form:label>
                                <div class="col-xs-9">
                                <form:input class="form-control" id="nombreEtiqueta" type="text" path="nombreEtiqueta" placeholder="Introduce el nombre de la etiqueta"/>
                                <form:errors path="nombreEtiqueta" element="div" cssClass="text-danger"></form:errors>
                            </div>
                        </div>

                        <div class="row text-right col-xs-12">
                            <button type="submit" class="  btn btn-primary">Insertar</button><a href="<c:url value="/"/>"  class="btn btn-default">Cancelar</a>
                        </div>


                    </form:form>

                </div>
            </div>
        </div>
    </div>
</div>