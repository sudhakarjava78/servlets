package com.sudha;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uqual = request.getParameter("uqual");
		String udesig = request.getParameter("udesig");

		 HttpSession session = request.getSession();
		 session.setAttribute("uqual", uqual);
		 session.setAttribute("udesig", udesig);

		RequestDispatcher rd = request.getRequestDispatcher("form3.html");
		rd.forward(request, response);
		  
	}
}
