<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>

<!DOCTYPE html>
<html>
<head>
  	<link rel="icon" href="../images/toplogo.png">
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User homepage</title>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">
</head>
<body>

	<nav class="my-2 my-md-0 mr-md-3">
	
    	<a class="p-2 text-light" href="UserNavigation?action=Homepage"> Homepage </a>
        <a class="p-2 text-light" href="UserNavigation?action=Connections"> Connections </a>
        <a class="p-2 text-light" href="UserNavigation?action=Listings"> Listings </a>
        <a class="p-2 text-light" href="UserNavigation?action=Messenger"> Messenger </a>
        <a class="p-2 text-light" href="UserNavigation?action=Personal info"> Personal info </a>
        <a class="p-2 text-light" href="UserNavigation?action=Settings"> Settings </a>  
    
    	<form class="form-inline my-2 my-lg-0" action="UserLogout" method="post" id="userForm">
    		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log-out</button>
    	</form>
    	
	</nav>
  	
	<!--  HOMEPAGE BODY -->
	<% User user = (User) request.getAttribute("user"); %>
	<p>Hello <%= user.getFirstName() %>!</p>
	
	<br> <br>
	<form class="form-inline my-2 my-lg-0" action="UserProfile" method="get" id="Profile">
    	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Profile page</button>
    </form>
	<br>
	<form class="form-inline my-2 my-lg-0" action="" method="post" id="userForm">
    	<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Connections</button>
    </form>
	
	
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