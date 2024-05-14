<%@ page import="com.ovspms.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Products</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        h2 {
            color: #00416A;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #00416A;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .edit-btn {
            padding: 6px 12px;
            background-color: #008CBA;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .delete-btn {
            padding: 6px 12px;
            background-color: #f44336;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .edit-btn:hover {
            background-color: #00416A;
        }
    </style>
</head>
<body>
<h2>View Products</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Model</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <% for (Product product : (List<Product>) request.getAttribute("productList")) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getProductName() %></td>
        <td><%= product.getModel() %></td>
        <td>LKR <%= product.getPrice() %></td>
        <td>
            <button class="edit-btn" onclick="editProduct(<%= product.getId() %>)">Edit</button>
            <button class="delete-btn" onclick="deleteProduct(<%= product.getId() %>)">Delete</button>
        </td>
    </tr>
    <% } %>
    </tbody>
</table>
<script>
    function editProduct(productId) {
        // Redirect to edit product page with product ID
        window.location.href = "EditProductServlet?id=" + productId;
    }

    function deleteProduct(productId) {
        // Redirect to delete product servlet with product ID
        window.location.href = "DeleteProductServlet?id=" + productId;
    }
</script>
</body>
</html>
