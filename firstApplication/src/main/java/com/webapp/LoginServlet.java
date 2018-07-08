package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.todo.TodoService;

@WebServlet(urlPatterns= "/login.do")
public class LoginServlet extends HttpServlet {
	
	TodoService todoService = new TodoService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		PrintWriter writer = response.getWriter();
		
		request.setAttribute("name",  request.getParameter("name"));
		request.setAttribute("password" , request.getParameter("password"));
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+" "+password);
		if(name.equals("Gaurav") && password.equals("qwerty")) {
			request.getSession().setAttribute("name",name);
			System.out.println("name set in session");
			response.sendRedirect("/todo.do");
		}else {
			
			request.setAttribute("errorMessage", "Invalid credentials");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
		}
	}
}
