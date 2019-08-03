 <ul class="nav nav-tabs nav-justified">
            <li  class="active"><a data-toggle="tab" href="#entregas">Numero de pedidos</a></li>
            <li id="tab_numpalets_seccion"class="tab_actualizable"><a data-toggle="tab" href="#palets">Nº Palets</a></li>
            <li id="tab_unidades_seccion"class="tab_actualizable"><a data-toggle="tab" href="#unidades">Unidades</a></li>
            <li id="tab_importe_seccion"class="tab_actualizable"><a data-toggle="tab" href="#importe">Importe</a></li>
        </ul>

        <div class="tab-content">
            <div id="entregas" class="tab-pane fade in active">
                </br>
                <!-- Datos para la Grafica de planning de pedidos -->
                <c:forEach items="${pedidosxdia}" var="numpedidos" varStatus="loop">
                    <c:set var="ruta" value="numpedidos${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpedidos}">
                </c:forEach>
                <c:forEach items="${pedidosxdiasitienda}" var="numpedidos" varStatus="loop">
                    <c:set var="ruta" value="numpedidossitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpedidos}">
                </c:forEach>
                <c:forEach items="${pedidosxdianotienda}" var="numpedidos" varStatus="loop">
                    <c:set var="ruta" value="numpedidosnotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpedidos}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div class="chartpedidosxdia" style="height: 300px; width: 100%">
                </div>
            </div>
            <div id="palets" class="tab-pane fade">
                </br>
                <!-- Datos para la Grafica de numero de palets -->
                <c:forEach items="${paletsxdia}" var="numpalets" varStatus="loop">
                    <c:set var="ruta" value="numpalets${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpalets}">
                </c:forEach>
                <c:forEach items="${paletsxdiasitienda}" var="numpalets" varStatus="loop">
                    <c:set var="ruta" value="numpaletssitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpalets}">
                </c:forEach>
                <c:forEach items="${paletsxdianotienda}" var="numpalets" varStatus="loop">
                    <c:set var="ruta" value="numpaletsnotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numpalets}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div id="chartpaletsxdia" class="chartpaletsxdia " style="height: 300px; width: 100%">
                </div>
            </div>
            <div id="unidades" class="tab-pane fade ">
                Para la grafica de unidades por tienda
                </br>
                <!-- Datos para la Grafica de numero de unidades -->
                <c:forEach items="${unidadesxdia}" var="numunidades" varStatus="loop">
                    <c:set var="ruta" value="numunidades${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numunidades}">
                </c:forEach>
                <c:forEach items="${unidadesxdiasitienda}" var="numunidades" varStatus="loop">
                    <c:set var="ruta" value="numunidadessitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numunidades}">
                </c:forEach>
                <c:forEach items="${unidadesxdianotienda}" var="numunidades" varStatus="loop">
                    <c:set var="ruta" value="numunidadesnotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numunidades}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div id="chartunidadesxdia" class="chartunidadesxdia " style="height: 300px; width: 100%">
                </div>
            </div>
            <div id="importe" class="tab-pane fade ">
                Para la grafica de importe a tienda
                </br>
                <!-- Datos para la Grafica de importe -->
                <c:forEach items="${importexdia}" var="numimporte" varStatus="loop">
                    <c:set var="ruta" value="numimporte${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numimporte}">
                </c:forEach>
                <c:forEach items="${importexdiasitienda}" var="numimporte" varStatus="loop">
                    <c:set var="ruta" value="numimportesitienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numimporte}">
                </c:forEach>
                <c:forEach items="${importexdianotienda}" var="numimporte" varStatus="loop">
                    <c:set var="ruta" value="numimportenotienda${loop.index+1}"/>
                    <input type="hidden" id="${ruta}" value="${numimporte}">
                </c:forEach>

                <c:forEach items="${nombredias}" var ="nombredia" varStatus="loop">
                    <c:set var="dia" value="nombredia${loop.index+1}"/>
                    <input type="hidden" id="${dia}" value="${nombredia}"/>
                </c:forEach>
                <div id="chartimportexdia" class="chartimportexdia " style="height: 300px; width: 100%">
                </div>
            </div>

        </div>