package com.webapp.addtodo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp.todo.Todo;
import com.webapp.todo.TodoService;
import com.webapp.todo.TodoServlet;

@WebServlet(urlPatterns= "/add-todo.do")
public class AddTodoServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		//request.setAttribute("todos",todoService.retreiveTodos());
		request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String newTodo = request.getParameter("todo");
		int count = TodoServlet.todoService.getSize()+1;
		System.out.println(count);
		TodoServlet.todoService.addTodo(new Todo(newTodo,count));
		response.sendRedirect("/todo.do");
	}
	
}
