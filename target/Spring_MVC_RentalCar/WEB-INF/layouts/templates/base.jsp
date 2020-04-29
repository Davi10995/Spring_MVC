<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 22/04/2020
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <link href="${pageContext.request.contextPath}/static/css/navbar.css" rel="stylesheet" type="text/css">
    <title>NavBar</title>
</head>
<body>
<div class="topnav">
    <a  class="active" href="${pageContext.request.contextPath}/home">Home</a>
    <a href="/${pageContext.request.contextPath}user/userProfile">Profilo</a>
    <a href="/${pageContext.request.contextPath}veicolo/parcoAuto">Parco Auto</a>
    <div class="login-container">
        <p class="userName">Welcome ${sessionScope.currentUser.nome}</p>
        <form action="/logout" method="post" >
            <button type="submit">Logout</button>
        </form>
    </div>
</div>
</body>
</html>