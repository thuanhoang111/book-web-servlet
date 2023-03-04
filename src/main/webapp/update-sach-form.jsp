<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Update Student</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Sach University</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update sach</h3>
		
		<form action="BookController" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="id" value="${THE_Book.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>ten sach:</label></td>
						<td><input type="text" name="bookName" 
								   value="${THE_Book.bookName}" /></td>
					</tr>

					<tr>
						<td><label>NXB:</label></td>
						<td><input type="text" name="NXB" 
								   value="${THE_Book.NXB}" /></td>
					</tr>

					<tr>
						<td><label>giá</label></td>
						<td><input type="text" name="price" 
								   value="${THE_Book.price}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="SachController">Back to List</a>
		</p>
	</div>
</body>

</html>











