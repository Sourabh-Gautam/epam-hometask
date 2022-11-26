<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Books store Page</h3>
	<a href="/books/loadbook">Click here to Add Book</a>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<th>Book Name</th>
		</tr>
		<core:forEach items="${books}" var="book">
			<tr>
				<td>${book.isbn}</td>
				<td>${book.name}</td>
				<td><a href="/books/editbook?bookid=${book.bookId}">Click here to Edit Book</a></td>
				<td><a href="/books/deletebook?bookid=${book.bookId}">Click here to Delete Book</a></td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>