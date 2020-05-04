<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04/05/2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="baseLayout" />
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div align="center">
            <h2>Modifica Prenotazione</h2>
            <p style=color:#ff0000; red >${error}</p>
            <form:form action="edit" method="post" modelAttribute="prenotazione">
                <table>
                    <tr>
                        <td>Data Inizio</td>
                        <td><form:input type="date" path="dataInizio"/></td>
                        <td><form:errors path="dataInizio" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Data Fine</td>
                        <td><form:input type="date" path="dataFine"/></td>
                        <td><form:errors path="dataFine" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td><input type="submit" value="Salva"></td>
                    </tr>
                </table>
                <form:hidden path="id"/>
                <form:hidden path="fk_user"/>
                <form:hidden path="approvata"/>
                <form:hidden path="fk_veicolo"/>
                <input type="hidden" name="id" value="<c:out value='${sessionScope.currentUser.id}'/>"/>
            </form:form>
        </div>
    </body>
</html>
