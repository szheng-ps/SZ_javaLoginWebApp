<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.ProductDAO2" %>
<%@ page import="entity.Product" %>

<%
    ProductDAO2 dao = new ProductDAO2();

    String idParam = request.getParameter("id");
    if (idParam == null) {
%>
        <p>Invalid: Missing product ID</p>
<%
        return;
    }

    int id = Integer.parseInt(idParam);
    Product product = dao.get(id).orElse(null);
%>

<html>
<head>
    <title>Update Products</title>
</head>
<body>
<h1>Update A Product</h1>
<% if(product != null) { %>
<form action="${pageContext.request.contextPath}/products" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="<%= product.getProduct_id() %>"/>

    Name: <input type="text" name="name" value="<%= product.getProduct_name() %>" required/><br/><br/>
    Description: <input type="text" name="description" value="<%= product.getProduct_description() %>" required/><br/><br/>
    Color: <input type="text" name="color" value="<%= product.getProduct_color() %>" required/><br/><br/>
    Size: <input type="number" step="0.5" name="size" value="<%= product.getProduct_size() %>" required/><br/><br/>
    Price: <input type="number" step="0.01" name="price" value="<%= product.getProduct_price() %>" required/><br/><br/>

    <input type="submit" value="Update Product"/>
</form>
<% } else { %>
<p>Product not found!</p>
<% } %>

<p><a href="index.jsp">Back to home</a></p>
</body>
</html>
