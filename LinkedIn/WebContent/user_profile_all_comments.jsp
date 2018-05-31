<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User,model.Comment"%>
<!-- source: https://stackoverflow.com/questions/6162401/convert-and-format-a-date-in-jsp?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>All Comments</title>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">
  
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
  	
	<!-- source: https://www.codeply.com/go/5Lu0E8graQ -->

	<div class="pricing-header px-4 py-4 pt-md-4 pb-md-4 mx-auto text-center">
      <h1 class="display-5">${user.getFirstName()} ${user.getLastName()}</h1>
    </div>

	<div class="container">
	    <div class="row my-2">
	        <div class="col-lg-8 order-lg-2">
	            <div class="tab-content py-4">
	                <div class="tab-pane active" id="profile">
	                    <div class="row">
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Comments</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>
	                                    <c:if test="${comments.size() != 0}">
											<c:forEach var="i" begin="0" end="${comments.size()-1}" step="1">
												<tr>
			                                        <!-- substring source: https://stackoverflow.com/questions/1583940/how-do-i-get-the-first-n-characters-of-a-string-without-checking-the-size-or-goi -->
			                                        <td>
			                                            <strong>${comments.get(i).getText().substring(0, Math.min(comments.get(i).getText().length(), 20))}</strong> published <strong><fmt:formatDate value="${comments.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                        </td>
			                                    </tr>
		                                    </c:forEach>
										</c:if>
										<c:if test="${comments.size() == 0}">
											<tr>
												<td>
													<p>No comments published yet</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                    
						</div>
	               	</div>
	         	</div>
	       	</div>
	       	
	        <div class="col-lg-4 order-lg-1 text-center">
	            <img src="${user.getPhotoPath()}" class="mx-auto img-fluid img-circle d-block" alt="avatar">
	            <h6 class="mt-2">Upload a different photo</h6>
	            <label class="custom-file">
	                <input type="file" id="file" class="custom-file-input">
	                <span class="custom-file-control">Choose file</span>
	            </label>
	            <br>
	            <br>
	            <br>
	        	<h5>Email:</h5>
	        	<p>${user.getEmail()}</p>
	        	<h5>Phone:</h5>
	        	<p>${user.getPhoneNumber()}</p>
	        	<h6><a href="${user.getCvPath()}">Curriculum Vitae</a></h6>
	        </div>
	    </div>
	</div>

    
	<!-- FOOTER -->
  	<footer class="footer" style="background-color: lightgrey;padding-top: 50px;">
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