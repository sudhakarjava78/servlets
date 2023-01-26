package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String productCat = request.getParameter("productCat");
		writer.println("<html><body bgcolor='lightpink'>");
		writer.println("ProductCategory : " + productCat);
		writer.println("</b></center></body></html>");
	}
}
