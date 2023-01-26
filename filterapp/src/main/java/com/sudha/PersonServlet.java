package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String personName = request.getParameter("personName");
		int personAge = Integer.parseInt(request.getParameter("personAge"));
		int personId = Integer.parseInt(request.getParameter("personId"));
		out.println("<br><br>");
		out.println("Hello Team.... Ur details are....");
		out.println("<br><br>");
		out.println("Name.....:" + personName);
		out.println("<br><br>");
		out.println("Name.....:" + personAge);
		out.println("<br><br>");
		out.println("Name.....:" + personId);
		out.println("<br><br>");
		out.println("Enjoy the Fashion show");
	}
}
