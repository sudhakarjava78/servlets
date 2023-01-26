
package com.sudha;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cid = Integer.parseInt(request.getParameter("cid"));
			CustomerDaoImpl dao = new CustomerDaoImpl();
			String status = dao.delete(cid);
			if (status.equals("success")) {
				request.getRequestDispatcher("/success.html").forward(request, response);
			}
			if (status.equals("failure")) {
				request.getRequestDispatcher("/failure.html").forward(request, response);
				if (status.equals("notexisted")) {
					request.getRequestDispatcher("/notexisted.html").forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
