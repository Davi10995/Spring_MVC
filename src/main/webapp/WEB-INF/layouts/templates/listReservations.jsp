<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <caption><h2>Prenotazioni</h2></caption>
    <form id="search_form" action="#" method="post">
        <label>Ricerca <input id="search_input" size="30" name="keyword" /></label>
        <select name="filtroRicerca" id="filtro">
            <option value="veicolo">Veicolo</option>
            <option value="modello">Modello</option>
        </select>
        <input type="image" src="${pageContext.request.contextPath}../static/logo/search.png" id="image" />
    </form>
    <table border="1" cellpadding="5">
        <tr>
            <th>Nome Utente</th>
            <th>Veicolo</th>
            <th>Modello</th>
            <th>Data inizio</th>
            <th>Data fine</th>
        </tr>

        <c:forEach var="prenotazione" items="${prenotazioni}">
            <c:if test="${prenotazione.approvata == true}">
                <tr class="riga">
                    <td><c:out value="${prenotazione.user.nome}" /></td>
                    <td class="casa"><c:out value="${prenotazione.veicolo.casaCostrutt}" /></td>
                    <td class="modello"><c:out value="${prenotazione.veicolo.modello}" /></td>
                    <td><c:out value="${prenotazione.dataInizio}" /></td>
                    <td><c:out value="${prenotazione.dataFine}" /></td>
                    <c:if test="${sessionScope.currentUser.tipo == 'SuperUser'}">
                        <td><button onclick="window.location.href = '/prenotazione/deleteRequest?id=<c:out value="${prenotazione.id}"/>';">Elimina</button></td>
                        <c:if test="${prenotazione.editDelete()}">
                            <td><button onclick="window.location.href = '/prenotazione/editForm?id=<c:out value="${prenotazione.id}"/>';">Modifica</button></td>
                        </c:if>
                    </c:if>
                    <c:if test="${sessionScope.currentUser.tipo == 'Customer'}">
                        <c:if test="${prenotazione.editDelete()}">
                            <td><button onclick="window.location.href = '/prenotazione/editForm?id=<c:out value="${prenotazione.id}"/>';">Modifica</button></td>
                            <td><button onclick="window.location.href = '/prenotazione/deleteRequest?id=<c:out value="${prenotazione.id}"/>';">Elimina</button></td>
                        </c:if>
                    </c:if>
                </tr>
            </c:if>
        </c:forEach>
    </table>

    <table border="1" cellpadding="5">
        <caption><h2>Prenotazioni in attesa di approvazione</h2></caption>
        <tr>
            <th>Nome Utente</th>
            <th>Veicolo</th>
            <th>Modello</th>
            <th>Data inizio</th>
            <th>Data fine</th>
        </tr>

        <c:forEach var="prenotazione" items="${prenotazioni}">
            <c:if test="${prenotazione.approvata == false}">
                <tr>
                    <td><c:out value="${prenotazione.user.nome}" /></td>
                    <td><c:out value="${prenotazione.veicolo.casaCostrutt}" /></td>
                    <td><c:out value="${prenotazione.veicolo.modello}" /></td>
                    <td><c:out value="${prenotazione.dataInizio}" /></td>
                    <td><c:out value="${prenotazione.dataFine}" /></td>
                    <c:if test="${sessionScope.currentUser.tipo == 'SuperUser'}">
                        <td><button onclick="window.location.href = '/prenotazione/approva?id=<c:out value="${prenotazione.id}"/>';">Approva</button></td>
                        <td><button onclick="window.location.href = '/prenotazione/deleteRequest?id=<c:out value="${prenotazione.id}"/>';">Elimina</button></td>
                        <c:if test="${prenotazione.editDelete()}">
                            <td><button onclick="window.location.href = '/prenotazione/editForm?id=<c:out value="${prenotazione.id}"/>';">Modifica</button></td>
                        </c:if>
                    </c:if>
                     <c:if test="${sessionScope.currentUser.tipo == 'Customer'}">
                        <c:if test="${prenotazione.editDelete()}">
                            <td><button onclick="window.location.href = '/prenotazione/editForm?id=<c:out value="${prenotazione.id}"/>';">Modifica</button></td>
                            <td><button onclick="window.location.href = '/prenotazione/deleteRequest?id=<c:out value="${prenotazione.id}"/>';">Elimina</button></td>
                        </c:if>
                    </c:if>
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <script>

        $('#search_input').on('keyup', function () {
            console.log("filtro: " + document.getElementById("filtro").value)
            if(document.getElementById("filtro").value === 'veicolo') {
                var value = $(this).val();
                $('tr.riga').hide();//hide all record
                var tableRow = $("td.casa").filter(function () {
                    if ($(this).text().indexOf(value) >= 0) {
                        return $(this);
                    }
                    console.log(tableRow);
                }).closest("tr"); // alternative to .parent()
                console.log(tableRow.text());
                tableRow.show();
            }else{
                value = $(this).val();
                $('tr.riga').hide();//hide all record
                tableRow = $("td.modello").filter(function () {
                    if ($(this).text().indexOf(value) >= 0) {
                        return $(this);
                    }
                }).closest("tr"); // alternative to .parent()
                console.log(tableRow.text());
                tableRow.show();
            }
        });
    </script>
</div>
</body>
</html>
