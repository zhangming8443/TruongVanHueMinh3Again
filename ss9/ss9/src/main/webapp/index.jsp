<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1>Login</h1>
<form method="post" action="/loginServlet">
    <table>
        <tr>
            <th>Username:</th>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <th>Password:</th>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Login">
            </td>
        </tr>
    </table>
</form>
<c:if test="${error != null}">
    <h1>${error}</h1>
</c:if>
</body>
</html>