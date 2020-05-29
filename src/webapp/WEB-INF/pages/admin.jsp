<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<form>
    <input type="submit" style="width:200px" value="Список пользователей" formaction="/admin/users" formmethod="get"><br>
    <input type="submit" style="width:200px" value="Добавить пользователя" formaction="/admin/add" formmethod="get"><br>
    <input type="submit" style="width:200px" value="Информация о пользователе" formaction="/user" formmethod="get">
</form>
<jsp:include page="logout_block.jsp" />
</body>
</html>
