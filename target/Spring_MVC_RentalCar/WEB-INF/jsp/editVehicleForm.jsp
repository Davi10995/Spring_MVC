<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 29/04/2020
  Time: 10:20
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
        <h2>Modifica Veicolo</h2>

        <form:form action="newVehicle" method="post" modelAttribute="veicolo">
            <input type="hidden" name="id" value="<c:out value='${veicolo.id}' />">
            <input type="hidden" name="prenotabile" value="<c:out value='${veicolo.prenotabile}' />">
            <table>
                <tr>
                    <td>Targa</td>
                    <td><form:input path="targa"/></td>
                    <td><form:errors path="targa" cssClass="error"/></td>
                </tr>

                <tr>
                    <td>Casa Costruttrice</td>
                    <td>
                        <form:select path="casaCostrutt">
                            <form:option value="Audi">Audi</form:option>
                            <form:option value="Citroen">Citroen</form:option>
                            <form:option value="Fiat">Fiat</form:option>
                            <form:option value="Peugeot">Peugeot</form:option>
                            <form:option value="Saab">Saab</form:option>
                            <form:option value="VolksWagen">VolksWagen</form:option>
                            <form:option value="Volvo">Volvo</form:option>
                        </form:select>
                    </td>
                    <td><form:errors path="casaCostrutt" cssClass="error"/></td>
                </tr>

                <tr>
                    <td>Modello</td>
                    <td>
                        <form:select path="modello">
                            <form:option value="Berlina">Berlina</form:option>
                            <form:option value="Coupe">Coupe</form:option>
                            <form:option value="Spider">Spider</form:option>
                            <form:option value="StationWagon">StationWagon</form:option>
                        </form:select>
                    </td>

                </tr>

                <tr>
                    <td>Anno Immatricolazione</td>
                    <td><form:input path="annoImm" /></td>
                    <td><form:errors path="annoImm" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Salva"></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
