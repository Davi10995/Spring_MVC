<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="baseLayout" /><html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div align="center">
            <h2>Nuovo Utente</h2>
            <form action="${pageContext.request.contextPath}/user/newUser" method="post" >
                CF:<input type="text" name="cf"/><br/><br/>
                Nome:<input type="text" name="nome"/><br/><br/>
                Cognome:<input type="text" name="cognome"/><br/><br/>
                Password:<input type="text" name="password"/><br/><br/>
                Data:<input type="date" name="data" max="datetime local" value="2020-01-08"/><br/><br/>
                <input type="submit" value="Save" />
            </form>
        </div>
    </body>
</html>
