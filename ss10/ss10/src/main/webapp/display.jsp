<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2023
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<c:if test="${messageNull != null}">
    <h1>${messageNull}</h1>
</c:if>
<table>
    <tr>
        <th>Code</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Point</th>
    </tr>
    <c:forEach var="student" items="${student}">
        <tr>
            <td>${student.getCodeStudent()}</td>
            <td>${student.getNameStudent()}</td>
            <td>
                <c:if test="${student.getGender() == 1}">
                    Nam
                </c:if>
                <c:if test="${student.getGender() == 0}">
                    Nữ
                </c:if>
            </td>
            <td>
                <c:if test="${student.getPoint() >= 9}">
                    Giỏi
                </c:if>

                <c:if test="${student.getPoint() >= 8 && student.getPoint() < 9 }">
                    Khá
                </c:if>

                <c:if test="${student.getPoint() >= 6 && student.getPoint() <  8}">
                    Trung bình
                </c:if>

                <c:if test="${student.getPoint() < 6}">
                    Yếu
                </c:if>
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
