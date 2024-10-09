<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" href="main.css" type="text/css"/>
</head>
<body>
    <h1>Your Cart</h1>
    <table border="1">
        <tr>
            <th>Product Code</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td>${product.code}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
