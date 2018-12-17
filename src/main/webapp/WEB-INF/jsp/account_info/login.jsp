<%--
  Created by IntelliJ IDEA.
  User: jin
  Date: 2018/7/9
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        a {
            text-decoration: none
        }
        .input{
            background-color: white;
        }
    </style>
</head>
<body>
<br>
<br>
<img src="">
<form action="/account/doLogin" method="post">
    <div style="text-align: center">
        <input name="id" type="hidden">
        用户名：<input name="userName" type="text" onfocus="true" class="input"><br><br>
        密&nbsp;&nbsp;码：
        <input name="password" type="password" onfocus="true" class="input">
        <br>
        <br>

        <input type="submit" value="登录">
        &nbsp;&nbsp;<a href="/account/register" name="注册">注册</a>
    </div>
</form>
</body>
</html>
