package com.servlet.impl;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sudha.servlet.IOException;
import com.sudha.servlet.PrintWriter;
import com.sudha.servlet.String;

import jakarta.servlet.http.HttpServlet;

public class MyConfigServlet extends HttpServlet{

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
