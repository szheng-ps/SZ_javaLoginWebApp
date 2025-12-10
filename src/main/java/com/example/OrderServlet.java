package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get parameters dynamically from the request
        String productName = request.getParameter("productName");
        double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // 2. Calculate the subtotal and discount
        double subtotal = unitPrice * quantity;
        double discountRate = 0.0;
        if (quantity >= 10) {
            discountRate = 0.10; // 10% discount
        } else if (quantity >= 5) {
            discountRate = 0.05; // 5% discount
        }
        double discountAmount = subtotal * discountRate;
        double total = subtotal - discountAmount;

        // 3. Set attributes in the request scope to pass data to the next JSP
        request.setAttribute("productName", productName);
        request.setAttribute("unitPrice", unitPrice);
        request.setAttribute("quantity", quantity);
        request.setAttribute("subtotal", subtotal);
        request.setAttribute("discountRate", discountRate * 100);
        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("total", total);

        // 4. Forward the request to the results page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/shoe-product.jsp");
        dispatcher.forward(request, response);
    }
}