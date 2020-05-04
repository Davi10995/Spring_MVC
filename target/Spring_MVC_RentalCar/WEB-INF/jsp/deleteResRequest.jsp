<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04/05/2020
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>Sei sicuro di voler eliminare la prenotazione?</h1>
    <button onclick="window.location.href = '/prenotazione/delete?id=${id}'">Si</button>
    <%--    <a href="${pageContext.request.contextPath}/deleteUser?id=<c:out value='${user.id}' />" class="button buttonYes">Si</a>--%>
    <button onclick="window.location.href = '/home'">No</button>
</div>
</body>
</html>
