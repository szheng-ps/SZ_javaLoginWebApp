<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Product Page</title>
</head>
<body>
<h1>Product List</h1>

<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Color</th>
        <th>Size</th>
        <th>Price</th>
    </tr>

    <c:forEach var="prod" items="${products}">
        <tr>
            <td>${prod.product_id}</td>
            <td>${prod.product_name}</td>
            <td>${prod.product_description}</td>
            <td>${prod.product_color}</td>
            <td>${prod.product_size}</td>
            <td>${prod.product_price}</td>
        </tr>
    </c:forEach>
</table>

<hr/>

<h2>Add New Product</h2>
<form action="${pageContext.request.contextPath}/products" method="post">
    <label>Name:
        <input type="text" name="name" />
    </label><br/><br/>

    <label>Descripton:
        <input type="text" name="description" />
    </label><br/><br/>

    <label>Color:
        <input type="text" name="color" />
    </label><br/><br/>

    <label>Size:
        <input type="text" name="size" />
    </label><br/><br/>

    <label>Price:
        <input type="text" name="price" />
    </label><br/><br/>

    <input type="submit" value="Save Product" />
</form>

<p><a href="index.jsp">Back to home</a></p>
</body>
</html>
