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
	<h3>Create a quiz1</h3>
	<div>
		<form action="/admin/createquiz" method="post">
			Enter quiz name : <input name="quizname" /> <br /> <input
				type="submit" value="Add" />
		</form>
	</div>
</body>
</html>