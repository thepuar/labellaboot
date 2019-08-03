
var charts = [];

$(document).ready(function () {
    start();
    $('[data-toggle="popover"]').popover();
    $('input[type=radio][name=tipoPedido]').on('change', function () {
        switch ($(this).val()) {
            case '0':
                $('#updatePedidoTienda').show();
                $('#updatePedidoPC').hide();
                $('#updatePedidoOpecom').hide();
                $('#updatePedidoRM').hide();
                break;
            case '1':
                $('#updatePedidoTienda').hide();
                $('#updatePedidoPC').show();
                $('#updatePedidoOpecom').hide();
                $('#updatePedidoRM').hide();
                break;
            case '2':
                $('#updatePedidoTienda').hide();
                $('#updatePedidoPC').hide();
                $('#updatePedidoOpecom').show();
                $('#updatePedidoRM').hide();
                break;
            case '3':
                $('#updatePedidoTienda').hide();
                $('#updatePedidoPC').hide();
                $('#updatePedidoOpecom').hide();
                $('#updatePedidoRM').show();
                break;

        }
    });

    $("#pedidosrevisarmenos").click(function () {
        $("#pedidosrevisarcontenido").slideUp(500);
        $("#pedidosrevisarmenos").hide();
        $("#pedidosrevisarmas").removeClass("hide");
        $("#pedidosrevisarmas").show();


    });

    $("#pedidosrevisarmas").click(function () {
        $("#pedidosrevisarcontenido").slideDown(500);
        $("#pedidosrevisarmas").hide();
        $("#pedidosrevisarmenos").show();
        $("#pedidosrevisarmenos").removeClass("hide");


    });

    $("#pedidosfrancomenos").click(function () {
        $("#pedidosfrancocontenido").slideUp(500);
        $("#pedidosfrancomenos").hide();
        $("#pedidosfrancomas").removeClass("hide");
        $("#pedidosfrancomas").show();


    });

    $("#pedidosfrancomas").click(function () {
        $("#pedidosfrancocontenido").slideDown(500);
        $("#pedidosfrancomas").hide();
        $("#pedidosfrancomenos").show();
        $("#pedidosfrancomenos").removeClass("hide");


    });
    
    

    $("#pedidosdestacadosmenos").click(function () {
        $("#pedidosdestacadoscontenido").slideUp(500);
        $("#pedidosdestacadosmenos").hide();
        $("#pedidosdestacadosmas").removeClass("hide");
        $("#pedidosdestacadosmas").show();


    });

    $("#pedidosdestacadosmas").click(function () {
        $("#pedidosdestacadoscontenido").slideDown(500);
        $("#pedidosdestacadosmas").hide();
        $("#pedidosdestacadosmenos").show();
        $("#pedidosdestacadosmenos").removeClass("hide");


    });

    $("#pedidosenretrasomenos").click(function () {
        $("#pedidosenretrasocontenido").slideUp(500);
        $("#pedidosenretrasomenos").hide();
        $("#pedidosenretrasomas").removeClass("hide");
        $("#pedidosenretrasomas").show();


    });

    $("#pedidosenretrasomas").click(function () {
        $("#pedidosenretrasocontenido").slideDown(500);
        $("#pedidosenretrasomas").hide();
        $("#pedidosenretrasomenos").show();
        $("#pedidosenretrasomenos").removeClass("hide");


    });
    $("#pedidosanularmenos").click(function () {
        $("#pedidosanularcontenido").slideUp(500);
        $("#pedidosanularmenos").hide();
        $("#pedidosanularmas").removeClass("hide");
        $("#pedidosanularmas").show();


    });

    $("#pedidosanularmas").click(function () {
        $("#pedidosanularcontenido").slideDown(500);
        $("#pedidosanularmas").hide();
        $("#pedidosanularmenos").show();
        $("#pedidosanularmenos").removeClass("hide");
    });


    $("#pedidosavisarmenos").click(function () {
        $("#pedidosavisarcontenido").slideUp(500);
        $("#pedidosavisarmenos").hide();
        $("#pedidosavisarmas").removeClass("hide");
        $("#pedidosavisarmas").show();
    });

    $("#pedidosavisarmas").click(function () {
        $("#pedidosavisarcontenido").slideDown(500);
        $("#pedidosavisarmas").hide();
        $("#pedidosavisarmenos").show();
        $("#pedidosavisarmenos").removeClass("hide");

    });
    
    
    
     $("#proveedoressindatosmenos").click(function () {
        $("#proveedoressindatoscontenido").slideUp(500);
        $("#proveedoressindatosmenos").hide();
        $("#proveedoressindatosmas").removeClass("hide");
        $("#proveedoressindatosmas").show();
    });

    $("#proveedoressindatosmas").click(function () {
        $("#proveedoressindatoscontenido").slideDown(500);
        $("#proveedoressindatosmas").hide();
        $("#proveedoressindatosmenos").show();
        $("#proveedoressindatosmenos").removeClass("hide");

    });

    $(".tab_actualizable").on('show.bs.tab', function (e) {
        window.dispatchEvent(new Event('resize'));
        // tabVisible(jQuery(this).attr("id"));
    });
    $("#datos_seccion").click(function () {
        searchAjax();
    });

    //Para renderizar los graficos



    $('[data-tab]').on('click', function (e) {

        $(this)
                .addClass('active')
                .siblings('[data-tab]')
                .removeClass('active')
                .siblings('[data-content=' + $(this).data('tab') + ']')
                .addClass('active')
                .siblings('[data-content]')
                .removeClass('active');
        e.preventDefault();

        var tabIndex = $(this).data('tab');
        if (tabIndex === 1)
            grafico4();
        if (tabIndex === 2)
            grafico5();
        if (tabIndex === 3)
            grafico6();
        if (tabIndex === 4)
            grafico7();

    });

});



function tabVisible(elid) {
    var count = 0;
    switch (elid) {
        case "tab_numpalets_seccion":
            if ($("#chartpaletsxdia").is(":visible")) {
                grafico5();

            } else {
                setTimeout(tabVisible(elid), 5000);
                count++;
            }
            break;
    }
    console.log("Count " + count);
}

function grafico1() {

    $(".chartpedidosencamino").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "PedidosEnCurso",
        exportEnabled: true,
        title: {
            text: "Pedidos en curso por sección."
        },
        axisY: {
            title: "Número",
            suffix: "",
            includeZero: false
        },
        data: [
            {
                color: "#337ab7",
                type: "column",
                toolTipContent: "{label}: {y} pedidos",
                dataPoints: [
                    {label: "01 Materiales", y: parseInt($("#pedidos1").val())},
                    {label: "02 Madera", y: parseInt($("#pedidos2").val())},
                    {label: "03 Elect/font", y: parseInt($("#pedidos3").val())},
                    {label: "04 Herramientas", y: parseInt($("#pedidos4").val())},
                    {label: "05 Moqueta", y: parseInt($("#pedidos5").val())},
                    {label: "06 Cerámica", y: parseInt($("#pedidos6").val())},
                    {label: "07 Sanitario", y: parseInt($("#pedidos7").val())},
                    {label: "08 Cocinas", y: parseInt($("#pedidos8").val())},
                    {label: "09 Jardín", y: parseInt($("#pedidos9").val())},
                    {label: "10 Ferretería", y: parseInt($("#pedidos10").val())},
                    {label: "11 Pintura", y: parseInt($("#pedidos11").val())},
                    {label: "12 Decoración", y: parseInt($("#pedidos12").val())},
                    {label: "13 Iluminacion", y: parseInt($("#pedidos13").val())}

                ]
            }
        ]
    });
}
function grafico2() {
    $(".chartudsencamino").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "UdsEnCamino",
        exportEnabled: true,
        title: {
            text: "Unidades en curso por sección."
        },
        axisY: {
            title: "Unidades",
            suffix: "",
            includeZero: false
        },
        data: [
            {
                color: "#337ab7",
                type: "column",
                toolTipContent: "{label}: {y} unidades",
                dataPoints: [
                    {label: "01 Materiales", y: parseInt($("#uds1").val())},
                    {label: "02 Madera", y: parseInt($("#uds2").val())},
                    {label: "03 Elect/font", y: parseInt($("#uds3").val())},
                    {label: "04 Herramientas", y: parseInt($("#uds4").val())},
                    {label: "05 Moqueta", y: parseInt($("#uds5").val())},
                    {label: "06 Cerámica", y: parseInt($("#uds6").val())},
                    {label: "07 Sanitario", y: parseInt($("#uds7").val())},
                    {label: "08 Cocinas", y: parseInt($("#uds8").val())},
                    {label: "09 Jardín", y: parseInt($("#uds9").val())},
                    {label: "10 Ferretería", y: parseInt($("#uds10").val())},
                    {label: "11 Pintura", y: parseInt($("#uds11").val())},
                    {label: "12 Decoración", y: parseInt($("#uds12").val())},
                    {label: "13 Iluminacion", y: parseInt($("#uds13").val())}

                ]
            }
        ]
    });
}
function grafico3() {

    $(".chartvalorencurso").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "importeencamino",
        exportEnabled: true,
        title: {
            text: "Valor en curso por sección."
        },
        axisY: {
            title: "Importe",
            suffix: "",
            includeZero: false
        },
        data: [
            {
                color: "#337ab7",
                type: "column",
                toolTipContent: "{label}: {y}€",
                dataPoints: [
                    {label: "01 Materiales", y: parseInt($("#valorencurso1").val())},
                    {label: "02 Madera", y: parseInt($("#valorencurso2").val())},
                    {label: "03 Elect/font", y: parseInt($("#valorencurso3").val())},
                    {label: "04 Herramientas", y: parseInt($("#valorencurso4").val())},
                    {label: "05 Moqueta", y: parseInt($("#valorencurso5").val())},
                    {label: "06 Cerámica", y: parseInt($("#valorencurso6").val())},
                    {label: "07 Sanitario", y: parseInt($("#valorencurso7").val())},
                    {label: "08 Cocinas", y: parseInt($("#valorencurso8").val())},
                    {label: "09 Jardín", y: parseInt($("#valorencurso9").val())},
                    {label: "10 Ferretería", y: parseInt($("#valorencurso10").val())},
                    {label: "11 Pintura", y: parseInt($("#valorencurso11").val())},
                    {label: "12 Decoración", y: parseInt($("#valorencurso12").val())},
                    {label: "13 Iluminacion", y: parseInt($("#valorencurso13").val())}

                ]
            }
        ]
    });
}


function grafico4() {
    $(".chartpedidosxdia").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "pedidosxdia",
        exportEnabled: true,

        title: {
            text: "Entrada de pedidos revisados próximos 14 dias."
        },
        axisY: {
            title: "Numero",
            suffix: "",
            includeZero: false
        },
        toolTip: {
            shared: true
        },
        data: [
            {
                click: clickgrafico,
                name: "Total Pedidos",
                legendText: "Total Pedidos",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numpedidos1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numpedidos2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numpedidos3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numpedidos4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numpedidos5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numpedidos6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numpedidos7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numpedidos8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numpedidos9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numpedidos10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numpedidos11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numpedidos12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numpedidos13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numpedidos14").val())}
                ]
            },
            {
                click: clickgrafico,
                name: "Pasan por tienda",
                legendText: "Pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numpedidossitienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numpedidossitienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numpedidossitienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numpedidossitienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numpedidossitienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numpedidossitienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numpedidossitienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numpedidossitienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numpedidossitienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numpedidossitienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numpedidossitienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numpedidossitienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numpedidossitienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numpedidossitienda14").val())}
                ]
            },
            {
                click: clickgrafico,
                name: "No pasan por tienda",
                legendText: "No pasan por teinda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numpedidosnotienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numpedidosnotienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numpedidosnotienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numpedidosnotienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numpedidosnotienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numpedidosnotienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numpedidosnotienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numpedidosnotienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numpedidosnotienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numpedidosnotienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numpedidosnotienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numpedidosnotienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numpedidosnotienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numpedidosnotienda14").val())}


                ]
            }
        ],
        legend: {
            curosr: "pointer",
            itemclick: function (e) {
                if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                } else {
                    e.dataSeries.visible = true;
                }
                $(".chartpedidosxdia").CanvasJSChart().render();
            }
        }
    });
}


function grafico5() {
    $(".chartpaletsxdia").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "paletsxdia",
        exportEnabled: true,
        title: {
            text: "Entrada de palets revisados próximos 14 dias."
        },

        axisY: {
            title: "Numero",
            suffix: "",
            includeZero: false
        },
        toolTip: {
            shared: true
        },
        data: [
            {
                click: clickgrafico,
                name: "Total Palets",
                legendText: "Total Palets",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numpalets1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numpalets2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numpalets3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numpalets4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numpalets5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numpalets6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numpalets7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numpalets8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numpalets9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numpalets10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numpalets11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numpalets12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numpalets13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numpalets14").val())}
                ]
            }, {
                click: clickgrafico,
                name: "Pasan por tienda",
                legendText: "Pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numpaletssitienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numpaletssitienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numpaletssitienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numpaletssitienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numpaletssitienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numpaletssitienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numpaletssitienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numpaletssitienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numpaletssitienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numpaletssitienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numpaletssitienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numpaletssitienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numpaletssitienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numpaletssitienda14").val())}
                ]

            }, {
                click: clickgrafico,
                name: "No pasan por tienda",
                legendText: "No pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numpaletsnotienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numpaletsnotienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numpaletsnotienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numpaletsnotienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numpaletsnotienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numpaletsnotienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numpaletsnotienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numpaletsnotienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numpaletsnotienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numpaletsnotienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numpaletsnotienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numpaletsnotienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numpaletsnotienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numpaletsnotienda14").val())}
                ]
            }
        ], legend: {
            curosr: "pointer",
            itemclick: function (e) {
                if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                } else {
                    e.dataSeries.visible = true;
                }
                $(".chartpaletsxdia").CanvasJSChart().render();
            }
        }
    });
}

function grafico6() {
    $(".chartunidadesxdia").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "paletsxdia",
        exportEnabled: true,
        title: {
            text: "Entrada de unidades revisadas próximos 14 dias."
        },

        axisY: {
            title: "Numero",
            suffix: "",
            includeZero: false
        },
        toolTip: {
            shared: true
        },
        data: [
            {
                click: clickgrafico,
                name: "Total Unidades",
                legendText: "Total Unidades",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numunidades1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numunidades2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numunidades3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numunidades4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numunidades5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numunidades6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numunidades7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numunidades8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numunidades9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numunidades10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numunidades11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numunidades12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numunidades13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numunidades14").val())}
                ]
            }, {
                click: clickgrafico,
                name: "Pasan por tienda",
                legendText: "Pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numunidadessitienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numunidadessitienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numunidadessitienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numunidadessitienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numunidadessitienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numunidadessitienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numunidadessitienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numunidadessitienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numunidadessitienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numunidadessitienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numunidadessitienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numunidadessitienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numunidadessitienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numunidadessitienda14").val())}
                ]

            }, {
                click: clickgrafico,
                name: "No pasan por tienda",
                legendText: "No pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numunidadesnotienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numunidadesnotienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numunidadesnotienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numunidadesnotienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numunidadesnotienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numunidadesnotienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numunidadesnotienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numunidadesnotienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numunidadesnotienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numunidadesnotienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numunidadesnotienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numunidadesnotienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numunidadesnotienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numunidadesnotienda14").val())}
                ]
            }
        ], legend: {
            curosr: "pointer",
            itemclick: function (e) {
                if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                } else {
                    e.dataSeries.visible = true;
                }
                $(".chartunidadesxdia").CanvasJSChart().render();
            }
        }
    });
}

function grafico7() {
    $(".chartimportexdia").CanvasJSChart({
        animationEnabled: true,
        theme: "theme3",
        animationDuration: 3000,
        exportFileName: "paletsxdia",
        exportEnabled: true,
        title: {
            text: "Entrada de importe revisadas próximos 14 dias."
        },

        axisY: {
            title: "Numero",
            suffix: "",
            includeZero: false
        },
        toolTip: {
            shared: true
        },
        data: [
            {
                click: clickgrafico,
                name: "Total Importe",
                legendText: "Total Importe",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} €",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numimporte1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numimporte2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numimporte3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numimporte4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numimporte5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numimporte6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numimporte7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numimporte8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numimporte9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numimporte10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numimporte11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numimporte12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numimporte13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numimporte14").val())}
                ]
            }, {
                click: clickgrafico,
                name: "Pasan por tienda",
                legendText: "Pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numimportesitienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numimportesitienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numimportesitienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numimportesitienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numimportesitienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numimportesitienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numimportesitienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numimportesitienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numimportesitienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numimportesitienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numimportesitienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numimportesitienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numimportesitienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numimportesitienda14").val())}
                ]

            }, {
                click: clickgrafico,
                name: "No pasan por tienda",
                legendText: "No pasan por tienda",
                showInLegend: true,
                type: "column",
                toolTipContent: "{name}: {y} ",
                dataPoints: [
                    {label: $("#nombredia1").val(), y: parseInt($("#numimportenotienda1").val())},
                    {label: $("#nombredia2").val(), y: parseInt($("#numimportenotienda2").val())},
                    {label: $("#nombredia3").val(), y: parseInt($("#numimportenotienda3").val())},
                    {label: $("#nombredia4").val(), y: parseInt($("#numimportenotienda4").val())},
                    {label: $("#nombredia5").val(), y: parseInt($("#numimportenotienda5").val())},
                    {label: $("#nombredia6").val(), y: parseInt($("#numimportenotienda6").val())},
                    {label: $("#nombredia7").val(), y: parseInt($("#numimportenotienda7").val())},
                    {label: $("#nombredia8").val(), y: parseInt($("#numimportenotienda8").val())},
                    {label: $("#nombredia9").val(), y: parseInt($("#numimportenotienda9").val())},
                    {label: $("#nombredia10").val(), y: parseInt($("#numimportenotienda10").val())},
                    {label: $("#nombredia11").val(), y: parseInt($("#numimportenotienda11").val())},
                    {label: $("#nombredia12").val(), y: parseInt($("#numimportenotienda12").val())},
                    {label: $("#nombredia13").val(), y: parseInt($("#numimportenotienda13").val())},
                    {label: $("#nombredia14").val(), y: parseInt($("#numimportenotienda14").val())}
                ]
            }
        ], legend: {
            curosr: "pointer",
            itemclick: function (e) {
                if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                } else {
                    e.dataSeries.visible = true;
                }
                $(".chartimportexdia").CanvasJSChart().render();
            }
        }
    });
}
function clickgrafico(e) {
    searchAjax(e.dataPoint.label);
}

function graficoRevisados() {
    $(".chartRevisados").CanvasJSChart({
        title: {text: "Pedidos Revisados"},
        theme: "theme1",
        animationEnabled: true,
        animationDuration: 2000,
        data: [
            {
                type: "doughnut",
                fontFamily: "Calibri",
                indexLabelFontSize: 20,
                startAngle: 0,
                indexLabelFontColor: "dimgrey",
                indexLabelLineColor: "darkgrey",
                toolTipContent: "{y} %",
                dataPoints: [
                    {y: $("#porcRevisados").val(), indexLabel: "Si - " + $("#numRevisados").val()},
                    {y: $("#porcNoRevisados").val(), indexLabel: "No - " + $("#numNoRevisados").val()}

                ]
            }
        ]
    });
}

function graficoTipoPedidos() {
    $(".chartTipoPedidos").CanvasJSChart({
        title: {text: "Tipos de pedidos"},
        theme: "theme1",
        animationEnabled: true,
        animationDuration: 2500,
        data: [
            {
                type: "doughnut",
                indexLabelFontFamily: "Calibri",
                indexLabelFontSize: 20,
                startAngle: 0,
                indexLabelFontColor: "dimgrey",
                indexLabelLineColor: "darkgrey",
                toolTipContent: "{y} %",
                dataPoints: [
                    {y: $("#porcTienda").val(), indexLabel: "Tienda - " + $("#numPedTienda").val()},
                    {y: $("#porcPC").val(), indexLabel: "Ped. cliente - " + $("#numPedPC").val()},
                    {y: $("#porcOpecom").val(), indexLabel: "Opecom - " + $("#numPedOpecom").val()},
                    {y: $("#porcRM").val(), indexLabel: "RM - " + $("#numPedRM").val()}

                ]
            }
        ]
    });




}



function start() {
    if ($(".chartpedidosencamino").length) {
        grafico1();
    }
    if ($(".chartudsencamino").length) {
        grafico2();
    }
    if ($(".chartvalorencurso").length) {
        grafico3();
    }
    if ($(".chartpedidosxdia").length) {
        grafico4();
    }
    if ($(".chartpaletsxdia").length) {
        grafico5();
    }
    if ($(".chartunidadesxdia").length) {
        grafico6();
    }
    if ($(".chartimportexdia").length) {
        grafico7();
    }
    if ($(".chartRevisados").length) {
        graficoRevisados();
    }
    if ($(".chartTipoPedidos").length) {
        graficoTipoPedidos();
    }

}





