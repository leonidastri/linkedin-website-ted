<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,model.User,model.Listing"%>
<!-- source: https://stackoverflow.com/questions/6162401/convert-and-format-a-date-in-jsp?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>All Listings</title>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">
  
</head>
<body>

	<!-- NAVBAR -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">LinkedIn</h5>
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

	<div class="container">
	    <div class="row my-2">
	        <div class="col-lg-8 order-lg-2">
	            <div class="tab-content py-4">
	                <div class="tab-pane active" id="profile">
	                    <div class="row">
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>People who want to connect with you</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                  
	                                    <c:if test="${unansweredCons.size() != 0}">
											<c:forEach var="i" begin="0" end="${unansweredCons.size()-1}" step="1">
												<tr>
			                                        <td>
			                                            <a href="UserProfile?email=${unansweredCons.get(i).getUser1().getEmail()}&action=OtherUserProfile">${unansweredCons.get(i).getUser1().getFirstName()}</a>
			                                        	
			                                        	<form action="UserNavigation" method="get">
														  	<button type="submit" id="acceptFriend" name="acceptFriend" value="true">Accept</button>
															<button type="submit" id="acceptFriend" name="acceptFriend" value="false">Ignore</button>
															<input type="hidden" name="otherUserID" value="${unansweredCons.get(i).getUser1().getUserID()}">
  															<input type="hidden" name="action" value="Notifications">
														</form>
														 
													</td>
			                                    </tr>
		                                    </c:forEach>
										</c:if>
										<c:if test="${unansweredCons.size() == 0}">
											<tr>
												<td>
													<p>No friend request yet</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                    
						</div>
						
						<div class="row">
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Liked Article Notifications </h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                  
	                                    <c:if test="${likeArticles.size() != 0}">
											<c:forEach var="i" begin="0" end="${likeArticles.size()-1}" step="1">
												<tr>
			                                        <td>
			                                            <a href="UserProfile?email=${likeArticles.get(i).getUser().getEmail()}&action=OtherUserProfile">${likeArticles.get(i).getUser().getFirstName()}</a>
			                                        	<p> liked ${likeArticles.get(i).getArticle().getTitle()} </p>
			                                        </td>
			                                    </tr>
		                                    </c:forEach>
										</c:if>
										<c:if test="${likeArticles.size() == 0}">
											<tr>
												<td>
													<p>No likes yet in your articles</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                        	                    
						</div>
						
						<div class="row">
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Comments Notifications </h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                  
	                                    <c:if test="${comments.size() != 0}">
											<c:forEach var="i" begin="0" end="${comments.size()-1}" step="1">
												<tr>
			                                        <td>
			                                            <a href="UserProfile?email=${comments.get(i).getUser().getEmail()}&action=OtherUserProfile">${comments.get(i).getUser().getFirstName()}</a>
			                                        	<p> commented ${comments.get(i).getArticle().getTitle()} </p>
			                                        </td>
			                                    </tr>
		                                    </c:forEach>
										</c:if>
										<c:if test="${comments.size() == 0}">
											<tr>
												<td>
													<p>No comments yet in your articles</p>
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