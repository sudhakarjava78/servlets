package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String accNo = request.getParameter("accNo");
		String accName = request.getParameter("accName");
		HttpSession session = request.getSession();
		session.setAttribute("accNo", accNo);
		session.setAttribute("accName", accName);
		out.println("<html><body bgcolor='cyan'><br><br>");
		out.println("<center><h1>Deposit From(Cont...)</h1></center><br><br><br><br><br>");
		out.println("<form method='get' action='" + response.encodeUrl("./second") + "'>");
		out.println("<pre>");
		out.println("Account Type <input type='text' name='accType'/>");
		out.println();
		out.println("Account Branch <input type='text' name='accBranch'/>");
		out.println();
		out.println("<input type='submit' value='Next'/>");
		out.println("</pre></form></body></html>");
	}
}
