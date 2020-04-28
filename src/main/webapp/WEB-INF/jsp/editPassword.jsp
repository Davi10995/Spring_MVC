<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="baseLayout" /><html><html>
<head>
    <title>Title</title>
</head>
<body>
<div  align="center">
    <h2>Modifica Password</h2>
    </br></br>
    <form action="${pageContext.request.contextPath}editPassword" method="post" >
        <p style="color:red;">${error}</p>
        Vecchia Password:<input type="text" name="oldPassword" /><br/><br/>
        Nuova Password:<input type="text" name="newPassword" /><br/><br/>
        <input type="submit" value="Save" />
    </form>
</div>
</body>
</html>
