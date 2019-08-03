/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function searchAjax(fecha) {
    $.getJSON("/labellaprov/REST/ajaxsearchorderbysection", {fecha: fecha}, function (data) {
        var items = [];
        var dia, mes, anyo;
        var fecha;
        var fechaok;
        var stringfecha;
        $("table td").remove();
        $("table th").remove();
        $("table").addClass("table-bordered");
        $("table").addClass("table");
        $("table").addClass("table-striped");
        $("table thead").addClass("thead-inverse");
        $("table thead").append("<tr><th>Tipo</th><th>ATienda</th><th>Numero</th><th>Proveedor</th><th>Palets</th><th>Unidades</th><th>Importe</th><th>Fecha</th><th>Acciones</th></tr>");

        $.each(data, function (key, val) {
            fecha = new Date(val.fechaentregaReal);
            stringfecha = fecha.getDay() + "/" + fecha.getMonth() + "/" + fecha.getFullYear();
            var dateParts = stringfecha.split("/");
            //fechaok = new Date(dateParts[2],dateParts[0]-1,dateParts[1]);
            fecha.setDate(fecha.getDate() + 1);
            dia = fecha.getUTCDate();
            fecha.setUTCMonth(fecha.getUTCMonth() + 1);
            mes = fecha.getUTCMonth();
            anyo = fecha.getUTCFullYear();
            $("table").append("<tr><td>" + val.tipoPedidoDescr + "</td><td>" + val.entregaEnTienda + "</td><td>" + val.numeropedido + " </td><td> "
                    + val.proveedor.nombre + " </td><td>"+val.numPalets+" </td><td>"+val.uds+"</td><td>"+parseFloat(Math.round(val.importe* 100)/100).toFixed(2)+" € </td><td>"
                    + dia + "/" + mes + "/" + anyo + "</td><td>"
                    + "<a href=\"/labellaprov/uproveedor/" + val.proveedor.id + "\" target=\"_blank\"><span class=\"glyphicon glyphicon-tent\"></span></a>"
                    + "<a href=\"/labellaprov/upedido/" + val.id + "\" target=\"_blank\"><span class=\"glyphicon glyphicon-info-sign\"></span></a>"
                    + "<a href=\"/labellaprov/upedido/update/" + val.id + "\" target=\"_blank\"><span class=\"glyphicon glyphicon-refresh\"></span></a></td>"
                    + "</tr>");
        });
    });

}
