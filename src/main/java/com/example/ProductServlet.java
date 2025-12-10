package com.example;

import entity.Product;
import entity.ProductDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
// use your existing DAO
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

// Get all products from the DB via DAO
        List<Product> products = productDAO.getAll();
        request.setAttribute("products", products);

// Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("/products.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

// Simple â€œcreateâ€ operation
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String color = request.getParameter("color");
        double size = Double.parseDouble(request.getParameter("size"));
        double price = Double.parseDouble(request.getParameter("price"));

        if (name != null && description != null && color != null && size > 0 && price > 0
                && !name.isBlank()) {

            Product p = new Product();
            p.setName(name);
            p.setDescription(description);
            p.setColor(color);
            p.setSize(size);
            p.setPrice(price);

            productDAO.insert(p); // uses your existing DAO
        }

// Redirect to avoid form resubmission
        response.sendRedirect(request.getContextPath() + "/products");
    }
}