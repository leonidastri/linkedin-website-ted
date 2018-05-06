<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<br> <br> <br>
	
	<div class="register-container" align="center">
		<h1> List of registered users </h1>
	 
		<%
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>)request.getAttribute("users");
			int numberOfPages = (int) request.getAttribute("numberOfPages");
		%>
	 
	 <br> <br>
	 
	<table>
	    <tr bgcolor="orange">
	        <td><strong>User email</strong></td>
	    </tr>
	    <%
	    	for (User user : users) {
	    %>
	    <tr>
	    	<td>
	       		<%= user.getEmail() %>
	        </td>
	    </tr>
	    <%
	        }
	    %>
	  
	    <tr>
	        <td align="right">
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
	</div>
	
	<br> <br> <br>
	
  <!-- FOOTER -->
  <footer class="footer" style="background-color: lightgrey;">
    <div class="container" >
      <div class=row>
        <div class="col-md-4"></div>
      <div class="col-md-2">
        <h4>About Us</h4>
        <a href="#"><p style="margin-bottom: 3px;">About</p></a>
        <a href="#"><p style="margin-bottom: 3px;">News</p></a>
        <a href="#"><p style="margin-bottom: 3px;">Services</p></a>
        <a href="#"><p style="margin-bottom: 3px;">FAQ</p></a>
      </div>
      <div class="col-md-2">
        <h4>Contact Us</h4>
        <p>tel  : 210 8898985 <br/>
          fax: 210 8898900 <br/>
          email: tm39@li.com</p>
        </div>
        <div class="col-md-4"></div>

      </div>  <br>
      <div class="footer-bottom">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <!--Footer Bottom-->
              <p class="text-center">&copy; Copyright 2018 - University of Athens Di.  All rights reserved.</p>
            </div>
          </div>
        </div>
      </div>
    </footer>

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