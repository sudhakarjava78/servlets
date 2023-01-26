package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DisplayServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		HttpSession session = request.getSession();
		String uname = (String) session.getAttribute("uname");
		String uage = (String) session.getAttribute("uage");
		String uqual = (String) session.getAttribute("uqual");
		String udesig = (String) session.getAttribute("udesig");
		out.println("<html>");
		out.println("<body bgcolor='lightgreen'>");
		out.println("<center><br><br>");
		out.println("<table bgcolor='lightyellow'>");
		out.println(
				"<tr><td colspan='2'><center><b><font size='5' color='red'><u>Registration Details</u></font></b></center></td></tr>");
		out.println("<tr><td>User Name</td><td>" + uname + "</td></tr>");
		out.println("<tr><td>User Age</td><td>" + uage + "</td></tr>");
		out.println("<tr><td>Qualification</td><td>" + uqual + "</td></tr>");
		out.println("<tr><td>Designation</td><td>" + udesig + "</td></tr>");
		out.println("<tr><td>Email</td><td>" + email + "</td></tr>");
		out.println("<tr><td>Mobile</td><td>" + mobile + "</td></tr>");
		out.println("<tr><td>Status</td><td>Success</td></tr>");
		out.println("</table></center");
		out.println("</body>");
		out.println("</html>");
	}
}
