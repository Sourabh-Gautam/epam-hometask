<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div>
		<span><a href="/">Home</a></span>
	</div>
	<h3>Welcome to the register page</h3>
	<br />
	<form action="/user/register" , method="post">
		Enter username : <input type="text" name="username" /><br /> Create
		password : <input type="password" name="password" /><br /> <input
			type="submit" value="Register" />
	</form>
</body>
</html>