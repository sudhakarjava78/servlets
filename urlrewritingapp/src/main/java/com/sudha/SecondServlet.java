package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String accType = request.getParameter("accType");
		String accBranch = request.getParameter("accBranch");
		HttpSession session = request.getSession();
		session.setAttribute("accType", accType);
		session.setAttribute("accBranch", accBranch);
		out.println("<html><body bgcolor='cyan'><br><br>");
		out.println("<center><h1>Deposit From(Cont...)</h1></center><br><br><br><br><br>");
		out.println("<form method='get' action='" + response.encodeUrl("./deposit") + "'>");
		out.println("<pre>");
		out.println("Depositor Name <input type='text' name='depName'/>");
		out.println();
		out.println("Deposit Amount <input type='text' name='depAmount'/>");
		out.println();
		out.println("<input type='submit' value='Deposit'/>");
		out.println("</pre></form></body></html>");
	}
}
