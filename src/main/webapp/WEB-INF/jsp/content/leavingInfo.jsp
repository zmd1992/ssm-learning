<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>留言详情</title>
</head>
<style>
    a{
        text-decoration: none;
    }
</style>
<body>
<a href="/leavingMessage/leavingList">返回</a><br/>
留言标题：<c:out value="${leavingMessageInfo.title}"/>
<br/>
留言内容：<c:out value="${leavingMessageInfo.content}"/>
<br/>
留&nbsp;言&nbsp;人：<c:out value="${leavingMessageInfo.leavingMan}"/>
</br>
留言时间：<c:out value="${leavingMessageInfo.leavingTime}"/>
</body>
</html>
