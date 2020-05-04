<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 13:02
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
        <p style="color: red">${error}</p>
        <form:form action="edit" method="post" modelAttribute="user">
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
                <td><form:input type="data" path="data"/></td>
                <td><form:errors path="data" cssClass="error"/></td>
            </tr>
<%--            <tr>--%>
<%--                <td>Data</td>--%>
<%--                <td><input type="date" name="dataUser"></td>--%>
<%--            </tr>--%>
            <tr>
                <td><input type="submit" value="Salva"></td>
            </tr>
<%--            <td><form:hidden path="data"/></td>--%>
            <td><form:hidden path="password"/></td>
            <td><form:hidden path="tipo"/></td>
            <td><form:hidden path="id"/></td>
        </table>
        </form:form>
    </div>>
</body>
</html>
