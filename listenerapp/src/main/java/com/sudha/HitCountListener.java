package com.sudha;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class HitCountListener implements ServletRequestListener {

	int count = 0;

	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("Request Object Created");
	}

	public void requestDestroyed(ServletRequestEvent event) {
		count = count + 1;
		ServletContext context = event.getServletContext();
		context.setAttribute("count", count);
		System.out.println("Request Object Destroyed");
	}
}
