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
		<span><a href="/">Home</a></span> <span><a
			href="/user/loginpage">Back</a></span>
	</div>
	<div id="result">
		
	</div>
	<%
	Quiz quiz = (Quiz) request.getAttribute("quiz");
	if (quiz == null) {
	%>
	<div>No quiz available !</div>
	<%
	} else {
	List<Question> questionList = quiz.getQuestionList();
	%>
	<h3><%=quiz.getQuizTitle()%></h3>
	<%
	if (questionList.isEmpty()) {
	%>
	Quiz is empty.

	<%
	} else {
	for (int j = 0; j < quiz.getQuestionList().size(); j++) {
		Question question = quiz.getQuestionList().get(j);
	%>

	<div>
		<input type="hidden" name="quizid" value="<%=question.getId()%>" /> <input
			type="hidden" name="questionid" value="<%=question.getId()%>" /> <span><%=question.getId()%>.
		</span> <span><%=question.getQuestionStatement()%></span>
		<ol>
			<%
			for (int i = 0; i < question.getOptionList().size(); i++) {
				Option option = question.getOptionList().get(i);
			%>
			<li><label for="o<%=i%>"><%=option.getOptionName()%></label> <input
				type="radio" id="<%=i%>" value="<%=option.isCorrect()%>"
				name="o<%=j%>" /></li>
			<%
			}
			%>
		</ol>

	</div>

	<%
	}
	%>
	<input type="submit" />
	<%
	}
	}
	%>
	<script>
	let inputs = document.querySelectorAll("input[type=radio]");
	let obj = {};
	inputs.forEach(el => el.addEventListener("click", e => {
	       obj[e.target.name] = e.target.value;
	}));
	
	let submit = document.querySelector("input[type=submit]");
	submit.addEventListener("click", e => {
		let count = 0;
		Object.values(obj).forEach(e => e=='true' ? ++count : count);
		let result = document.querySelector("#result");
		result.innerHTML = "<h2>Result : You got "+ count+"/<%= quiz.getQuestionList().size() %> marks </h2>";
	});
	
	</script>
</body>
</html>