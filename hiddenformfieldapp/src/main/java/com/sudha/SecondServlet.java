package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String productName = request.getParameter("productName");
		String productId = request.getParameter("productId");
		String productDesc = request.getParameter("productDesc");
		String productCat = request.getParameter("productCat");
		writer.println("<html><body bgcolor='lightyellow'>");
		writer.println("<center><b><br><br>");
		writer.println("Product Details");
		writer.println("<br><br>");
		writer.println("Product Name : " + productName + "<br><br>");
		writer.println("Product Id : " + productId + "<br><br>");
		writer.println("Product Description : " + productDesc + "<br><br>");
		writer.println("<a href='/hiddenformfieldapp/third?productCat=" + productCat + "'>Show Product Category</a>");
	}
}
