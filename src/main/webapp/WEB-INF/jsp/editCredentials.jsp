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
<tiles:insertDefinition name="baseLayout" /><html>
<head>
    <title>Title</title>
</head>
<body>
<div  align="center">
    <h2>Modifica Utente</h2>

    </br></br>
    <form action="${pageContext.request.contextPath}editCredentials" method="post" >
        CF:<input type="text" name="cf" value="<c:out value='${sessionScope.currentUser.cf}' />"/><br/><br/>
        Nome:<input type="text" name="nome" value="<c:out value='${sessionScope.currentUser.nome}' />"/><br/><br/>
        Cognome:<input type="text" name="cognome" value="<c:out value='${sessionScope.currentUser.cognome}' />"/><br/><br/>
        <input type="hidden" name="password" value="<c:out value='${sessionScope.currentUser.password}' />">
        <input type="hidden" name="tipo" value="<c:out value='${sessionScope.currentUser.tipo}' />">
        <p style="color:red;">${error}</p>
        Data:<input type="date" name="data" max="datetime local" value="<c:out value='${sessionScope.currentUser.data}' />"/><br/><br/>
        <input type="hidden" name="id" value="<c:out value='${sessionScope.currentUser.id}' />">
        <input type="submit" value="Save" />
    </form>
    </br></br>
    <button onclick="window.location.href = '/user/editPasswordForm'">Modifica Password</button>
</div>
</body>
</html>
