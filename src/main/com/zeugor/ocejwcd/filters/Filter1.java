package com.zeugor.ocejwcd.filters;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.*;

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
		System.out.println(">> Filter1->doFilter->before");
		if (attribute != null) {
			req.setAttribute("attribute", attribute);
		}
		String typeParam = req.getParameter("type");
		if (typeParam != null) {
			req.setAttribute("type", typeParam);
		}

		// manipulate the 'resp' object after calling FilterChain.doFilter(req, resp)
		chain.doFilter(req, resp);
		System.out.println(">> Filter1->doFilter->after");
		/*try {
			resp.reset();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		PrintWriter out = resp.getWriter();
		out.println("Filter_1->after chain.doFilter");
	}

	@Override
	public void destroy() {
		System.out.println(">> Filter1->destroy");		
		attribute = null;
		filterConfig = null;
	}
}