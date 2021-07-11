<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
    <form action="/user/login" method="post">
        用户名： <input type="text" name="username"><br>
        密码：   <input type="text" name="password"><br>
        <input type="submit" value="登录">
    </form>

    <shiro:notAuthenticated></shiro:notAuthenticated>
    <shiro:authenticated>
        <shiro:principal/>
    </shiro:authenticated>
<shiro:hasAnyRoles name="admin,manager"></shiro:hasAnyRoles>
<shiro:lacksRole name="admin"></shiro:lacksRole>

</body>
</html>