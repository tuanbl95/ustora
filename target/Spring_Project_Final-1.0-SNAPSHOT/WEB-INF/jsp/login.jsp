<%-- 
    Document   : login
    Created on : Sep 6, 2018, 8:21:13 PM
    Author     : AnhLe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-sm-12" style="text-align: center">
                    <h1>Login</h1>
                </div>
            </div>
            <c:if test="${message!=null && message!=''}">
                <div class="row">
                    <div class="col-xs-12 col-sm-12" style="text-align: center">
                        <div class="alert alert-danger">
                            ${message}
                        </div>
                    </div>
                </div>
            </c:if>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <form action="<c:url value="j_spring_security_check" />"
                          method="post" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">Email </label>
                            <div class="col-sm-8">
                                <input class="form-control" name="email" type="text" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">password </label>
                            <div class="col-sm-8">
                                <input class="form-control" name="password" type="password" />
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <input type="submit" class="btn btn-default" value="Login" />
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
