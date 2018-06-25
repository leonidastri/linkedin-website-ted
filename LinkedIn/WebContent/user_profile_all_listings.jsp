<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User,model.Listing"%>
<!-- source: https://stackoverflow.com/questions/6162401/convert-and-format-a-date-in-jsp?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>All Listings</title>
  	
    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_profile.css" rel="stylesheet">
</head>
<body>
	<!-- NAVBAR -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h3 class="my-0 mr-md-auto font-weight-normal">LinkedIn</h3>
      	<nav class="my-2 my-md-0 mr-md-3">
        	<a class="p-2 text-dark" href="UserNavigation?action=Homepage">Home-page</a>
        	<a class="p-2 text-dark" href="UserNavigation?action=Network">Network</a>
        	<a class="p-2 text-dark" href="UserNavigation?action=Listings">Listings</a>
        	<a class="p-2 text-dark" href="UserNavigation?action=Notifications">Notifications</a>
        	<a class="p-2 text-dark" href="UserNavigation?action=Messenger">Messenger</a>
        	<a class="p-2 text-dark" href="UserNavigation?action=Personal Details">Personal Details</a>
        	<a class="p-2 text-dark" href="UserNavigation?action=Settings">Settings</a>
      	</nav>
      	<a class="btn btn-outline-primary" href="UserLogout">Sign out</a>
    </div>

	<!-- source: https://www.codeply.com/go/5Lu0E8graQ -->

	<!-- DISPLAY-HEADER (WHENEVER NEEDED) -->
    <div class="px-4 py-4 pt-md-4 pb-md-4 mx-auto text-center">
      <h1 class="display-5">${user.getFirstName()} ${user.getLastName()}</h1>
    </div>
	<br>

	<!-- CONTAINER -->
    <div class="container">
    
    	<div class="row">
	        <div class="col-lg-8 order-lg-2">
	            <div class="tab-content py-4">
	                <div class="tab-pane active" id="profile">
	                    <div class="row">
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Listings</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                  
	                                    <c:if test="${listings.size() != 0}">
											<c:forEach var="i" begin="0" end="${listings.size()-1}" step="1">
												<tr>
			                                        <td>
			                                            <strong>${listings.get(i).getTitle()}</strong> published <strong><fmt:formatDate value="${listings.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	<p>${listings.get(i).getDescription()}</p>
			                                        </td>
			                                    </tr>
		                                    </c:forEach>
										</c:if>
										<c:if test="${listings.size() == 0}">
											<tr>
												<td>
													<p>No listings published yet</p>
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

		<!-- FOOTER -->
		<footer class="pt-4 my-md-5 pt-md-5 border-top">
	    	<div class="row">
	          	<div class="col-12 col-md">
	            	<img class="mb-2" src="https://getbootstrap.com/assets/brand/bootstrap-solid.svg" alt="" width="24" height="24">
	            	<small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
	          	</div>
	          	<div class="col-6 col-md">
	            	<h5>Spotlight</h5>
	            	<ul class="list-unstyled text-small">
		              	<li><a class="text-muted" href="#">Article of the day</a></li>
		              	<li><a class="text-muted" href="#">Listing of the day</a></li>
		              	<li><a class="text-muted" href="#">User of the day</a></li>
	            	</ul>
	          	</div>
	          	<div class="col-6 col-md">
	            	<h5>Resources</h5>
	            	<ul class="list-unstyled text-small">
		              	<li><a class="text-muted" href="#">Organization guide</a></li>
		              	<li><a class="text-muted" href="#">User guide</a></li>
	            	</ul>
	          	</div>
	          	<div class="col-6 col-md">
	            	<h5>About</h5>
	            	<ul class="list-unstyled text-small">
		              	<li><a class="text-muted" href="#">About LinkedIn</a></li>
		              	<li><a class="text-muted" href="#">Privacy</a></li>
		              	<li><a class="text-muted" href="#">Terms</a></li>
	            	</ul>
	          	</div>
			</div>
		</footer>
		
    </div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../assets/js/vendor/popper.min.js"></script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <script src="../../assets/js/vendor/holder.min.js"></script>
    <script>
      Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
      });
    </script>
</body>
</html>