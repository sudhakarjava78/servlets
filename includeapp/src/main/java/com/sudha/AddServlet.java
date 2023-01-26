package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String pid = request.getParameter("pid");
			String pname = request.getParameter("pname");
			int pcost = Integer.parseInt(request.getParameter("pcost"));
			ProductDao dao = new ProductDao();
			dao.add(pid, pname, pcost);
			ArrayList<Product> list = dao.getProducts();
			out.println("<html><body><center><br><br>");
			out.println("<table border='1' bgcolor='lightyellow'");
			out.println("<tr><td>PID</td><td>PNAME</td><td>PCOST</td></tr>");
			for (Object o : list) {
				Product p = (Product) o;
				out.println("<tr><td>" + p.getPid() + "</td><td>" + p.getPname() + "</td><td>" + p.getPcost()
						+ "</td></tr>");
			}
			out.println("</table></center></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/add_form.html");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
