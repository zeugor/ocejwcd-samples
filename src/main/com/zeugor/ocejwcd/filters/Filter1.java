package com.zeugor.ocejwcd.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

class CharResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter output;

    public String toString() {
        return output.toString();
    }
      
    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new CharArrayWriter();
    }

    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }

}


public class Filter1 implements Filter {
	private FilterConfig filterConfig;
	private String attribute;

	@Override
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
		System.out.println(">> Filter1->init");
		attribute = filterConfig.getInitParameter("attribute");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
			throws IOException, ServletException {
try {
		System.out.println(">> Filter1->doFilter->before");
		if (attribute != null) {
			req.setAttribute("attribute", attribute);
		}
		String typeParam = req.getParameter("type");
		if (typeParam != null) {
			req.setAttribute("type", typeParam);
		}

		// manipulate the 'resp' object after calling FilterChain.doFilter(req, resp)
		CharResponseWrapper wrapper = 
			new CharResponseWrapper((HttpServletResponse)resp);

		try {
			throw new UnavailableException("ahhhhh!"); 
		} catch(UnavailableException e ) {
			System.out.println("permanent: " + e.isPermanent());
		}


			RequestDispatcher rd = req.getRequestDispatcher("/ForwardFilterServletTest");		
			rd.forward(req, resp);
		
		//chain.doFilter(req, wrapper);
		//resp.getWriter().println(wrapper.toString());
		resp.getWriter().println("<compress></compress>");
		/*try {
			resp.reset();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		//PrintWriter out = resp.getWriter();
		//out.println("Filter_1->after chain.doFilter");
	} catch(Exception e) {
		e.printStackTrace();
	}
} 

	@Override
	public void destroy() {
		System.out.println(">> Filter1->destroy");		
		attribute = null;
		filterConfig = null;
	}
}