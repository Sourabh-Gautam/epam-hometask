<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.epam.entity.Quiz"%>
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
	<h3>You are on quiz operating page</h3>
	<br />

	<%
	List<Quiz> quizList = (List<Quiz>) request.getAttribute("quizList");

	if (quizList == null || quizList.isEmpty()) {
	%>
	<div>No quiz available !</div>
	<%
	} else {
	for (Quiz quiz : quizList) {
	%>
	<div>
		<span><%=quiz.getId()%>. </span> <span> <a
			href="/admin/showquiz?quizid=<%=quiz.getId()%>"><%=quiz.getQuizTitle()%></a>
		</span>
		<form action="/admin/deletequiz" method="post">
			<input type="hidden" name="quizid" value="<%=quiz.getId()%>">
			<input type="submit" value="Delete" />
		</form>
		<br/>
	</div>
	<%
	}
	}
	%>
</body>
</html>