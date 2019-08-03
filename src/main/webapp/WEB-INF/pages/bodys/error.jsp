<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="row ">
        <div class="text-center">
        <c:url var="ruta" value="resources/img/relaxincup.jpg"/>
        <img class="img-rounded" src="${ruta}">
        <h1>Upps!! Ha ocurrido algún imprevisto</h1>
        <h3>${mensaje}</h3>
        </div>
    </div>
</div>