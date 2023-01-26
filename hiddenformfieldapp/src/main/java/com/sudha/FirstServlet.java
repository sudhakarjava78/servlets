package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String productName = request.getParameter("productName");
		String productId = request.getParameter("productId");
		String productDesc = request.getParameter("productDesc");
		writer.println("<html><body bgcolor='lightyellow'>");
		writer.println("<center><b><br><br>");
		writer.println("Welcome Product Application Form");
		writer.println("<br><br>");
		writer.println("<form method='get' action='/hiddenformfieldapp/second'>");
		writer.println("<input type='hidden' name='productName' value='" + productName + "'>");
		writer.println("<input type='hidden' name='productId' value='" + productId + "'>");
		writer.println("<input type='hidden' name='productDesc' value='" + productDesc + "'>");
		writer.println("<br><br>");
		writer.println("Product Category :");
		writer.println("<input type='text' name='productCat'");
		writer.println("<br><br>");
		writer.println("<input type='submit' value='Submit'>");
		writer.println("</form></b></center></body></html>");
	}
}
