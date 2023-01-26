package com.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Enumeration<String> e = request.getHeaderNames();
		out.println("<html>");
		out.println("<body><center><br><br>");
		out.println("<table border='1' bgcolor='lightblue'");
		out.println(
				"<tr><td align='center'><h3>Header Names</h3></td><td align='center'><h3>Header Values</h3></td></tr>");
		while (e.hasMoreElements()) {
			String header_name = (String) e.nextElement();
			String header_value = request.getHeader(header_name);
			out.println("<tr><td>" + header_name + "</td><td>" + header_value + "</td></tr>");
		}
		out.println("</table></center></body></html>");
	}
}
