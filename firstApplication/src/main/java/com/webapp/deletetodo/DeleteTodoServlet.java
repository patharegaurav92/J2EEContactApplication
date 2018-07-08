package com.webapp.deletetodo;

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

@WebServlet(urlPatterns= "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {
	
	//TodoService todoService = new TodoService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		int id = Integer.valueOf(request.getParameter("todo"));
		System.out.println(id);
		Todo t = TodoServlet.todoService.getTodoById(id);
		TodoServlet.todoService.deleteTodo(t);
		response.sendRedirect("/todo.do");
	}
	
	
	
}
