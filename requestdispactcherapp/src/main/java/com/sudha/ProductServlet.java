package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String productName = request.getParameter("productName");
		String productId = request.getParameter("productId");

		if (productId.equals("m-111")) {
			RequestDispatcher rd = request.getRequestDispatcher("/welcome");
			rd.forward(request, response);
		} else {
			out.print("Sorry ProductId or ProductName Wrong!");
			RequestDispatcher rd = request.getRequestDispatcher("/product_form.html");
			rd.include(request, response);

		}
	}
}
