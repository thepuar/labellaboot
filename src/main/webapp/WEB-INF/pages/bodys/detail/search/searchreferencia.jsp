<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <c:set var="linea" value="${pedidos.get(0).getLineaByReferencia(referencia)}"/>
        <h3>Historico de referencia ${linea.getReferencia()}  ${linea.getDesignacion()}</h3>
    </div>
    
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title"> Pedidos - ${pedidos.size()} </h3>
            </div>
            <div class="panel-body">
                <table class="table table-bordered table-striped">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Tipo</th>
                            <th>En Curso</th>
                            <th>Pedido</th>
                            <th>Uds</th>
                            <th>Fecha entrega</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pedidos}" var="pedido">
                            <tr>
                                <td>${pedido.getTipoPedidoDescr()}</td>
                                <td>${pedido.enCurso}</td>
                                <td><a href="<c:url value="/upedido/${pedido.id}"/>">${pedido.numeropedido}</a></td>
                                <td>${pedido.getLineaByReferencia(referencia).encurso}</td>
                                <fmt:formatDate var = "fecha" value="${pedido.getFechaentregaReal()}" type="date" pattern="dd-MM-yyyy"/>
                                <td>${fecha}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
