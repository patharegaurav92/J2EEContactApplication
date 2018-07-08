package com.webapp.edittodo;

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

@WebServlet(urlPatterns= "/edit-todo.do")
public class EditTodoServlet extends HttpServlet {
	
	//TodoService todoService = new TodoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		int id = Integer.valueOf(request.getParameter("todo"));
		Todo t = TodoServlet.todoService.getTodoById(id);
		request.setAttribute("editTodo",t);
		request.getRequestDispatcher("WEB-INF/views/edit.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		int id = Integer.valueOf(request.getParameter("id"));
		//System.out.println(request.getParameter("id"));
		String newTodoName = request.getParameter("todo");
		//System.out.println(request.getParameter("todo"));
		TodoServlet.todoService.setTodoById(newTodoName, id);
		//Todo t = todoService.getTodoById(id);
		//t.setName(newTodoName);
		//todoService.6.addTodo(new Todo(newTodo,todoService.getSize()+1));
		//request.getSession().setAttribute("todos", TodoServlet.todoService.retreiveTodos());
		//request.getRequestDispatcher("todo.do").forward(request, response);
		response.sendRedirect("/todo.do");
	}
	
}
