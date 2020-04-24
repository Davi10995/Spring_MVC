<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 22/04/2020
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>


<%--DA SISTEMARE URL E CAMPI--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link href="${pageContext.request.contextPath}/css/navbar.css" rel="stylesheet" type="text/css">
    <title>NavBar</title>
</head>
<body>
<div class="topnav">
    <a  class="active" href="list">Home</a>
    <a href="profilo.jsp">Profilo</a>
    <a href="parcoAuto">Parco Auto</a>
</div>
</body>
</html>
