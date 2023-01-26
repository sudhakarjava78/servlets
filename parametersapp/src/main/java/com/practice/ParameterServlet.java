package com.practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ParameterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		writer.println("<htm>");
		writer.println("<body>");
		writer.println("<table border='1'");
		writer.println("<tr><td>User Name</td><td>" + uname + "</td></tr>");
		writer.println("<tr><td>Password</td><td>" + upwd + "</td></tr>");
		writer.println("</table></body></html>");
	}
}
