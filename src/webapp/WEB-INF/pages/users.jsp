<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
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
<table border="1" align="center">
    <caption>Пользователи</caption>
    <tr>
        <td align="center">Пользователь</td><td align="center">Пароль</td><td align="center">Имя</td><td>Фамилия</td><td>Возраст</td><td>Роли</td>
        <td>Активен</td><td>Изменить</td><td>Удалить</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.getUsername()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getAge()}</td>
            <td>
                <ul>
                <c:forEach var="role" items="${user.getRoles()}">
                    <li>${role.getRole()}</li>
                </c:forEach>
                </ul>
            </td>
            <td>
                <c:if test="${user.getEnabled() <= 0}">
                    <div align="center">Нет</div>
                </c:if>
                <c:if test="${user.getEnabled() > 0}">
                    <div align="center">Да</div>
                </c:if>
            </td>
            <form>
                <input type="hidden" name="id" value="${user.getId()}">
                <td><div align="center"><input type="submit" value="Изменить" formaction="/admin/update" formmethod="get"></div></td>
                <td><div align="center"><input type="submit" value="Удалить" formaction="/admin/users" formmethod="post"></div></td>
            </form>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <form action="/admin/add" method="get">
        <input type="submit" value="Добавить">
    </form>
</div>
<jsp:include page="logout_block.jsp" />
</body>
</html>
