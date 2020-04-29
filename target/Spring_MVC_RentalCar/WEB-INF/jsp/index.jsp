<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 23/04/2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<tiles:insertDefinition name="login" />
<html>
<head>
    <title>RENTCAR LOGIN</title>
</head>
<body>

<div style="text-align: center;">
    <h1>RentCar Autonoleggio</h1>
</div>
<img src="${pageContext.request.contextPath}../static/logo/logo.jpg">
</body>
</html>

