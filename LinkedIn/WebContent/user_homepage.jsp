<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User homepage</title>
</head>
<body>
	<% User user = (User) request.getAttribute("user"); %>
	<p>Hello <%= user.getFirstName() %>!</p>
</body>
</html>