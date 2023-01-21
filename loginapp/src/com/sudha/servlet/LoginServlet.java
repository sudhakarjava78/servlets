package com.sudha.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		UserBean ub = new UserBean();
		String status = ub.checkLogin(uname, upwd);
		System.out.println("Status :"+status);
		out.println("<html><body bgcolor='lightyellow'>");
		out.println("<center><b><font size='7' color='red'><br><br>");
		if (status.equals("success")) {
			out.println("Ur Login is Success");
		}
		if (status.equals("failure")) {
			out.println("Ur Login is Failure");
			out.println("<br><br>");
			out.println("<a href='./registrationfomr.html'>Registration</a>");
		}
		out.println("</font></b></center></body></html>");
	}
}
