package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			String cname = request.getParameter("cname");
			String cemail = request.getParameter("cemail");
			String cmobile = request.getParameter("cmobile");
			CustomerDaoImpl dao = new CustomerDaoImpl();
			String status = dao.update(cid, cname, cemail, cmobile);
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
