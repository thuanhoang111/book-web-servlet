<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Sach App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Sach University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Student" 
				   onclick="window.location.href='add-sach-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>Ten sach</th>
					<th>NXB</th>
					<th>Gia</th>
				</tr>
				
				<c:forEach var="temp" items="${BOOK_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="BookController">
						<c:param name="command" value="LOAD" />
						<c:param name="id" value="${temp.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="BookController">
						<c:param name="command" value="DELETE" />
						<c:param name="id" value="${temp.id}" />
					</c:url>																		
					<tr>
						<td> ${temp.bookName} </td>
						<td> ${temp.NXB} </td>
						<td> ${temp.price} </td>
						<td> 
							<a href="${tempLink}">Update</a> 							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>
</html>








