<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 16:18
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
            <h2>Veicoli</h2>
            <table border="1" cellpadding="5">
                <c:if test="${user.tipo == 'SuperUser'}">
                    <button onclick="window.location.href = '/veicolo/newVeicoloForm';">Aggiungi Veicolo</button>
                </c:if>
                <tr>
                    <th>Targa</th>
                    <th>Modello</th>
                    <th>Casa Costruttrice</th>
                    <th>Anno Immatricolazione</th>
                </tr>

                <c:forEach var="veicolo" items="${listVeicoli}">
                    <tr>
                        <td><c:out value="${veicolo.targa}" /></td>
                        <td><c:out value="${veicolo.modello}" /></td>
                        <td><c:out value="${veicolo.casaCostrutt}" /></td>
                        <td><c:out value="${veicolo.annoImm}" /></td>
                        <c:if test="${user.tipo == 'SuperUser'}">
                            <td>
                                <a href="${pageContext.request.contextPath}veicolo/editVehicleForm?id=<c:out value='${veicolo.id}' />">Modifica</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}veicolo/deleteVehicle?id=<c:out value='${veicolo.id}' />">Elimina</a>
                            </td>
                        </c:if>
                        <td>
                            <c:if test = "${veicolo.prenotabile == 'true'}">
                                <a href="${pageContext.request.contextPath}/insertReservation?id=<c:out value='${veicolo.id}' />">Prenota</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
