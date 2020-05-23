<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
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
        <tr> <td>Пользователь:</td> <td><input type="text" name="username" size="25"> </td></tr>
        <tr> <td>Пароль:</td> <td><input type="text" name="password" size="25"> </td></tr>
        <tr> <td>Имя:</td> <td><input type="text" name="name" size="25"> </td></tr>
        <tr> <td>Фамилия:</td> <td><input type="text" name="surname" size="25"> </td></tr>
        <tr> <td>Возраст:</td> <td><input type="number" name="age" size="8" value="18"> </td></tr>
        <tr> <td>Роли:</td>
            <td>
                <ul>
                    <li><input type="checkbox" name="isUser" checked></li>
                    <li><input type="checkbox" name="isAdmin"></li>
                </ul>
            </td>
        </tr>
    </table>
    <input type="submit" value="Добавить">
</form></div>
<jsp:include page="logout_block.jsp" />
</body>
</html>