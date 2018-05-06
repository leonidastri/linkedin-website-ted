<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,model.User"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagination In Servlets - www.javaworkspace.com</title>
</head>
<body>
 
<h1>Pagination In Servlets</h1>
 
<%
	@SuppressWarnings("unchecked")
	List<User> users = (List<User>)request.getAttribute("users");
	int numberOfPages = (int) request.getAttribute("numberOfPages");
%>
 
<table border="1">
    <tr bgcolor="orange">
        <td><strong>User email</strong></td>
    </tr>
    <%
    	for (User user : users) {
    %>
    	<tr>
       	<%= user.getEmail() %>
        </tr>
    <%
        }
    %>
 
    <tr>
        <td colspan="4" align="right">
        <form method="get" action="AdminManagement">
        <table>
            <tr>
                <%
                    for (int i = 1; i <= numberOfPages; i++) {
                %>
                <td><a href="AdminManagement?pageNumber=<%=i%>"><%=i%></a></td>
                <%
                    }
                %>
            </tr>
        </table>
        </form>
        </td>
    </tr>
</table>

</body>
</html>