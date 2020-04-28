<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="baseLayout" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h3>Benvenuto nella home</h3>
    <tiles:insertDefinition name="listReservations" />
</div>
</body>

<tiles:insertDefinition name="footer" />
</html>
