package com.zeugor.ocejwcd.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public  class Source extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		req.getRequestDispatcher("target").forward(req, resp);
	}
}