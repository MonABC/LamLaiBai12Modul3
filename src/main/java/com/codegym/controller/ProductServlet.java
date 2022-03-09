package com.codegym.controller;

import com.codegym.dao.ProductDAO;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService;

    public ProductServlet() {
        this.productService = new ProductService(new ProductDAO());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productService.findById(id);
                request.setAttribute("product", product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/delete.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "edit": {
                int id= Integer.parseInt(request.getParameter("id"));
                Product product = productService.findById(id);
                request.setAttribute("product", product); // gui doi tuong sang ben kia
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
                dispatcher.forward(request, response);

                break;
            }
            case "create": {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
                dispatcher.forward(request, response);

                break;
            }
            case "view": {
                int id = Integer.parseInt(request.getParameter("id"));
                Product product = productService.findById(id);
                request.setAttribute("product", product);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/view.jsp");
                dispatcher.forward(request, response);
                break;
            }
            default: {
                List<Product> products = productService.findALl();
                request.setAttribute("products", products);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
                dispatcher.forward(request, response);
                break;

            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action==null) {
            action="";
        }
        switch (action) {
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                 productService.deleteById(id);
                response.sendRedirect("/products");
                break;
            }
            case "edit": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name =  request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                Product product = new Product(name, price, description);
                boolean isUpdate = productService.updateById(id, product);
                int flag = 0;
                String message = "";
                if (isUpdate) {
                    message = "cap nhat thanh cong";
                    flag = 1;
                } else {
                    message = "xay ra loi";
                    flag = 2;
                }
               request.setAttribute("flag", flag);
               request.setAttribute("message", message);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/product/edit.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "create": {
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                Product product = new Product(name, price, description);
                productService.create(product);
                response.sendRedirect("/products");
                break;
            }
        }

    }
}
