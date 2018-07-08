package com.webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns= "*.do")
public class LoginRequiredFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest  request = (HttpServletRequest) arg0;
		System.out.println(request.getRequestURI());
		//System.out.println(request.getParameter("register"));
		if(request.getSession().getAttribute("name")!= null) {
			arg2.doFilter(arg0, arg1);
		}
		else {
			request.getRequestDispatcher("/login.do").forward(arg0,arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
