<%@ page import="java.util.List" %>
<%@ page import="ru.geekbrains.model.Product" %>

<html>
<head>
    <title>Products</title>
</head>
<body>
    <h1>Products</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Price</th>
        </tr>
        <% if (!((List)request.getAttribute("ProductList")).isEmpty()) %>
            <% for (Product value : (List<Product>)request.getAttribute("ProductList")) { %>
            <tr>
                <td><%=value.getId()%></td>
                <td><%=value.getTitle()%></td>
                <td><%=value.getCost()%></td>
            </tr>
            <% } %>
    </table>
</body>
</html>