<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 12:31
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
    <table border="1" cellpadding="5">
        <caption><h2>Prenotazioni</h2></caption>
        <tr>
            <th>Nome Utente</th>
            <th>Veicolo</th>
            <th>Data inizio</th>
            <th>Data fine</th>
        </tr>

        <c:forEach var="prenotazione" items="${prenotazioni}">
            <tr>
                <td><c:out value="${prenotazione.user.nome}" /></td>
                <td><c:out value="${prenotazione.veicolo.modello}" /></td>
                <td><c:out value="${prenotazione.dataInizio}" /></td>
                <td><c:out value="${prenotazione.dataFine}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
