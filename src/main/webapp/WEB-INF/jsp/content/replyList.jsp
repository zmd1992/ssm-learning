<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>回复列表</title>
    <style>
        a {
            text-decoration: none
        }
    </style>
</head>
<body>
<a href="/leavingMessage/leavingList">返回</a>
<br/>
<div align="center">
    留言标题：
    <c:out value="${leavingMessage.title}"/>
    <br/>
    留言内容：
    <c:out value="${leavingMessage.content}"/>
    <br/>
    <c:forEach items="${replyMessageList}" var="replyMessage">
        回复内容：<c:out value="${replyMessage.replyContent}"/>；
        回复人：<c:out value="${sessionScope.loginUser.userName}"/>；
        回复时间： <fmt:formatDate value="${replyMessage.replyTime}" pattern="yyyy年MM月dd日HH点mm分ss秒"/>
        <br/>
    </c:forEach>
</div>
</body>
</html>
