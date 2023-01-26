package com.sudha;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pcost = request.getParameter("pcost");
		String pquantity = request.getParameter("pquantity");

		Cookie c3 = new Cookie("pcost", pcost);
		Cookie c4 = new Cookie("pquantity", pquantity);
		response.addCookie(c3);
		response.addCookie(c4);

		RequestDispatcher rd = request.getRequestDispatcher("form3.html");
		rd.forward(request, response);
		  
	}
}
