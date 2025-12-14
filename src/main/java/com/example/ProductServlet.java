package com.example;

import entity.Product;
import entity.ProductDAO2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO2 productDAO2;

    @Override
    public void init() throws ServletException {
// use your existing DAO
        productDAO2 = new ProductDAO2();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

// Get all products from the DB via DAO
        List<Product> products = productDAO2.getAll();
        request.setAttribute("products", products);

// Forward to JSP
        RequestDispatcher rd = request.getRequestDispatcher("/products.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createProduct(request);
        }
        else if ("update".equals(action)) {
            updateProduct(request);
        }
        else if ("delete".equals(action)) {
            deleteProduct(request);
        }

// Redirect to avoid form resubmission
        response.sendRedirect(request.getContextPath() + "/product_read.jsp");
    }

    private void createProduct(HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String color = request.getParameter("color");
            double size = Double.parseDouble(request.getParameter("size"));
            double price = Double.parseDouble(request.getParameter("price"));

            if (name != null && !name.isBlank() && description != null && !description.isBlank()
                    && color != null && !color.isBlank() && size > 0 && price > 0) {

                Product p = new Product();
                p.setProduct_name(name);
                p.setProduct_description(description);
                p.setProduct_color(color);
                p.setProduct_size(size);
                p.setProduct_price(price);

                productDAO2.insert(p); // uses your existing DAO
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }


    private void updateProduct(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String color = request.getParameter("color");
            double size = Double.parseDouble(request.getParameter("size"));
            double price = Double.parseDouble(request.getParameter("price"));

            if (name != null && !name.isBlank() && description != null && !description.isBlank()
                    && color != null && !color.isBlank() && size > 0 && price > 0) {

                Product p = new Product();
                p.setProduct_id(id);
                p.setProduct_name(name);
                p.setProduct_description(description);
                p.setProduct_color(color);
                p.setProduct_size(size);
                p.setProduct_price(price);

                productDAO2.update(p);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Optional<Product> productOptional = productDAO2.get(id);
            productOptional.ifPresent(productDAO2::delete);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

