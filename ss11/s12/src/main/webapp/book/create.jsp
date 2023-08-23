<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2023
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Create</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 align="center">THÊM MỚI SÁCH</h1>
<c:if test="${message != null}">
    <div class="alert alert-success d-flex align-items-center" role="alert">
        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:">
            <use xlink:href="#check-circle-fill"/>
        </svg>
        <div>
            <span class="message">${message}</span>
        </div>
    </div>
</c:if>
<p>
    <a class="btn btn-outline-dark" href="/book" role="button">
        Trở về
    </a>
</p>
<form method="post">
    <fieldset>
        <legend>Thông tin sách</legend>
        <table>
            <tr>
                <td>Tiêu đề:</td>
                <td>
                    <input name="title" type="text" id="title">
                </td>
            </tr>
            <tr>
                <td>Kích thước trang:</td>
                <td>
                    <input name="pageSize" type="text" id="pageSize">
                </td>
            </tr>
            <tr>
                <td>Tác giả:</td>
                <td>
                    <select name="author" id="author">
                        <c:forEach items="${author}" var="author">
                            <option value="${author.getId()}">${author.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Thể loại:</td>
                <td>
                    <select name="category" id="category">
                        <c:forEach items="${category}" var="category">
                            <option value="${category.getId()}">${category.getName()}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <button type="submit" class="btn btn-dark">Thêm mới</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
