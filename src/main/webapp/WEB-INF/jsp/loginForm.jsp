<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<tiles:insertDefinition name="baseLayout" />

<html>
<head><title>Login</title></head>
<body>


<div align="center">
    <h3>${message}</h3>
<%--    <form:form action="/login">--%>
<%--        <form:input path="username"></form:input>--%>
<%--        <form:input path="password"></form:input>--%>
<%--        <input type="submit" value="Submit"/>--%>
<%--    </form:form>--%>
    <h2>${errorMessge}</h2>
    <form action="${pageContext.request.contextPath}/appLogin" method="POST">
        Enter UserName:	<input type="text" name="username"/><br/><br/>
        Enter Password: <input type="password" name="password"/> <br/><br/>
        <input type="submit" value="Login"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

<%--    <form:form name="login" method="POST">--%>
<%--        <label>--%>
<%--            <input type="text" placeholder="CF" name="username"/>--%>
<%--        </label><br/><br/>--%>
<%--        <label>--%>
<%--            <input type="password" placeholder="Password" name="password"/>--%>
<%--        </label><br/><br/>--%>
<%--        <button type="submit" value="Login">Login</button>--%>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
<%--    </form:form>--%>
</div>
</body>

<%--</html>--%>
<%--<!DOCTYPE html>--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org"--%>
<%--      xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity3">--%>
<%--<head>--%>
<%--    <title>Spring Security Example </title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div th:if="${param.error}">--%>
<%--    Invalid username and password.--%>
<%--</div>--%>
<%--<div th:if="${param.logout}">--%>
<%--    You have been logged out.--%>
<%--</div>--%>
<%--<form th:action="@{/validate}" method="post">--%>
<%--    <div><label> User Name : <input type="text" name="username"/> </label></div>--%>
<%--    <div><label> Password: <input type="password" name="password"/> </label></div>--%>
<%--    <div><input type="submit" value="Sign In"/></div>--%>
<%--</form>--%>
<%--</body>--%>
</html>