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
	<%
	Quiz quiz = (Quiz) request.getAttribute("quiz");
	List<Question> questionList = quiz.getQuestionList();
	%>
	<section style="border: solid 1px black">
		<form action="/admin/addquestion" method="post">
			<input type="hidden" name="quizid" value="<%=quiz.getId()%>" />
			Question statement : <input name="questionstatement" /><br />
			Option option1 : <input name="option1" /><br /> Option option2 : <input
				name="option2" /><br /> Option option3 : <input name="option3" /><br />
			Option option4 : <input name="option4" /><br /> Correct option : <input
				name="correctoption" /> <br /> <input type="submit" value="Add" />
		</form>
	</section>
	<br />
	<h3><%=quiz.getQuizTitle()%></h3>

	<%
	if (questionList.isEmpty()) {
	%>
	Quiz is empty.

	<%
	} else {
	for (Question question : questionList) {
	%>

	<div>
		<form action="/admin/deletequestion" method="post">
			<input type="hidden" name="quizid" value="<%=quiz.getId()%>" /> <input
				type="hidden" name="questionid" value="<%=question.getId()%>" /> <span><%=question.getId()%>.
			</span> <span><%=question.getQuestionStatement()%></span>
			<ol>
				<%
				for (Option option : question.getOptionList()) {
				%>
				<li><%=option.getOptionName()%> <span><%=option.isCorrect() ? "( Correct )" : ""%>
						
				</span></li>
				<%
				}
				%>
			</ol>
			<input type="submit" value="delete" />
		</form>
	</div>

	<%
	}
	}
	%>

</body>
</html>