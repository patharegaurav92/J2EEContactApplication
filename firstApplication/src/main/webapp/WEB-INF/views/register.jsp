<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<title>Register</title>
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
				<li class="active"><a href="#">Home</a></li>
				<li><a href="/todo.do">Todos</a></li>
				<li><a href="https://patharegaurav92.github.io/">Personal Website</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="active" href="/register.do">Register</a></li>
				<li><a href="/login.do">Login</a></li>
			</ul>
		</div>

	</nav>

	<div class="container">
	<h1>Welcome to Register Page</h1>
	<br>
	<p><font color="red">${errorMessage}</font></p>
	<form action="register.do" method="POST">
	Enter name: <input name="name" type="text" value="${name}">
	Enter password: <input name="password" type="password">
	Confirm password: <input name="confirm-password" type="password">
	<input type="submit"/>
	</form>
	</div>

	<footer class="footer">
		<div class="container">
			<p>footer content</p>
		</div>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>



