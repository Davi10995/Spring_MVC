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
<tiles:insertDefinition name="baseLayout" />
<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>--%>
<%--<tiles:insertDefinition name="template" />--%>
<html>
    <head>
        <title>Index</title>
    </head>
    <body>
    <div align="center">
    <h2>${intestazione}</h2>
    <a href="${pageContext.request.contextPath}/login">login here</a>
    </div>
    </body>
</html>
