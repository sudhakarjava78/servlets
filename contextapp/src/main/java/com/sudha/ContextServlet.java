package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletConfig().getServletContext();
		String logicalName = context.getServletContextName();
		String name = context.getInitParameter("name");
		String designation = context.getInitParameter("designation");
		Enumeration e = context.getInitParameterNames();
		context.setAttribute("a", "dance");
		context.setAttribute("b", "fight");
		context.setAttribute("c", "Banglore");
		out.println("<html><body><h1><br>");
		out.println("Logical Name : " + logicalName);
		out.println("<br>");
		out.println("name for :" + name);
		out.println("<br>");
		out.println("designation for :" + designation);
		out.println("<br>");
		while (e.hasMoreElements()) {
			out.println(e.nextElement() + "<br>");
		}
		out.println("a for :" + context.getAttribute("a"));
		out.println("<br>");
		out.println("b for :" + context.getAttribute("b"));
		out.println("<br>");
		out.println("c for :" + context.getAttribute("c"));
		e = context.getAttributeNames();
		while (e.hasMoreElements()) {
			out.println(e.nextElement() + "<br>");
		}
		out.println("</h1></body></html>");
	}
}
