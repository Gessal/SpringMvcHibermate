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
        <tr> <td>Активен:</td>
             <td>
                <c:if test="${user.getEnabled() <= 0}">
                    Нет
                </c:if>
                <c:if test="${user.getEnabled() > 0}">
                    Да
                </c:if>
            </td>
        </tr>
    </table>
    <jsp:include page="logout_block.jsp" />
</body>
</html>