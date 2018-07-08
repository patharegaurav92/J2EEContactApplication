package com.webapp.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.todo.TodoService;

@WebServlet(urlPatterns= "/register.do")
public class RegisterServlet extends HttpServlet {
	
	LoginRegisterService registerUser = new LoginRegisterService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//System.out.println("in get");
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
		//System.out.println("in get");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");
		if(name.matches("[A-Za-z]+") && password.equals(confirmPassword)) {
			
		}else if(!name.matches("[A-Za-z]+")) {
			request.setAttribute("errormessage","Invalid name");
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
		}else if(!(password.equals(confirmPassword))){
			request.setAttribute("errormessage","password do not match");
			request.setAttribute("name",name);
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
		}else {
			request.setAttribute("errormessage","Invalid name and password");
			request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request,response);
		}
	}
}
