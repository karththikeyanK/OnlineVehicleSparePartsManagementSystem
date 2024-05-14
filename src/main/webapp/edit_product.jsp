<%@ page import="com.ovspms.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Product</title>
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
        .error-message {
            color: red;
            font-size: 12px;
        }
    </style>
    <script>
        function validateForm() {
            var productName = document.getElementById("productName").value.trim();
            var model = document.getElementById("model").value.trim();
            var price = document.getElementById("price").value.trim();

            var isValid = true;

            // Product Name Validation
            if (productName === "") {
                document.getElementById("productNameError").innerText = "Product Name is required";
                isValid = false;
            } else {
                document.getElementById("productNameError").innerText = "";
            }

            // Model Validation
            if (model === "") {
                document.getElementById("modelError").innerText = "Model is required";
                isValid = false;
            } else {
                document.getElementById("modelError").innerText = "";
            }

            // Price Validation
            if (price === "") {
                document.getElementById("priceError").innerText = "Price is required";
                isValid = false;
            }else if (parseFloat(price) < 0) {
                document.getElementById("priceError").innerText = "Price must be a positive number";
                isValid = false;
            } else if (isNaN(parseFloat(price))) {
                document.getElementById("priceError").innerText = "Price must be a valid number";
                isValid = false;
            } else {
                document.getElementById("priceError").innerText = "";
            }

            return isValid;
        }
    </script>
</head>
<body>
<div class="container">
    <h2>Edit Product</h2>
    <form action="<%=request.getContextPath()%>/UpdateProductServlet" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="id" value="<%= ((Product) request.getAttribute("product")).getId() %>">
        <div class="form-group">
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="productName" value="<%= ((Product) request.getAttribute("product")).getProductName() %>" >
            <span class="error-message" id="productNameError"></span>
        </div>
        <div class="form-group">
            <label for="model">Model:</label>
            <input type="text" id="model" name="model" value="<%= ((Product) request.getAttribute("product")).getModel() %>" >
            <span class="error-message" id="modelError"></span>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" value="<%= ((Product) request.getAttribute("product")).getPrice() %>" step="0.01" >
            <span class="error-message" id="priceError"></span>
        </div>
        <div class="form-group">
            <button type="submit">Update Product</button>
        </div>
    </form>
</div>
</body>
</html>
