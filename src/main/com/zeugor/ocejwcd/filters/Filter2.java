package com.zeugor.ocejwcd.filters;

import javax.servlet.*;
import java.io.*;

public class Filter2 implements Filter {
	private FilterConfig filterConfig;
	private String attribute;

	@Override
	public void init(FilterConfig fc) {
		filterConfig = fc;
		System.out.println(">> Filter2->init");
		attribute = filterConfig.getInitParameter("attribute");		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println(">> Filter2->doFilter->before");
		if (attribute != null) {
			req.setAttribute("attribute", attribute);
		}		
		chain.doFilter(req, resp);
		System.out.println(">> Filter2->doFilter->after");
	}

	@Override
	public void destroy() {
		System.out.println(">> Filter2->destroy");
	}

}