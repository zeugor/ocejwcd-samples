package com.zeugor.ocejwcd.servlets;

import javax.servlet.http.*;
import java.io.*;

public  class DispatherFilterServletTest extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();
		out.println(" - DispatherFilterServletTest. Type: " + req.getAttribute("type"));
		out.println(" - url: " + req.getRequestURL());
		out.println(" - servletPath: " + req.getServletPath());
		out.println(" - RequestURI: " + req.getRequestURI());
		out.println(" - remoteHost: " + req.getRemoteHost());
		System.out.println("DispatherFilterServletTest->doGet");
		System.out.println(((req.getAttribute("attribute") != null) ? "attr: " + req.getAttribute("attribute") : " attr = null"));
		getServletContext().log(">>> loggin"); // it writes in servlet log file
	}
}