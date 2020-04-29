<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 29/04/2020
  Time: 10:08
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
        <tiles:insertDefinition name="listVehicles"/>
    </body>
<tiles:insertDefinition name="footer"/>
</html>
