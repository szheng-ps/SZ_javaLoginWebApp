<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Summary</title>
</head>
<body>
<h1>Shoe Order Summary</h1>

<p>Product: <b>${productName}</b></p>
<p>Unit Price: $${unitPrice}</p>
<p style="margin-bottom: 35px;">Quantity: ${quantity}</p>

<p>Subtotal: $${subtotal}</p>
<p>Discount: ${discountRate}% (-$${discountAmount})</p>
<p style="margin-bottom: 35px;"><b>Total: $${total}</b></p>

<p><a href="shoes.jsp">Back to order page</a></p>
<p><a href="index.jsp">Back to home</a></p>
</body>
</html>