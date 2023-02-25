<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h3>List BOOK</h3>
	<button href="/add-student.jsp" value="ADD STUDENT" /> 
	<table class="table table-striped table-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">name</th>
			<th scope="col">NXB</th>
			<th scope="col">price</th>
		</tr>
		<c:forEach var="book" items="${BOOK_LIST}">
			<tr>
				<th>${book.id}</th>
				<th>${book.bookName}</th>
				<th>${book.NXB}</th>
				<th>${book.price}</th>
			</tr>
		</c:forEach>
	</table>


	<br />

</body>
</html>