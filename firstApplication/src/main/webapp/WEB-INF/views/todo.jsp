<%@page import="com.webapp.todo.TodoService"%>
<%@page import="com.webapp.todo.TodoServlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Yahoo!!</title>
<!-- Bootstrap core CSS -->
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}

.footer .container {
width: auto;
max-width: 680px;
padding: 0 15px;
}
</style>
</head>

<body>

	<nav role="navigation" class="navbar navbar-default">

		<div class="">
			<a href="/" class="navbar-brand">Contact Application</a>
		</div>

		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/">Home</a></li>
				<li class="active"><a href="/todo.do">Todos</a></li>
				<li><a href="/add-todo.do">Add Todo</a></li>
				<li><a href="https://patharegaurav92.github.io/">Personal Website</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
			
				<li><a href="/logout.do">Logout</a></li>
			</ul>
		</div>

	</nav>

	<div class="container">
		
	<br>
	Welcome ${name}
	<br>
	<h3>Your Todos:</h3>
	
	
	<% if(TodoServlet.todoService.getSize()!=0){ %>
	<table class="table">
	<tr><th>Description</th><th></th><th></th></tr>
	<c:forEach items="${todos}" var="todo">
	<tr><td>${todo.name} </td><td class="normal"><a href="edit-todo.do?todo=${todo.id}">Edit</a></td><td class="danger"> <a href="delete-todo.do?todo=${todo.id}">Delete</a></td></tr>
	</c:forEach>
	</table>
	<%}else{
	%>
	<h5> No Todos! Please add new Todos </h5>
	<% 
	}%>
	
	
	<!-- <form action="/add-todo.do" method="POST">
		<input type="text" name="todo">
		<input type="submit" value="add">
	</form> -->
	</div>

	<%@include file="footer.html" %>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>



