package com.zeugor.ocejwcd.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public  class Target extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		resp.getWriter().println(req.getQueryString());
		//resp.getWriter().println(req.getAttribute("javax.servlet.forward.query_string"));
	}
}