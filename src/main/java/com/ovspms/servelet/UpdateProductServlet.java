package com.ovspms.servelet;

import com.ovspms.dbConnection.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String productName = request.getParameter("productName");
        String model = request.getParameter("model");
        double price = Double.parseDouble(request.getParameter("price"));

        if (DBConnection.updateProduct(id, productName, model, price) > 0) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}