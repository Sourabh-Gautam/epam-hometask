<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<span><a href="/">Home</a></span>
	</div>
	<h3>Welcome to the login page</h3>
	<br />
	<form action="/user/login" , method="GET">
		Enter username : <input type="text" name="username" /><br /> Enter
		password : <input type="password" name="password" /><br /> <input
			type="submit" value="Login" />
	</form>

</body>
</html>