<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Products</title>
</head>
<body>
<h1>Create New Product</h1>
<form action="${pageContext.request.contextPath}/products" method="post">
    <input type="hidden" name="action" value="create"/>

    <label>Name:
        <input type="text" name="name" required/>
    </label><br/><br/>

    <label>Description:
        <input type="text" name="description" required/>
    </label><br/><br/>

    <label>Color:
        <input type="text" name="color" required/>
    </label><br/><br/>

    <label>Size:
        <input type="number" step="0.5" name="size" required/>
    </label><br/><br/>

    <label>Price:
        <input type="number" step="0.01" name="price" required/>
    </label><br/><br/>

    <input type="submit" value="Create Product" required/>
</form>

<p><a href="index.jsp">Back to home</a></p>
</body>
</html>