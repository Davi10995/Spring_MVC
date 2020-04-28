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
<tiles:insertDefinition name="baseLayout" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<div  align="center">
    <h2>Modifica Utente</h2>
    </br></br>
    <form action="${pageContext.request.contextPath}edit" method="post" >
        CF:<input type="text" name="cf" value="<c:out value='${user.cf}' />"/><br/><br/>
        Nome:<input type="text" name="nome" value="<c:out value='${user.nome}' />"/><br/><br/>
        Cognome:<input type="text" name="cognome" value="<c:out value='${user.cognome}' />"/><br/><br/>
        Password:<input type="text" name="password" value="<c:out value='${user.password}' />"/><br/><br/>
        Tipo:<input type="text" name="tipo" value="<c:out value='${user.tipo}' />"/><br/><br/>
        Data:<input type="date" name="data" max="datetime local" value="<c:out value='${data}' />"/><br/><br/>
        <input type="hidden" name="id" value="<c:out value='${user.id}' />">
        <input type="submit" value="Save" />
    </form>
</div>
</body>
</html>
