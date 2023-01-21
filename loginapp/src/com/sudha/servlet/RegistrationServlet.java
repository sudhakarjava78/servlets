package com.sudha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		UserBean ub = new UserBean();
		String status = ub.registration(uname, upwd, email, mobile);
		out.println("<html><body bgcolor='lightyellow'>");
		out.println("<center><b><font size='7' color='red'><br><br>");
		if (status.equals("existed")) {
			out.println("User Existed Already");
			out.println("<br><br>");
			out.println("<a href='./loginform.html'>Login</a>");
		}

		if (status.equals("success")) {
			out.println("User Registration Success");
			out.println("<br><br>");
			out.println("<a href='./loginform.html'>Login</a>");
		}

		if (status.equals("failure")) {
			out.println("User Registration Failure");
			out.println("<br><br>");
			out.println("<a href='./registrationform.html'>Registration</a>");
		}
		out.println("</font></b></center></body></html>");
	}
}
