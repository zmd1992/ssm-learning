<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>留言列表</title>
    <style>
        a {
            text-decoration: none
        }
    </style>
</head>
<body>
用户名：${sessionScope.loginUser.userName}
<div style="text-align: right">
    <a href="/account/login">退出登录</a>
</div>
<br/>
<div align="center">
    <a href="/leavingMessage/leavingMessage">新增留言</a>
</div>
<form action="/leavingMessage/batchDeleteLeavingMessage" method="post">
    <c:if test="${empty pagemsg}">
        没有任何用户信息
    </c:if>
    <c:if test="${!empty pagemsg}">
        <button type="submit"  id="${batchDelete}" onclick="">批量删除</button>
        <table border="1" cellpadding="0" cellspacing="0" align="center">
            <caption><font size="5">留言列表</font></caption>
            <tr>
                <td width="100"><font size="4"> 标题</font></td>
                <td width="100"><font size="4"> 留言时间</font></td>
                <td width="100"><font size="4"> 留言人</font></td>
                <td width="100"><font size="4"> 操作</font></td>
                <td width="100"><input type="checkbox" name="selectall" id="selectall" /></td>
            </tr>
            <c:forEach items="${pagemsg.result}" var="list">
                <tr align="center">
                    <td align="left"><font size="3"> <c:out value="${list.title}"/></font></td>
                    <td align="left"><font size="3"><fmt:formatDate value="${list.leavingTime}"
                                                                    pattern="yyyy/MM/dd/HH/mm"/></font></td>
                    <td align="center"><font size="3"><c:out value="${sessionScope.loginUser.userName}"/></font></td>
                    <td>
                        <a href="/leavingMessage/leavingInfo?id=${list.id}">留言详情&nbsp;</a>
                        <a href="/replyMessage/reply?id=${list.id}">回复&nbsp;</a>
                        <a href="/replyMessage/replyList?id=${list.id}">查看回复&nbsp;</a>
                        <a href="/leavingMessage/removeLeavingMessage?id=${list.id}">删除</a>
                    </td>
                    <td><input type="checkbox" name="id" value="${list.id}"></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br/>
    <table border="0" cellpadding="0" cellspacing="0" width="900px">
        <tr>
            <td align="right">
                <span>第${pagemsg.currentPage}/${pagemsg.totalPage}页</span>
                <span>总记录数:${pagemsg.total}  每页显示：${pagemsg.pageSize}</span>
                <span>
                <c:if test="${pagemsg.currentPage!=1}">
                    <a href="${pageContext.request.contextPath}/leavingMessage/leavingList?currentPage=1">[首页]</a>
                    <a href="${pageContext.request.contextPath}/leavingMessage/leavingList?currentPage=${pagemsg.currentPage-1}">[上一页]</a>
                </c:if>
                <c:if test="${pagemsg.currentPage!=pagemsg.total}">
                    <a href="${pageContext.request.contextPath}/leavingMessage/leavingList?currentPage=${pagemsg.currentPage+1}">[下一页]</a>
                    <a href="${pageContext.request.contextPath}/leavingMessage/leavingList?currentPage=${pagemsg.total}">[尾页]</a>
                </c:if>
            </span>
            </td>
        </tr>
    </table>
</form>
<script type="application/javascript">
</script>
</body>
</html>
