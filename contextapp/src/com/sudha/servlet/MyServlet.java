package com.sudha.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletConfig().getServletContext();
		String logicalName = context.getServletContextName();
		String a = context.getInitParameter("a");
		String b = context.getInitParameter("b");
		Enumeration e=context.getInitParameterNames();
		context.setAttribute("c", "C++");
		context.setAttribute("d", "Dev-Ops");
		out.println("<html><body><h1><br>");
		out.println("Logical Name: " + logicalName);
		out.println("<br>");
		out.println("a for: " + a);
		out.println("<br>");
		out.println("b for: " + b);
		out.println("<br>");
		while(e.hasMoreElements()){
			out.println(e.nextElement()+"<br>");
		}
		out.println("c for: "+context.getAttribute("c"));
		out.println("<br>");
		out.println("d for: "+context.getAttribute("d")+"<br>");
		e=context.getAttributeNames();
		while(e.hasMoreElements()){
			out.println(e.nextElement()+"<br>");
		}
		out.println("</h1></body></html>");
	}	
}
