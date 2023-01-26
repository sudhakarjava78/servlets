package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			int cid = Integer.parseInt(request.getParameter("cid"));
			CustomerDaoImpl dao = new CustomerDaoImpl();
			ResultSet rs = dao.getCustomer(cid);
			boolean b = rs.next();
			if (b == true) {
				out.println("<html>");
				out.println("<body bgcolor='lightgreen'");
				out.println("<b><font size='7'");
				out.println("<br>");
				out.println("<form method='get' action='./update'");
				out.println("<pre>");
				out.println("Customer Id :" + rs.getInt(1));
				out.println("<input type='hidden' name='cid' value='" + cid + "'/>");
				out.println("Customer Name<input type='text' name='cname' value='" + rs.getString(2) + "'/>");
				out.println();
				out.println("Customer Email<input type='text' name='cemail' value='" + rs.getString(3) + "'/>");
				out.println();
				out.println("Customer Mobile<input type='text' name='cmobile' value='" + rs.getString(4) + "'/>");
				out.println();
				out.println("<input type='submit' value='Update'/>");
				out.println("</pre></form></b></body></html>");
			} else {
				request.getRequestDispatcher("/not_existed.html").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
