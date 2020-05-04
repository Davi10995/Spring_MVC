<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="static javafx.beans.binding.Bindings.when" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <caption><h2>Utenti</h2></caption>
    <form id="search_form" action="#" method="post">
        <label>Ricerca <input id="search_input" size="30" name="keyword" /></label>
        <select name="filtroRicerca" id="filtro">
            <option value="nome">Nome</option>
            <option value="cognome">Cognome</option>
        </select>
        <input type="image" src="${pageContext.request.contextPath}../static/logo/search.png" id="image" />
    </form>
    <table border="1" cellpadding="5">
        <tr class="column-header">
            <th>CF</th>
            <th>Nome</th>
            <th>Cognome</th>
            <th>Tipo</th>
            <th>Data</th>
        </tr>
            <button onclick="window.location.href = '/user/newUserForm';">Aggiungi Utente</button>
        <c:forEach var="user" items="${users}">
            <c:if test= "${user.tipo == 'Customer'}">
                <tr class="riga">
                    <td><c:out value="${user.cf}" /></td>
                    <td class="nome"><c:out value="${user.nome}" /></td>
                    <td class="cognome"><c:out value="${user.cognome}" /></td>
                    <td><c:out value="${user.tipo}" /></td>
                    <td><c:out value="${user.data}" /></td>
                        <td>
                            <a href="${pageContext.request.contextPath}user/editForm?id=<c:out value='${user.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}user/deleteRequest?id=<c:out value='${user.id}' />">Delete</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}user/userReservations?id=<c:out value='${user.id}' />">Visualizza Prenotazioni</a>
                        </td>

                </tr>
            </c:if>
        </c:forEach>
    </table>
    <script>

            var value;
            var tableRow;
            $('#search_input').on('keyup', function () {
                if(document.getElementById("filtro").value === 'nome') {
                    value = $(this).val();
                    $('tr.riga').hide();//hide all record
                    tableRow = $("td.nome").filter(function () {
                        if ($(this).text().indexOf(value) >= 0) {
                            return $(this);
                        }
                    }).closest("tr"); // alternative to .parent()
                    console.log(tableRow.text());
                    tableRow.show();
                }else{
                    value = $(this).val();
                    $('tr.riga').hide();//hide all record
                    tableRow = $("td.cognome").filter(function () {
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
