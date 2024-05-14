package com.ovspms.servelet;

import com.ovspms.dbConnection.DBConnection;
import com.ovspms.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList =DBConnection.getAllProducts();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("viewProduct.jsp").forward(request, response);
    }
}