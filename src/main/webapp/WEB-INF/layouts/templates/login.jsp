<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 28/04/2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <%@ page isELIgnored="false" %>
    <link href="${pageContext.request.contextPath}/static/css/navbar.css" rel="stylesheet" type="text/css">
    <title>NavBar</title>
</head>
<body>
<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="#about">About</a>
    <a href="#contact">Contact</a>
    <div class="login-container">
        <p style=color:#ff0000; red >${errorMessge}</p>
        <form action="${pageContext.request.contextPath}/appLogin" method="post" modelAttribute="user" >
            <input type="text" placeholder="CF" path="cf" name="username"/><br/><br/>
            <input type="password" placeholder="Password" path="password" name="password"/><br/><br/>
            <button type="submit">Login</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
</div>
</body>
</html>
