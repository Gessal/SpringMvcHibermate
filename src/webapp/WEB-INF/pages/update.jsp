<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Change user</title>
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
        <tr> <td>Активирован:</td> <td><input type="number" name="enabled" size="1" value="${u.getEnabled()}"> </td></tr>
        <input type="hidden" name="id" value="${u.getId()}">
    </table>
    <input type="submit" value="Изменить">
</form></div>
</body>
</html>