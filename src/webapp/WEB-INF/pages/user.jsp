<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Change user</title>
</head>
<body>
    <table>
        <c:set var="u" value="${user}"/>
        <tr> <td>Пользователь:</td> <td>${u.getUsername()}</td></tr>
        <tr> <td>Пароль:</td> <td>${u.getPassword()}</td></tr>
        <tr> <td>Имя:</td> <td>${u.getName()}</td></tr>
        <tr> <td>Фамилия:</td> <td>${u.getSurname()}</td></tr>
        <tr> <td>Возраст:</td> <td>${u.getAge()}</td></tr>
    </table>
    <a href="<c:url value="/logout" />">Logout</a>
</body>
</html>