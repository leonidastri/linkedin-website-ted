<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Specific User</title>
</head>
<body>

	<hr><ol> 
	 <li> ${user.userID} </li>
	 <li> ${user.firstName} </li>
	 <li> ${user.lastName} </li>
	 <li> ${user.email} </li>
	 <li> ${user.phoneNumber} </li>
    </ol><hr>

</body>
</html>