<%
    // 'session' is an implicit JSP variable (type HttpSession)
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<h2>Welcome, <%= session.getAttribute("user") %>!</h2>
<p>You are now logged in.</p>

<a href="shoes.jsp">Go to Shoe Order Page</a></p>

<a href="customers.jsp">View Customer Information</a></p>

<a href="products.jsp">View Product Information</a></p>
<br>

<a href="product_create.jsp">Create Products</a></p>

<a href="product_read.jsp">View Products</a></p>

<a href="logout">Logout</a>

</body>
</html>