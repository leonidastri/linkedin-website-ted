<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*, model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
  		<title> User Messenger </title>
  		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	</head>
	<body>

		<div align="center">
			<h3> User Messenger </h3> <br> <br>
			
			<h4> List of users to chat with: </h4>
				
			<c:if test="${networkUsers.size() != 0}">
			
				<table>
			     	<c:forEach var="i" begin="0" end="${networkUsers.size()-1}" step="1">
			     		<tr>
		       				<td>
		       					<a href="UserMessenger?receiverID=${networkUsers.get(i).getUserID()}"> ${networkUsers.get(i).getFirstName()} ${networkUsers.get(i).getEmail()} </a>
		       				</td>
		       			</tr>
					</c:forEach>
				</table>
				
			</c:if>
				
		</div>

</html>