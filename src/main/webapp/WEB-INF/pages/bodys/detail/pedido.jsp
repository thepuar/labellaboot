<%-- 
    Document   : pedido
    Created on : 23-ene-2017, 20:10:53
    Author     : thepuar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Detalle del pedido</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-3">
                       
                        <h3 class="panel-title"> Pedido - ${pedido.numeropedido}</h3>
                    </div>
                    <div class="col-md-9 text-right">
                        <c:if test="${usuario.isAdmin()}">
                            <a class="btn btn-warning btn-xs" href="<c:url value="/pedido/update/${pedido.id}"/>" target="_blank" role="button">Actualizar</a>
                        </c:if>
                        <c:if test="${!usuario.isAdmin()}">
                            <a class="btn btn-warning btn-xs" href="<c:url value="/upedido/update/${pedido.id}"/>" target="_blank"role="button">Actualizar</a>
                        </c:if>
                    </div>
                </div>

            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <div class="panel-heading"><strong>Detalle</strong></div>
                            <div class="panel-body">
                                <fmt:formatDate var="fechaencontrado" value="${pedido.fechaencontrado}" type="date" pattern="dd-MM-yyyy"/> 
                                <p>Fecha encontrado: <strong>${fechaencontrado}</strong></p>
                                <fmt:formatDate var="fechareal" value="${pedido.fechaentregaReal}" type="date" pattern="dd-MM-yyyy"/> 
                                <p>Fecha entrega real: <strong>${fechareal}</strong></p>
                                <p>Dias restantes: <strong>${pedido.getDiasRestantes()}</strong></p>
                                <p>Unidades: <strong>${pedido.uds}</strong></p>
                                <p>Importe PC/PVP: <strong>${pedido.importePC} € /${pedido.importe} €</strong></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <div class="panel-heading"><strong>Proveedor</strong></div>
                            <div class="panel-body">
                                <p>Número: <strong>${pedido.proveedor.numero}</strong></p>
                                <p>Nombre: <a href="<c:url value="/uproveedor/${pedido.proveedor.id}"/>" target="_blank"><strong>${pedido.proveedor.nombre}</strong></a></p>
                                <p><span class="glyphicon glyphicon-user"></span> Contacto: <strong>${pedido.proveedor.nombreContacto}</strong></p>
                                <p><span class="glyphicon glyphicon-phone"></span> Teléfono: <strong>${pedido.proveedor.telefono}</strong></p>
                                <p>
                                    <c:if test="${pedido.proveedor.nombreContacto.length()>1}">
                                        <a href="https://mail.google.com/mail/?view=cm&fs=1&to=${pedido.proveedor.email}&su=PEDIDO ${pedido.numeropedido}&body=Buenos dias ${pedido.proveedor.nombreContacto}" target="_blank">
                                        </c:if>
                                        <span class="glyphicon glyphicon-envelope"></span>
                                    </a>
                                    Email: <strong>${pedido.proveedor.email}</strong></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="panel panel-default">
                            <div class="panel-heading"><strong>Estados
                                 <c:if test="${pedido.isEnCurso()}">
                                - En Curso
                            </c:if>
                                <c:if test="${!pedido.isEnCurso()}">
                                - No En Curso
                            </c:if>
                                </strong></div>
                            <div class="panel-body">
                                <p>Revisado: <strong>${pedido.revisado}</strong></p>
                                <p>Tipo:<strong>
                                        ${pedido.getTipoPedidoDescr()}
                                        <c:choose>
                                            <c:when test="${pedido.tipoPedido == 1}">
                                                - ${pedido.numPC}
                                            </c:when>
                                            <c:when test="${pedido.tipoPedido != 1}">
                                                <c:if test="${pedido.getEtiquetaString()!=null}">
                                                    - ${pedido.getEtiquetaString()}
                                                </c:if>
                                            </c:when>
                                        </c:choose>
                                    </strong></p>
                                <p>Destacado: <strong>${pedido.destacado}</strong></p>
                                <p>Avisar al llegar: <strong>${pedido.avisarAlLlegar}</strong></p>
                                <p>Esperando anular: <strong>${pedido.pendienteAnular}</strong></p>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <div class="panel panel-default">
                        <div class="panel-heading"><strong>Emails a proveedor sobre pedidos en curso <em class="text-danger">(beta)</em></strong></div>
                        <div class="panel-body <c:if test="${pedido.proveedor.IsPossibleSendEmail() ==false }" > hide</c:if> ">
                                <div class="row">
                                    <div class="col-md-2"><a class="btn btn-success" target="_blank" href=${mailProv.getRevisionProveedorLink()}><span class="glyphicon glyphicon-envelope"></span> Confirmar pedido</a></div>
                                    <div class="col-md-2"><a class="btn btn-warning" target="_blank"  href=${mailProv.getReclamarRetrasoLink()}><span class="glyphicon glyphicon-envelope"></span> Reclamar retraso</a></div>
                                    <div class="col-md-2"><a class="btn btn-info" target="_blank"  href=${mailProv.getSolicitudAdelantarPedidoLink()}><span class="glyphicon glyphicon-envelope"></span> Adelantar pedido</a></div>
                                    <div class="col-md-2"><a class="btn btn-info" target="_blank" href=${mailProv.getConfirmacionAdelantarPedidoLink()}><span class="glyphicon glyphicon-envelope"></span> Conf. nueva fecha</a></div>
                                    <div class="col-md-2"><a class="btn btn-danger" target="_blank"  href=${mailProv.getAnulacionPProvNuevoLink()}><span class="glyphicon glyphicon-envelope"></span> Anulacion nuevo</a></div>
                                    <div class="col-md-2"><a class="btn btn-danger" target="_blank"  href=${mailProv.getAnulacionPProvTelefonoLink()}><span class="glyphicon glyphicon-envelope"></span> Conf. anulación</a></div>
                                    <c:if test="${!pedido.isEntregaEnTienda()}">
                                     
                                    <div class="col-md-2"><a class="btn btn-warning" target="_blank"  href=${mailProv.getReclamarConformeEntregaLink()}><span class="glyphicon glyphicon-envelope"></span> Conforme entreg.</a></div>
                                    <div class="col-md-4"><a class="btn btn-info" target="_blank"  href=${mailProv.getFechaInstalacionLink()}><span class="glyphicon glyphicon-envelope"></span> Consultar a insta</a></div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    
                    
                    <div class="panel panel-default ">
                        <div class="panel-heading"><strong>Observaciones</strong></div>
                        
                            <div class="panel-body <c:if test="${pedido.observacion == null}">hide</c:if>  ">
                        
                                
                            <div class="">
                                <pre class="pre-scrollable">${pedido.observacion}</pre>
                            </div>
                            
                    </div>   
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
                                <td><fmt:formatNumber type="number" maxFractionDigits="2"  value="${linea.getValorLinea()}"/>€</td>
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
