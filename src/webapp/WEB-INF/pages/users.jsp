<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table border="1" >
    <tr>
        <td>Имя</td><td>Фамилия</td><td>Возраст</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getAge()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
