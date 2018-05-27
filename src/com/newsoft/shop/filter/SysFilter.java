package com.newsoft.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 系统过滤器
 * @author lmy
 *
 */
@WebFilter(filterName = "sysFilter", urlPatterns = "/*")
public class SysFilter implements Filter {
	private FilterConfig config;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("");
		System.out.println("URI = " + req.getRequestURI());
		System.out.println("URL = " + req.getRequestURL());
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		this.config = null;
	}
}
