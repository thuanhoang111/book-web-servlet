
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<title>Add Student</title>

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
		<h3>Add sach</h3>
		
		<form action="BookController" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Ten sach:</label></td>
						<td><input type="text" name="bookName" /></td>
					</tr>

					<tr>
						<td><label>NXB:</label></td>
						<td><input type="text" name="NXB" /></td>
					</tr>

					<tr>
						<td><label>Don gia:</label></td>
						<td><input type="text" name="price" /></td>
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











