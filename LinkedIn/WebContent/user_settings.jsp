<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title> User Settings </title>
	</head>
	<body>

 		<form id="a_form" action="UserSettings" method="POST">

			Current password : <br>
			<input type="password" name="currentPaswword" /> <br>
			New password: <br>
			<input type="password" name="newPassword" /> <br>
			Confirm password : <br>
			<input type="password" name="newPassword" /> <br> <br>
			
			<input type="submit" value="Change password" />
		</form>

		<br> <br>
		
 		<form id="a_form" action="UserSettings" method="POST">
 		
			New email: <br>
			<input type="text" name="newEmail" /> <br> <br>
			
			<input type="submit" value="Change email" />

		</form>

	</body>

</html>