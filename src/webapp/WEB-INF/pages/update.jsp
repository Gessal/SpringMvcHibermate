<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Change user</title>
    <style>
        li {
            list-style-type: none;
        }
        ul {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div align="center"><form method="post">
    <table>
        <c:set var="u" value="${user}"/>
        <tr> <td>Пользователь:</td> <td><input type="text" name="username" size="25" value="${u.getUsername()}"> </td></tr>
        <tr> <td>Пароль:</td> <td><input type="text" name="password" size="25" value="${u.getPassword()}"> </td></tr>
        <tr> <td>Имя:</td> <td><input type="text" name="name" size="25" value="${u.getName()}"> </td></tr>
        <tr> <td>Фамилия:</td> <td><input type="text" name="surname" size="25" value="${u.getSurname()}"> </td></tr>
        <tr> <td>Возраст:</td> <td><input type="number" name="age" size="8" value="${u.getAge()}"> </td></tr>
        <tr> <td>Роли:</td><td>
            <ul>
                <li>
                    <input type="checkbox" name="isUser" <c:if test="${isUser}">checked</c:if>>
                </li>
                <li>
                    <input type="checkbox" name="isAdmin" <c:if test="${isAdmin}">checked</c:if>>
                </li>
            </ul>
        </td>
        <tr> <td>Активирован:</td>
            <td><input type="checkbox" name="isEnabled"
                <c:if test="${user.getEnabled() > 0}">
                    checked
                </c:if>>
            </td>
        </tr>
        <input type="hidden" name="id" value="${u.getId()}">
    </table>
    <input type="submit" value="Изменить">
</form></div>
<jsp:include page="logout_block.jsp" />
</body>
</html>