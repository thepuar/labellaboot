<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="row">
        <h3>Opciones de configuración</h3>

        <div class="col-md-6">
            <div class="panel panel-default ">
                <div class="panel-heading">
                    <h3 class="panel-title">Descarga de datos</h3>
                </div>
                <div class="panel-body">
                    <div>
                    <a href="<c:url value="/updateLPRE?num=1"/>"> Descargar y actualizar de mirian.cordero </a>
                    </div>
                    <div>
                     <a href="<c:url value="/updateLPRE?num=2"/>"> Descargar y actualizar de juan-antonio.fernandez </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Configuración cuenta de correo para descargar ficheros</h3>
                </div>
                <div class="panel-body">
                    <a href="#">Actualizar</a>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <h3>Datos último LPRE</h3>
        <div class="col-md-12">
            <div class="panel panel-default ">
                <div class="panel-heading">
                    <h3 class="panel-title">Descarga de datos</h3>
                </div>
                <div class="panel-body">
                    <a href="#"> Link de descarga</a>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <h3>Poblar Bases de datos</h3>
        <div class="col-md-12">
            <div class="panel panel-default ">
                <div class="panel-heading">
                    <h3 class="panel-title">Poblar base de datos para pruebas</h3>
                </div>
                <div class="panel-body">
                    <div class="col-md-6">
                    <a href="<c:url value="/updateFranco"/>"> Actualizar Franco proveedores</a></br>
                    <a href="<c:url value="/updateImportePalet"/>"> Actualizar promedio palet x pedido</a></br>
                    <a href="<c:url value="/updateUsuarios"/>">Actualizar usuarios</a></br>
                    <a href="<c:url value="/etiquetas/poblate"/>"> Poblar con etiquetas</a></br>
                     <a href="<c:url value="/etiquetas/deleteAll"/>"> Borrar todas las etiquetas</a>
                     </div>
                     <div class="col-md-6">
                         <a href="<c:url value="/updateLPRELocal?num=0"/>"> Actualizar con fichero LPRE 1</a></br>
                         <a href="<c:url value="/updateLPRELocal?num=4"/>"> Actualizar con fichero LPRE 1-MOD</a></br>
                         <a href="<c:url value="/updateLPRELocal?num=1"/>"> Actualizar con fichero LPRE 3</a></br>
                         <a href="<c:url value="/updateLPRELocal?num=2"/>"> Actualizar con fichero LPRE 6</a></br>
                         <a href="<c:url value="/updateLPRELocal?num=3"/>"> Actualizar con fichero LPRE 8</a></br>
                     </div>
                </div>
            </div>
        </div>
    </div>
</div>
