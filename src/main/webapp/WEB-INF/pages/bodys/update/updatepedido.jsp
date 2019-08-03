<%-- 
    Document   : updatepedido
    Created on : 07-feb-2017, 13:33:47
    Author     : thepuar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Actualizar pedido</h3>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Pedido - ${pedido.numeropedido} - ${pedido.proveedor.nombre} </h3>
            </div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <c:if test="${usuario.isAdmin()}">
                        <c:url var="action" value="/pedido/update/${pedido.id}"/>
                    </c:if>
                    <c:if test="${!usuario.isAdmin()}">
                        <c:url var="action" value="/upedido/update/${pedido.id}"/>
                    </c:if>
                    <form:form method="post" action="${action}" modelAttribute="pedido">

                        <!-- Linea 1 -->
                        <div class="form-group">
                            <form:label class="control-label col-xs-3" path="revisado">Revisado:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton path="revisado" value="true"/><span> Si</span> 
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton path="revisado" value="false"/><span> No</span> 
                            </div>
                            <form:label class="control-label col-xs-3" path="destacado">Destacar pedido:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton path="destacado"  value="true"/><span> Si</span> 
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton path="destacado"  value="false"/><span> No</span> 
                            </div>

                        </div>

                        <!-- Linea 2 -->
                        <div class="form-group">
                            <form:label class="control-label col-xs-3" path="enCurso">Pedido en curso:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton path="enCurso"  value="true"/><span> Si</span> 
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton path="enCurso"  value="false"/><span> No</span> 
                            </div>
                            <form:label class="control-label col-xs-3" path="pendienteAnular">Pendiente de anular:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton path="pendienteAnular"  value="true"/><span> Si</span> 
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton path="pendienteAnular"  value="false"/><span> No</span> 
                            </div>
                        </div>

                        <!-- Linea 3 -->
                        <div class="form-group">

                            <fmt:formatDate value="${pedido.fechaentrega}" var ="lafecha" type="date" pattern="dd/MM/yyyy"/>
                            <form:label class="control-label col-xs-3" path="fechaentrega">Fecha de entrega:</form:label>

                                <div class="col-xs-3">
                                    <input class="form-control" id="fechaentrega" type="text" placeholder="${lafecha}" readonly/>
                            </div>
                            <form:label class="control-label col-xs-3" path="fechaentregaReal">Fecha entrega real:</form:label>
                                <div class="col-xs-3">
                                <fmt:formatDate value="${pedido.fechaentregaReal}" var ="lafechaReal" type="date" pattern="dd/MM/yyyy"/>
                                <div class="input-group input-append date" id="fecha" >
                                    <form:input class="form-control"  value="${lafechaReal}" type="text" path="fechaentregaReal" placeholder="Introduce la fecha real de entrega"/>
                                    <span class="input-group-addon add-on">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <!-- Linea 4 Avisar al entrar -->
                        <div class="form-group" >
                            <form:label class="control-label col-xs-3" path="avisarAlLlegar">Avisar al entrar:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton path="avisarAlLlegar"  value="true"/><span> Si</span> 
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton path="avisarAlLlegar"  value="false"/><span> No</span> 
                            </div>
                            <form:label class="control-label col-xs-3" path="numPalets">Número de palets:</form:label>
                                <div class="col-xs-3">
                                <form:input class="form-control" id="numPalets" type="number" path="numPalets" placeholder="Introduce el número de palets."/>
                            </div>

                        </div>


                        <!-- Linea 5 -->

                        <div class="form-group">
                            <form:label path="tipoPedido" class="control-label col-xs-3">Tipo de pedido:</form:label>
                            <div class="col-xs-2"><form:radiobutton path="tipoPedido"  value="0" /> Tienda</div>
                            <div class="col-xs-2"><form:radiobutton path="tipoPedido" value="1" /> Pedido cliente</div>
                            <div class="col-xs-2"><form:radiobutton path="tipoPedido"  value="2" /> Opecom</div>
                            <div class="col-xs-2"><form:radiobutton path="tipoPedido"  value="3" /> RM</div>
                        </div>
                        <c:set var="ocultar" value="style=display:none "/>
                        <c:set var="tipopedido" value="${pedido.tipoPedido}"/>

                        <!-- Linea 6 Tienda -->
                        <div class="form-group" id="updatePedidoTienda" <c:if test="${tipopedido!=0}"><c:out value="${ocultar}"/></c:if>>
                                <div class="col-md-6"></div>

                                <label class="control-label col-xs-3">Etiqueta Sección:</label>
                                <div class="col-xs-3 ">
                                <form:select path="etiquetaId"  cssClass="form-control" >
                                    <form:options items="${selectSeccion}" itemValue="id" itemLabel="nombreEtiqueta"/>
                                </form:select >
                            </div>
                        </div>

                        <!-- Linea 6 Pedido cliente -->
                        <div class="form-group" id="updatePedidoPC" <c:if test="${tipopedido!=1}"><c:out value="${ocultar}"/></c:if>>
                            <form:label class="control-label col-xs-3" path="entregaEnTienda">Entrega en tienda:</form:label>
                                <div class="col-xs-2">
                                <form:radiobutton path="entregaEnTienda" value="true"/><span> Si</span> 
                            </div>
                            <div class="col-xs-1">
                                <form:radiobutton path="entregaEnTienda" value="false"/><span> No</span> 
                            </div>
                            <form:label class="control-label col-xs-3" path="numPC">Número de Pedido cliente:</form:label>
                                <div class="col-xs-3">
                                <form:input class="form-control" id="numPC" type="number" path="numPC" placeholder="Introduce el número de pedido cliente."/>
                            </div>
                        </div>

                        <!-- Linea 7 Opecom -->
                        <div class="form-group" id="updatePedidoOpecom" <c:if test="${tipopedido!=2}"><c:out value="${ocultar}"/></c:if>>
                                <div class="col-md-6"></div>
                                <label class="control-label col-xs-3">Etiqueta Opecom:</label>
                                <div class="col-xs-3 ">
                                <form:select path="etiquetaIdOpecom" cssClass="form-control" >
                                    <form:options items="${selectOpecom}" itemValue="id" itemLabel="nombreEtiqueta"/>
                                </form:select>

                            </div>
                        </div>

                        <!-- Linea 8 RM -->
                        <div class="form-group" id="updatePedidoRM" <c:if test="${tipopedido!=3}"><c:out value="${ocultar}"/></c:if>>
                                <div class="col-md-6"></div>
                                <label class="control-label col-xs-3">Etiqueta RM</label>
                                <div class="col-xs-3 ">
                                <form:select path="etiquetaIdRM" cssClass="form-control" >
                                    <form:options items="${selectRM}" itemValue="id" itemLabel="nombreEtiqueta"/>
                                </form:select>
                            </div>
                        </div>



                        <!-- Linea 9 -->
                        <div class="form-group">
                            <form:label class="control-label col-xs-3" path="observacion">Observación:</form:label>
                                <div class="col-xs-9">
                                <form:textarea rows="5" class="form-control" id="observacion" path="observacion" placeholder="Observaciones / Comentarios" disabled="true"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label class="control-label col-xs-3" path="nuevoComentario">Nueva observación: </form:label>
                                <div class="col-xs-9">
                                <form:textarea rows="2" class="form-control" id="nuevoComentario" path="nuevoComentario" placeholder="Introduce alguna observación." />
                            </div>
                        </div>
                        <div class="row text-right col-xs-12">
                            
                            <button type="submit" class="  btn btn-primary">Revisado</button>
                            <c:if test="${usuario.isAdmin()}">
                                <a href="<c:url value="/pedido/${pedido.id}"/>"  class="btn btn-default">Cancelar</a>
                            </c:if>
                            <c:if test="${!usuario.isAdmin()}">
                                <a href="<c:url value="/upedido/${pedido.id}"/>"  class="btn btn-default">Cancelar</a>
                            </c:if>
                        </div>

                    </form:form>
                </div>

            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title"> Lineas - ${pedido.lineas.size()} </h3>
            </div>
            <div class="panel-body">
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
                                <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${linea.getValorLinea()}"/>€</td>
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
</div>
</div>
