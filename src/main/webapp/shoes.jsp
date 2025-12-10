<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Shoes</title>
</head>
<body>
<h1>Order Shoes</h1>

<form action="orderServlet" method="post">
    <label for="productName">Shoe Name:</label>
    <input type="text" id="productName" name="productName" required>
    </p>

    <label for="unitPrice">Unit Price ($):</label>
    <input type="number" id="unitPrice" name="unitPrice" min="0" step="0.01" required>
    </p>

    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity" min="1" step="1" required>
    </p>

    <input type="submit" value="Calculate Total">
</form>

<p><a href="index.jsp">Back to home</a></p>
</body>
</html>