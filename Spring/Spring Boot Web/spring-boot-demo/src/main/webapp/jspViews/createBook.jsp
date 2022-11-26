<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
	font-style: italic;
}
</style>
</head>
<body>
	<h3>Add Book to Store</h3>
	<form:form action="/books/addbook" method="post" modelAttribute="book">
		<table>
			<tr>
				<td>ISBN</td>
				<td><input type="text" name="isbn"></td>
				<td><form:errors path="isbn" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Book Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Book Price</td>
				<td><input type="text" name="price"></td>
				<td><form:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td>No. of books in stock</td>
				<td><input type="text" name="noOfBooksInStock"></td>
				<td><form:errors path="noOfBooksInStock" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Publisher Code</td>
				<td><input type="text" name="publisher.code"></td>
			</tr>
			<tr>
				<td>Publisher Name</td>
				<td><input type="text" name="publisher.name"></td>
			</tr>
			<tr>
				<td>
					<table>
						<tr>
							<td>Chapter 1</td>
							<td><input type="text" name="chapters[0].chapterTitle"></td>
						</tr>
						<tr>
							<td>Chapter 2</td>
							<td><input type="text" name="chapters[1].chapterTitle"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Book"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>