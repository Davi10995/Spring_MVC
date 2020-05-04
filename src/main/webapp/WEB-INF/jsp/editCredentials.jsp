<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="baseLayout" />
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <h2>Modifica Utente</h2>
        <form:form action="editCredentials" method="post" modelAttribute="user">
            <table>
                <tr>
                    <td>CF</td>
                    <td><form:input path="cf"/></td>
                    <td><form:errors path="cf" cssClass="error"/></td>
                </tr>

                <tr>
                    <td>Nome</td>
                    <td><form:input path="nome"/></td>
                    <td><form:errors path="nome" cssClass="error"/></td>
                </tr>

                <tr>
                    <td>Cognome</td>
                    <td><form:input path="cognome"/></td>
                    <td><form:errors path="cognome" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Data</td>
                    <td><form:input type="date" path="data"/></td>
                    <td><form:errors path="data" cssClass="error"/></td>
                </tr>
<%--                <tr>--%>
<%--                    <td>Data</td>--%>
<%--                    <td><input type="date" name="dataUser"></td><p style="color: red">${error}</p>--%>
<%--                </tr>--%>
                <tr>
                    <td><input type="submit" value="Salva"></td>
                </tr>
            </table>
<%--            <td><form:hidden path="data"/></td>--%>
            <td><form:hidden path="password"/></td>
            <td><form:hidden path="tipo"/></td>
            <td><form:hidden path="id"/></td>
        </form:form>
            <button onclick="window.location.href = '/user/editPasswordForm?id=<c:out value="${sessionScope.currentUser.id}"/>';">Modifica Password</button>
    </div>
</body>
</html>
