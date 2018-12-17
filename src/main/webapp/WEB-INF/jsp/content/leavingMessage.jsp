<%--
  Created by IntelliJ IDEA.
  User: jin
  Date: 2018/7/14
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增留言</title>
</head>
<body>
<form action="/leavingMessage/addLeavingMessage" method="post">
    <div style="text-align: center">
        标&nbsp;题：<input type="text" name="title" id="title"><br>
        <span id="titleMsg"></span>
        内&nbsp;容：<br><textarea cols="20" rows="10" name="content"></textarea><br>
        留言人：${sessionScope.loginUser.userName}<br>
        <input type="submit" value="提交" >&nbsp;&nbsp;
        <input type="reset" value="重置">
    </div>
</form>
</body>
</html>
