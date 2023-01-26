package com.sudha;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			String cname = request.getParameter("cname");
			String cemail = request.getParameter("cemail");
			String cmobile = request.getParameter("cmobile");
			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
			String status = customerDaoImpl.add(cid, cname, cemail, cmobile);
			if (status.equals("existed")) {
				RequestDispatcher rd = request.getRequestDispatcher("/existed.html");
				rd.forward(request, response);
			}
			if (status.equals("success")) {
				request.getRequestDispatcher("/success.html").forward(request, response);
			}
			if (status.equals("failure")) {
				request.getRequestDispatcher("/failure.html").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
