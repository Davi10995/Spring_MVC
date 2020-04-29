<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="baseLayout" />
<html>
<head>
    <title>Title</title>
</head>
<body>
        <div align="center">
            <button onclick="window.location.href = '/user/editCredentialsForm?id=<c:out value="${sessionScope.currentUser.id}"/>';">Modifica Credenziali</button>
            <button onclick="window.location.href = '/user/userReservations?id=<c:out value="${sessionScope.currentUser.id}"/>';">Le mie prenotazioni</button>
        </div>
</body>
<tiles:insertDefinition name="footer" />
</html>
