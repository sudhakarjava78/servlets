package com.sudha;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class PersonFilter implements Filter{
	
	public PersonFilter() {
	}
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='yellow'>");
		out.println("<center><b><br><br>");
		int age = Integer.parseInt(request.getParameter("personAge"));
		if(age<18) {
			out.println("You Are not allowed for this Fashion show");
			out.println("<br><br>");
			out.println("Bcoz, U R minor");
			out.println("<br><br>");
			out.println("Try after few years");
			out.println("<br><br>");
			out.println("<a href='/filterapp/personform.html'>New Person Form</a>");
		}else {
			chain.doFilter(request, response);
		}
	}
	
	public void init(FilterConfig fConfig)throws ServletException{
		
	}

}
