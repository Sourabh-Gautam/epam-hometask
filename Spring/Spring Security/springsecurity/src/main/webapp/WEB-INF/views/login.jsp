<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${ param.error!=null }">
	<h2>Invalid User Credentials</h2>
</c:if>

<c:if test="${ param.logout!=null }">
	<h2>Successfully Logged out</h2>
</c:if>

	<h1>My Custom Login Page</h1>

	<form:form action="/springsecurity/loginprocess">
	
		Username : <input type="text" name="username" />
		<br />
		Password : <input type="password" name="password" />
		<br />
		<input type="submit" value="Login" />

	</form:form>


</body>
</html>