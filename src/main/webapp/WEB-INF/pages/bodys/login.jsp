<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <div class="row">
        <div class="col-md-offset-4 col-md-4">
            <div>
                <img class="logo" src="<c:url value="/resources/img/labella_logo.png"/>">
                <div>
                    <div class="form-login">
                        <h4>Bienvenido a LaBella</h4>
                        <c:url var="action" value="/login"/>
                        <form:form method="post" action="${action}" modelAttribute="usuario">
                            <div class="input-group">
                                <span class="input-group-addon " id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
                                    <form:input type="text" path="ldap" class="form-control  " placeholder="LDAP" aria-describedby="basic-addon1" />
                            </div>
                            <form:errors path="ldap" element="div" cssClass="text-danger"></form:errors>
                                </br>
                                <div class="input-group">
                                    <span class="input-group-addon " id="basic-addon2"><span class="glyphicon glyphicon-lock"></span></span>
                                    <form:input type="password" path="password" class="form-control " placeholder="PASSWORD" aria-describedby="basic-addon2" />
                            </div>
                            </br>
                            <form:errors path="password" element="div" cssClass="text-danger"></form:errors>
                                <div class="wrapper">
                                    <span class="group-btn">     
                                        <input type="submit" value="login" class="btn btn-primary btn-md">
                                    </span>
                                </div>
                        </form:form>
                    </div>

                </div>
            </div>
        </div>

