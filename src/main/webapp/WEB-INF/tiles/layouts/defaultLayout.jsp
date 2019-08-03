<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

    <head>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico" type="image/x-icon">
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >-->

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title><tiles:getAsString name="title" /></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script> 
        <script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script> 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/locale/es.js"></script> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css" >
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <!-- Include Bootstrap Datepicker -->
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>

        <script src="<c:url value="/resources/js/columnChartCanvas.js"/>"></script>
        <script src="<c:url value="/resources/js/jquery.canvasjs.min.js"/>"></script>
        <script src="<c:url value="/resources/js/ordertable.js"/>"></script>
        <script src="<c:url value="/resources/ajax/AjaxPedidos.js"/>"></script>
        <link href="<c:url value="/resources/css/login.css"/>" rel ="stylesheet">
        <link href="<c:url value="/resources/css/main.css"/>" rel ="stylesheet">




    </head>

    <body>
        <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
        <tiles:insertAttribute name="body" />

        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">En construcción</h4>
                    </div>
                    <div class="modal-body">
                        <p>Actualmente esta función no esta habilitada, pero próximamente lo estará.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>