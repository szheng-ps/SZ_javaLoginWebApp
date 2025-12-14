<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Delete Products</title>
</head>
<body>
<h1>Delete A Product</h1>
<%
    String idParam = request.getParameter("id");
    int id;

    try {
        id = Integer.parseInt(idParam);
    } catch (Exception e) {
%>
<p>Invalid: Missing product ID</p>
<%
        return;
    }%>

<form action="${pageContext.request.contextPath}/products" method="post">
    <input type="hidden" name="action" value="delete"/>
    <input type="hidden" name="id" value="<%= id %>"/>
    <p>Are you sure you want to delete product with ID: <%= id %>?</p>
    <input type="submit" value="Yes, Delete"/>
    <p></p>
    <a href="product_read.jsp">Cancel</a>
</form>

<p><a href="index.jsp">Back to home</a></p>
</body>
</html>