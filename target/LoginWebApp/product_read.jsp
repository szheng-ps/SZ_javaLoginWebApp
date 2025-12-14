<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.ProductDAO2, entity.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ProductDAO2 dao = new ProductDAO2();
    List<Product> products = dao.getAll();
    request.setAttribute("products", products);
%>

<html>
<head>
    <title>View Products</title>
</head>
<body>
<h1>All Products</h1>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Color</th>
        <th>Size</th>
        <th>Price</th>
        <th>Edit</th>
    </tr>

    <c:forEach var="prod" items="${products}">
        <tr>
            <td>${prod.product_id}</td>
            <td>${prod.product_name}</td>
            <td>${prod.product_description}</td>
            <td>${prod.product_color}</td>
            <td>${prod.product_size}</td>
            <td>${prod.product_price}</td>
            <td>
                <a href="product_update.jsp?id=${prod.product_id}">Update</a> |
                <a href="product_delete.jsp?id=${prod.product_id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<p><a href="index.jsp">Back to home</a></p>
</body>
</html>
