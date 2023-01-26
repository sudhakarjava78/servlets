package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int cid = Integer.parseInt(request.getParameter("cid"));
			CustomerDaoImpl dao = new CustomerDaoImpl();
			ResultSet rs = dao.search(cid);
			boolean b = rs.next();
			if (b == true) {
				out.println("<html>");
				out.println("<body bgcolor='lightyellow'");
				out.println("<b><font size='6'><br>");
				out.println("<pre>");
				out.println("Customer Id :" + rs.getInt(1));
				out.println("Customer Name :" + rs.getString(2));
				out.println("Customer Email :" + rs.getString(3));
				out.println("Customer Mobile :" + rs.getString(4));
				out.println("</pre></font></b></body></html>");
			} else {
				request.getRequestDispatcher("/not_existed.html").forward(request, response);
			}
		} catch (Exception e) {

		}
	}
}
