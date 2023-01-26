package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String uage = request.getParameter("uage");

		//create session object
		 HttpSession session = request.getSession();
		 //set the values to session object
		 session.setAttribute("uname", uname);
		 session.setAttribute("uage", uage);

		RequestDispatcher rd = request.getRequestDispatcher("form2.html");
		rd.forward(request, response);
		  
	}
}
