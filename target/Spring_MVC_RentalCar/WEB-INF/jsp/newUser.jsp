<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tiles:insertDefinition name="baseLayout" /><html>
    <head>
        <title>Title</title>
        <style type="text/css">
            .error{
                color: red;
            }
        </style>
    </head>
    <body>
        <div align="center">
            <h2>Nuovo Utente</h2>
            <form:form action="newUser" method="post" modelAttribute="user">
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
                        <td>cognome</td>
                        <td><form:input path="cognome"/></td>
                        <td><form:errors path="cognome" cssClass="error"/></td>
                    </tr>

                    <tr>
                        <td>Password</td>
                        <td><form:input path="password"/></td>
                        <td><form:errors path="password" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td>Data</td>
                        <td><form:input type="date" path="data"/></td>
                        <td><form:errors path="data" cssClass="error"/></td>
                    </tr>
<%--                    <tr>--%>
<%--                        <td>Data</td>--%>
<%--                        <td><input type="date" name="dataUser"></td><p style="color: red">${error}</p>--%>
<%--                    </tr>--%>
                    <tr>
                        <td><input type="submit" value="Salva"></td>
                    </tr>
                </table>
            </form:form>

<%--            <form action="${pageContext.request.contextPath}newUser" method="post">--%>
<%--                CF:<input type="text" name="cf"/><br/><br/>--%>
<%--                Nome:<input type="text" name="nome"/><br/><br/>--%>
<%--                Cognome:<input type="text" name="cognome"/><br/><br/>--%>
<%--                Password:<input type="text" name="password"/><br/><br/>--%>
<%--                Data:<input type="date" name="data" max="datetime local" value="2020-01-08"/><br/><br/>--%>
<%--                <input type="submit" value="Save" />--%>
<%--            </form>--%>
        </div>
    </body>
</html>
