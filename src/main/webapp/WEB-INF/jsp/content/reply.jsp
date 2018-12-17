<%--
  Created by IntelliJ IDEA.
  User: jin
  Date: 2018/7/9
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回复</title>
    <style>
        a {
            text-decoration: none
        }
    </style>
</head>
<body>
<a href="/leavingMessage/leavingList">返回</a>
<%--${requestScope.leavingId}--%>
<%--<br/>--%>
<%--${leavingId}--%>
<div style="text-align: center">
    <form action="/replyMessage/addReplyMessage" method="GET">
        回复内容：<br/><textarea name="replyContent" cols="40" rows="10"></textarea><br><br>
        <input type="submit" value="提交">&nbsp;&nbsp;
        <input type="reset" value="重置">

    </form>
</div>
</body>
</html>
