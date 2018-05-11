<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User"%>

<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Management page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<link rel="stylesheet" href="./css/admin_management.css">
</head>
<body>

	<!-- NAVBAR -->
  	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    	<div class="col-md-4">
      		<a class="navbar-brand" href="#">LinkedIn Clone</a>
      		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        		<span class="navbar-toggler-icon"></span>
      		</button>
    	</div>
    	<div class="col-md-2"></div>
    	<div class="col-md-6">
      		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        		<form class="form-inline my-2 my-lg-0" action="UserLogout" method="post" id="userForm">
          			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log-out</button>
        		</form>
      		</div>
    	</div>
  	</nav>

	<!--  MANAGEMENT PAGE BODY -->
 
	<h1>Users</h1>
	
	<table class="table table-condensed">
	  <thead>
	    <tr>
	      <th><strong>User email</strong></th>
	    </tr>
	  </thead>
	  <tbody>
	  
	 <c:forEach var="i" begin="0" end="${userPerPage}" step="1">
                <tr>
                    <td> <a href="AdminManagement?action=getSpecificUser&email=${users.get(i).email}">${users.get(i).email}</a></td>
                	<td> <input type="checkbox" name="${tempChecked.get(i)}"> </td>
                </tr>
	</c:forEach>
	    	<tr>
	    	<td>
	    	 <%@ include file="./pagination.jsp" %>
			</td>
			</tr>
		</tbody>
	</table>

	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBX5iDXPWX9yVKjUC5FD_hX36CttO5DmzQ&callback=initMap">
    </script>
</body>
</html>