<%-- 
    Document   : tienda
    Created on : 20-ene-2017, 21:43:28
    Author     : thepuar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <h3>Detalle de tienda</h3>
    </div>
    <div class="row">
        <div class="panel panel-default ">
            <div class="panel-heading">
                <h3 class="panel-title"> Tienda - ${tienda.numero} - </h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <p>Número: <strong>${tienda.numero}</strong></p>
                </div>
                <div class="row">
                    <p>Nombre: <strong>${tienda.nombre}</strong></p>
                </div>
                <div class="row">
                    <p>Número de secciones: <strong>${tienda.secciones.size()}</strong></p>
                </div>
            </div>
        </div>
    </div>
</div>