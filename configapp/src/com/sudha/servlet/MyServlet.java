package com.sudha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletConfig config = getServletConfig();
		String logicalName = config.getServletName();
		String driver = config.getInitParameter("driver");
		String url = config.getInitParameter("url");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		out.println("<html><body><h1>");
		out.println("Logical Name: " + logicalName + "<br><br>");
		out.println("Driver: " + driver + "<br><br>");
		out.println("Url: " + url + "<br><br>");
		out.println("Username: " + user + "<br><br>");
		out.println("Password: " + password + "<br><br>");
		out.println("</h1></body></html>");
	}
}
