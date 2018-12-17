<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jin
  Date: 2018/7/9
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账户</title>
    <style>
        a {
            text-decoration: none
        }
    </style>
</head>
<body>
<a href="/account/login">返回登录</a>
<form action="/account/registerOneAccount" method="post" style="align-content: center">
    <table align="center">
        <caption>注册</caption>
        <tr>
            <th align="right">用户名：</th>
            <th><input name="userName" type="text"></th>
        </tr>
        <tr>
            <th align="right">密&nbsp;&nbsp;码：</th>
            <th><input name="password" type="password"></th>
        </tr>
        <tr>
            <th align="right">性&nbsp;&nbsp;别：</th>
            <th>
                <input name="sex" checked="checked" value="0" type="radio">男&nbsp;&nbsp;
                <input name="sex" value="1" type="radio">女
            </th>
        </tr>
        <tr>
            <th align="right">出生日期：</th>
            <th><input name="birthday" type="text"></th>
        </tr>
        <tr>
            <th align="right">籍&nbsp;&nbsp;贯：</th>
            <th><input name="translate" type="text"></th>
        </tr>
        <tr>
            <th align="right">邮&nbsp;&nbsp;件：</th>
            <th><input name="email" type="email"></th>
        </tr>
    </table>
    <br>
    <center>
        <input type="submit" value="注册" onclick="check()">
        <input type="reset" value="重置">
    </center>

</form>

</body>
</html>
