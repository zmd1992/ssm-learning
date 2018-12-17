<%--
  Created by IntelliJ IDEA.
  User: jin
  Date: 2018/7/14
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改留言信息</title>
</head>
<body>

<form action="/leavingMessage/updateLeavingMessage" method="get">
    <div style="align-content: center">
        <table>
            <tr>
                <td align="right">
                    标题：
                </td>
                <td>
                    <input type="text" name="title">
                </td>
            </tr>
            <tr>
                <td align="right">内容：</td>
                <td><textarea cols="20" rows="10" name="content"></textarea></td>
            </tr>
            <tr>
                <td align="right"> 留言人：</td>
                <td>
                    ${sessionScope.loginUser.userName}</td>
            </tr>
        </table>
<input type="submit" value="提交">&nbsp;&nbsp;
<input type="reset" value="重置">
    </div>
</form>
</body>
</html>
