package com.sudha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	public RegistrationServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String[] qual = request.getParameterValues("uqual");
		String uqual = "";
		for (int i=0;i<qual.length;i++) {
			uqual = uqual + " " + qual[i];
		}
		String ugen = request.getParameter("ugen");
		String[] tech = request.getParameterValues("utech");
		String utech = "";
		for (int i=0;i<tech.length;i++) {
			utech = utech + " " + tech[i];
		}
		String ucity = request.getParameter("ucity");
		String ucom = request.getParameter("ucom");
		out.println("<html>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<center><br><br>");
		out.println("<table bgcolor='lightyellow'>");
		out.println(
				"<tr><td colspan='2'><center><b><font size='6' color='red'><u>Registration Details</u></font></b></center></td></tr>");
		out.println("<tr><td>User Name</td><td>" + uname + "</td></tr>");
		out.println("<tr><td>Password</td><td>" + upwd + "</td></tr>");
		out.println("<tr><td>Qualifications</td><td>" + uqual + "</td></tr>");
		out.println("<tr><td>Gender</td><td>" + ugen + "</td></tr>");
		out.println("<tr><td>Technologies</td><td>" + utech + "</td></tr>");
		out.println("<tr><td>City</td><td>" + ucity + "</td></tr>");
		out.println("<tr><td>Comments</td><td>" + ucom + "</td></tr>");
		out.println("<table></body></html>");
	}
}
