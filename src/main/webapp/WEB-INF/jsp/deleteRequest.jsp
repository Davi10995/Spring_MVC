<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>STAI PER ELIMINARE <c:out value='${user.nome}'/> <c:out value='${user.cognome}' />, SEI SICURO?</h1>
    <button onclick="window.location.href = '/user/deleteUser?id=<c:out value='${user.id}' />'">Si</button>
    <%--    <a href="${pageContext.request.contextPath}/deleteUser?id=<c:out value='${user.id}' />" class="button buttonYes">Si</a>--%>
    <button onclick="window.location.href = '/home';">No</button>
</div>
</body>
</html>
