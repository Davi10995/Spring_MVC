<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 29/04/2020
  Time: 17:07
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
    <h2>Stai prenotando il seguente veicolo</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>Targa</th>
            <th>Modello</th>
            <th>Casa Costruttrice</th>
            <th>Anno Immatricolazione</th>
        </tr>
            <tr>
                <td><c:out value="${veicolo.targa}" /></td>
                <td><c:out value="${veicolo.modello}" /></td>
                <td><c:out value="${veicolo.casaCostrutt}" /></td>
                <td><c:out value="${veicolo.annoImm}" /></td>
            </tr>
    </table>
    <h2>Inserisci le date per procedere con la prenotazione</h2>
    <p style=color:#ff0000; red >${error}</p>
    <form:form action="new" method="post" modelAttribute="prenotazione">
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
        <form:hidden path="fk_veicolo"/>
        <input type="hidden" name="id" value="<c:out value='${sessionScope.currentUser.id}'/>"/>
    </form:form>
</div>

</body>
</html>
