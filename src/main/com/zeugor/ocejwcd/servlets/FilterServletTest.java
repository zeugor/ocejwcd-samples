package com.zeugor.ocejwcd.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public  class FilterServletTest extends HttpServlet {
	protected void doGet2(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		out.println(" - FilterServletTest => type: " + req.getAttribute("type") );
		System.out.println("FilterServletTest->doGet");
		System.out.println(((req.getAttribute("attribute") != null) ? "attr: " + req.getAttribute("attribute") : " attr = null"));
		getServletContext().log(">>> loggin"); // it writes in servlet log file

		try {
			out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			//Thread.sleep( 2000 );
			out.flush();

			out.println("aaa");
			//Thread.sleep( 2000 );
			//out.flush();

			out.println("aaa");
			//Thread.sleep( 2000 );
			//out.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}

		out.println(" - after flush in Servlet");
		//out.flush();

		if (req.getAttribute("type") == null) {
			return;
		}

		if (req.getAttribute("type").equals("error")) {
			// >> dispatcher->error example
			req.setAttribute("type", "error");
			javax.servlet.ServletException e = new javax.servlet.ServletException();
			throw e;
		}
		if (req.getAttribute("type").equals("include")) {
			// >> dispatcher->include example
			req.setAttribute("type", "include");
			RequestDispatcher rd = req.getRequestDispatcher("/IncludeFilterServletTest");
			rd.include(req, resp);
		}

		if (req.getAttribute("type").equals("forward")) {
			// >> dispatcher->forward example
			RequestDispatcher rd = req.getRequestDispatcher("/ForwardFilterServletTest");		
			rd.forward(req, resp);
		}

	}


public void doGet(HttpServletRequest request,
                  HttpServletResponse response)
                  throws ServletException, IOException {
    response.getWriter().print('a');
    //response.getWriter().flush();
    request.getRequestDispatcher("hello.jsp").forward(request, response);
    //response.getWriter().print('a');
    //response.getWriter().close();
   response.getWriter().flush(); 
response.getWriter().close();    

}


}