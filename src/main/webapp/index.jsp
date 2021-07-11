<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
index页面
<shiro:hasRole name="teacher">
    我是老师
</shiro:hasRole>
<shiro:hasPermission name="student:manage">

    我在管理学生
</shiro:hasPermission>



</body>
</html>