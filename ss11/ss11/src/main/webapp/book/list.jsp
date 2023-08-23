<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/17/2023
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 align="center"> BOOK LIST</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Page size</th>
            <th scope="col">Author</th>
            <th scope="col">Category</th>
            <th scope="col" colspan="2">Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${book}" var="book">
            <tr>
                <td>
                        ${book.getId()}
                </td>
                <td>
                        ${book.getTitle()}
                </td>
                <td>
                        ${book.getPageSize()}
                </td>
                <td>
                        ${book.getAuthor()}
                </td>
                <td>
                        ${book.getCategory()}
                </td>
                <td>
                    <a class="btn btn-secondary" role="button" href="book?action=edit&id=${book.getId()}">
                        Edit
                    </a>
                </td>
                <td>
                    <button type="submit" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#exampleModal"
                            onclick="sendInfoDelete('${book.getId()}','${book.getTitle()}')">
                        Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-dark" href="book?action=create" role="button">Add new book</a>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <%--Modal--%>
            <form action="/book" id="deleteForm">
                <div class="modal-body">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" id="id" name="id"/>
                    <span>Do you want to delete <b><span id="nameDelete"></span>?</b></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Đóng</button>
                    <button type="submit" class="btn btn-danger" id="deleteButton">Xác Nhận</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function sendInfoDelete(id, name) {
        document.getElementById("nameDelete").innerText = name;
        document.getElementById("id").value = id;
    }
    const deleteButton = document.querySelector("#deleteButton");
    const deleteForm = document.querySelector("#deleteForm");
    const modal = document.getElementById("exampleModal");

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
