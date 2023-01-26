package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RegistrationServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String man_date = request.getParameter("man_date");
		String exp_date = request.getParameter("exp_date");
	    Cookie cookie[] = request.getCookies();
		String pid = cookie[0].getValue();
		String pname = cookie[1].getValue();
		int pcost = Integer.parseInt(cookie[2].getValue());
		int pquantity = Integer.parseInt(cookie[3].getValue());
		ProductBean productBean = new ProductBean();
		String status=productBean.register(pid,pname,pcost,pquantity,man_date,exp_date);
		out.println("<html>");
		out.println("<body bgcolor='pink'>");
		out.println("<center><br><br>");
		out.println("<u>Product Registration Details</u><br><br>");
		out.println("Product Id :" + pid + "<br><br>");
		out.println("Product Name :" + pname + "<br><br>");
		out.println("Product Cost :" + pcost + "<br><br>");
		out.println("Product Quantity :" + pquantity + "<br><br>");
		out.println("Product Manfuctured Date :" + man_date + "<br><br>");
		out.println("Product Expiry Date :" + exp_date + "<br><br>");
		out.println("Status :"+status);
		out.println("</center");
		out.println("</body>");
		out.println("</html>");
	}
}
