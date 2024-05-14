<%--
  Created by IntelliJ IDEA.
  User: thushan
  Date: 5/14/24
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif; /* Set font */
        }
        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        .form-group button {
            padding: 10px 20px;
            background-color: #00416A;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group button:hover {
            background-color: #003056;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add Product</h2>
    <form action="<%=request.getContextPath()%>/AddProductServlet>" method="post">
        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" required>
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" id="model" name="model" required>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" step="0.01" required>
        </div>
        <!-- Add more form fields here -->
        <div class="form-group">
            <button type="submit">Add Product</button>
        </div>
    </form>
</div>
</body>
</html>

