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
	<table>
		<tr>
			<td>ISBN</td>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<td>Book Name</td>
			<td>${book.name}</td>
		</tr>
		<tr>
			<td>Book Price</td>
			<td>${book.price}</td>
		</tr>
		<tr>
			<td>No. of books in stock</td>
			<td>${book.noOfBooksInStock}</td>
		</tr>
		<tr>
			<td>Publisher Code</td>
			<td>${book.publisher.code}</td>
		</tr>
		<tr>
			<td>Publisher Name</td>
			<td>${book.publisher.name}</td>
		</tr>
		<tr>
			<td>
				<table>
					<core:forEach items="${book.chapters}" var="chapter">
						<tr>
							<td>Chapter</td>
							<td>${chapter.chapterTitle}</td>
						</tr>
					</core:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td><a href="/books">Click here to Books Store page</a></td>
		</tr>
	</table>
</body>
</html>