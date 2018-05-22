<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> User Profile </title>
	</head>
	<body>

 		<form id="a_form" action="UserAddPersonalInfo?action=job" method="POST">

			<h3> Add a job </h3> <br>
			Add title: <br>
			<input type="text" name="title" /> <br>
			Add description: <br>
			<input type="text" name="description" /> <br>
			From : <br>
			<input type="date" name="dateFrom" /> <br>
			To : <br>
			<input type="date" name="dateTo" /> <br>
			Private: <br>
			<input type="checkbox" name="private" /> <br> <br>
			<input type="submit" value="Add job" />
		</form>

		<br> <br>
		
 		<form id="a_form" action="UserAddPersonalInfo?action=education" method="POST">

			<h3> Add an education </h3> <br>
			Add title: <br>
			<input type="text" name="title" /> <br>
			Add description: <br>
			<input type="text" name="description" /> <br>
			From : <br>
			<input type="date" name="dateFrom" /> <br>
			To : <br>
			<input type="date" name="dateTo" /> <br>
			Private: <br>
			<input type="checkbox" name="private" /> <br> <br>
			<input type="submit" value="Add education" />
		</form>

		<br> <br>
		
		 <form id="a_form" action="UserAddPersonalInfo?action=skill" method="POST">

			<h3> Add a skill </h3> <br>
			Add description: <br>
			<input type="text" name="description" /> <br>
			Private: <br>
			<input type="checkbox" name="private" /> <br> <br>
			<input type="submit" value="Add skill" />
		</form>
	</body>

</html>