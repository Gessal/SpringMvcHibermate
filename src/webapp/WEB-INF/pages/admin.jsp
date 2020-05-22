<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<form>
    <td><input type="submit" value="Список пользователей" formaction="/admin/users" formmethod="get"></td>
    <td><input type="submit" value="Добавить пользователя" formaction="/admin/add" formmethod="get"></td>
</form>
<jsp:include page="logout_block.jsp" />
</body>
</html>
