package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			String eid = request.getParameter("eid");
			String ename = request.getParameter("ename");
			String eage = request.getParameter("eage");
			String eemail = request.getParameter("eemail");
			String emobile = request.getParameter("emobile");
			out.println("<html>");
			out.println("<body>");
			out.println("<font color='red'>");
			out.println("<h2>Employee Registration Details</h2>");
			out.println("</font>");
			out.println("<font color='blue' size='5'>");
			out.println("</font>");
			out.println("<table border='1'>");
			out.println("<tr><td>Employee Id</td><td>" + eid + "</td></tr>");
			out.println("<tr><td>Employee Name</td><td>" + ename + "</td></tr>");
			out.println("<tr><td>Employee Age</td><td>" + eage + "</td></tr>");
			out.println("<tr><td>Employee Email</td><td>" + eemail + "</td></tr>");
			out.println("<tr><td>Employee Mobile</td><td>" + emobile + "</td></tr>");
			out.println("</table></body></html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
