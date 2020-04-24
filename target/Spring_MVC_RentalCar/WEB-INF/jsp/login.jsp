<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertDefinition name="baseLayout" />

<html>
<head><title>Login</title></head>
<body>


<div align="center">
    <h3>${message}</h3>
    <form method="post">
        <label>
            <input type="text" placeholder="CF" name="username"/>
        </label><br/><br/>
        <label>
            <input type="password" placeholder="Password" name="password"/>
        </label><br/><br/>
        <button type="submit">Login</button>
    </form>
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