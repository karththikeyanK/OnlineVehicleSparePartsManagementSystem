package com.ovspms.servelet;

import com.ovspms.dbConnection.DBConnection;
import com.ovspms.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = DBConnection.getProductById(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("edit_product.jsp").forward(request, response);
    }
}