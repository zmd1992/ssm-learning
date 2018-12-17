<%--
  Created by IntelliJ IDEA.
  User: XIEZHONGGUI
  Date: 2018/7/11
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5">
Item <c:out value="${i}"/><p>
    </c:forEach>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>USERNAME</th>
        <th>PASSWORD</th>
        <th>AGE</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.password}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
