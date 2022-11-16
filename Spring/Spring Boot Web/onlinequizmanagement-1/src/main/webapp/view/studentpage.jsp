<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, com.epam.entity.Quiz, com.epam.entity.Question, com.epam.entity.Option"%>
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
	<h3>Welcome to studentpage !</h3>
	<ol>
		<%
		List<Quiz> quizList = (List<Quiz>) request.getAttribute("quizList");

		if (quizList == null || quizList.isEmpty()) {
		%>
		<div>No quiz available !</div>
		<%
		} else {
		for (Quiz quiz : quizList) {
		%>
		<li><a href="/student/showquiz?quizid=<%=quiz.getId()%>"><%=quiz.getQuizTitle()%></a>
		</li>
		<%
		}
		}
		%>
	</ol>
</body>
</html>