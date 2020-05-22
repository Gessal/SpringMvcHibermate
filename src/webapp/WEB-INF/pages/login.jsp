<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <form method="post" action="/login">
        <input name="j_username"/>
        <input name="j_password"/>
        <input type="submit"/>
    </form>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p>Вы уже авторизованы</p>
    <jsp:include page="logout_block.jsp" />
</sec:authorize>
</body>
</html>
