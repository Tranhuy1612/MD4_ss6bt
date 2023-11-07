package com.example.md4_ss6bt;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String productDescription = request.getParameter("productDescription");
        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));

        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Discount Result</title></head><body>");
        out.println("<h1>Discount Result</h1>");
        out.println("<p>Product Description: " + productDescription + "</p>");
        out.println("<p>Discount Amount: $" + discountAmount + "</p>");
        out.println("<p>Discount Price: $" + discountPrice + "</p>");
        out.println("</body></html>");
    }
}
