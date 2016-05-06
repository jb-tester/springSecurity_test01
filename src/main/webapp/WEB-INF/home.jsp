<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Irina.Petrovskaya
  Date: 4/29/2016
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>home</title>
</head>
<body>
<a href="/important/secret1">important1</a>
<a href="/important/secret2">important2</a>
<a href="/private/private1">private</a>

<%--<c:url var="logoutUrl" value="/j_spring_security_logout"/>--%> <!-- obsolete default-->
<%--<c:url var="logoutUrl" value="/logout"/>--%> <%-- new default--%>
<c:url var="logoutUrl" value="/mylogout"/> <%-- user-defined--%>
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Log out" />
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>
