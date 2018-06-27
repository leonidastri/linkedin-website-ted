<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*,java.math.*,model.User,model.Job,model.Skill,model.Education,model.Listing,model.Comment,model.Article,model.LikeArticle,model.LikeListing"%>
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

    <title>Profile</title>

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
    
    <div class=:container">
    	<div align="center">
		    <c:if test="${not empty userID2}">
		    	<br>
		    	<a class="btn btn-primary" href="UserMessenger?receiverID=${userID2}" role="button"> Send message </a>
		  	</c:if>
		  	
		  	<br>
		    
		    <c:if test="${not empty userID2}">
		    	<br>
		    	<c:if test="${empty noFriendRequest}">
		    		<a class="btn btn-primary" href="UserSendFriendRequest?userID2=${userID2}&email=${email}" role="button"> Add to friends </a>
		  		</c:if>
			</c:if>
		</div>
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
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Jobs</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>
										<c:if test="${jobs.size() != 0}">
											<c:if test="${jobs.size() <= 3}">
												<c:forEach var="i" begin="0" end="${jobs.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${jobs.get(i).getJobTitle()}</strong> from <strong><fmt:formatDate value="${jobs.get(i).getJobFrom()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong> to <strong><fmt:formatDate value="${jobs.get(i).getJobTo()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                            	<p>${jobs.get(i).getJobDescription()}</p>
			                                        	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${jobs.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${jobs.get(i).getJobTitle()}</strong> from <strong><fmt:formatDate value="${jobs.get(i).getJobFrom()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong> to <strong><fmt:formatDate value="${jobs.get(i).getJobTo()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                            	<p>${jobs.get(i).getJobDescription()}</p>
			                                        	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=jobs&email=${email}" role="button">Show all jobs</a>
	                                    	</c:if>
										</c:if>
										<c:if test="${jobs.size() == 0}">
											<tr>
												<td>
													<p>No jobs provided yet</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Education</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                
	                                    <c:if test="${education.size() != 0}">
											<c:if test="${education.size() <= 3}">
												<c:forEach var="i" begin="0" end="${education.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${education.get(i).getEducationTitle()}</strong> from <strong><fmt:formatDate value="${education.get(i).getEducationFrom()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong> to <strong><fmt:formatDate value="${education.get(i).getEducationTo()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                            	<p>${education.get(i).getEducationDescription()}</p>
			                                        	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${education.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${education.get(i).getEducationTitle()}</strong> from <strong><fmt:formatDate value="${education.get(i).getEducationFrom()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong> to <strong><fmt:formatDate value="${education.get(i).getEducationTo()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                            	<p>${education.get(i).getEducationDescription()}</p>
			                                        	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=education&email=${email}" role="button">Show all education</a>
	                                    	</c:if>
										</c:if>
										<c:if test="${education.size() == 0}">
											<tr>
												<td>
													<p>No education provided yet</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Skills</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <c:if test="${skills.size() != 0}">
											<c:if test="${skills.size() <= 3}">
												<c:forEach var="i" begin="0" end="${skills.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${skills.get(i).getSkill()}</strong>
			                                            </td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${skills.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${skills.get(i).getSkill()}</strong>
			                                            </td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=skills&email=${email}" role="button">Show all skills</a>
	                                    	</c:if>
										</c:if>
										<c:if test="${skills.size() == 0}">
											<tr>
												<td>
													<p>No skills provided yet</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Articles</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <c:if test="${articles.size() != 0}">
											<c:if test="${articles.size() <= 3}">
												<c:forEach var="i" begin="0" end="${articles.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${articles.get(i).getTitle()}</strong> published <strong><fmt:formatDate value="${articles.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${articles.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${articles.get(i).getTitle()}</strong> published <strong><fmt:formatDate value="${articles.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=articles&email=${email}" role="button">Show all articles</a>
	                                    	</c:if>
										</c:if>
										<c:if test="${articles.size() == 0}">
											<tr>
												<td>
													<p>No articles published yet</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Listings</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                  
	                                    <c:if test="${listings.size() != 0}">
											<c:if test="${listings.size() <= 3}">
												<c:forEach var="i" begin="0" end="${listings.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${listings.get(i).getTitle()}</strong> published <strong><fmt:formatDate value="${listings.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           		<p>${listings.get(i).getDescription()}</p>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${listings.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${listings.get(i).getTitle()}</strong> published <strong><fmt:formatDate value="${listings.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           		<p>${listings.get(i).getDescription()}</p>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=listings&email=${email}" role="button">Show all listings</a>
	                                    	</c:if>
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
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Comments</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>
	                                    <c:if test="${comments.size() != 0}">
											<c:if test="${comments.size() <= 3}">
												<c:forEach var="i" begin="0" end="${comments.size()-1}" step="1">
													<tr>
			                                        	<!-- substring source: https://stackoverflow.com/questions/1583940/how-do-i-get-the-first-n-characters-of-a-string-without-checking-the-size-or-goi -->
			                                        	<td>
			                                            	<strong>${comments.get(i).getText().substring(0, Math.min(comments.get(i).getText().length(), 20))}</strong> published <strong><fmt:formatDate value="${comments.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${comments.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<!-- substring source: https://stackoverflow.com/questions/1583940/how-do-i-get-the-first-n-characters-of-a-string-without-checking-the-size-or-goi -->
			                                        	<td>
			                                            	<strong>${comments.get(i).getText().substring(0, Math.min(comments.get(i).getText().length(), 20))}</strong> published <strong><fmt:formatDate value="${comments.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=comments&email=${email}" role="button">Show all comments</a>
	                                    	</c:if>
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
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Liked Articles</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>
	                                    <c:if test="${likedArticlesDetails.size() != 0}">
											<c:if test="${likedArticlesDetails.size() <= 3}">
												<c:forEach var="i" begin="0" end="${likedArticlesDetails.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${likedArticlesDetails.get(i).getTitle()}</strong> published by <strong>${likedArticlesDetails.get(i).getUser().getFirstName} ${likedArticlesDetails.get(i).getUser().getLastName}</strong> at <strong><fmt:formatDate value="${likedArticlesDetails.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${likedArticlesDetails.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${likedArticlesDetails.get(i).getTitle()}</strong> published by <strong>${likedArticlesDetails.get(i).getUser().getFirstName} ${likedArticlesDetails.get(i).getUser().getLastName}</strong> at <strong><fmt:formatDate value="${likedArticlesDetails.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=liked_articles&email=${email}" role="button">Show all liked articles</a>
	                                    	</c:if>
										</c:if>
										<c:if test="${likedArticlesDetails.size() == 0}">
											<tr>
												<td>
													<p>No articles liked so far</p>
												</td>
											</tr>
										</c:if>
	                                </tbody>
	                            </table>
	                        </div>
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Liked Listings</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>
	                                   <c:if test="${likedListingsDetails.size() != 0}">
											<c:if test="${likedListingsDetails.size() <= 3}">
												<c:forEach var="i" begin="0" end="${likedListingsDetails.size()-1}" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${likedListingsDetails.get(i).getTitle()}</strong> published by <strong>${likedListingsDetails.get(i).getUser().getFirstName} ${likedListingsDetails.get(i).getUser().getLastName}</strong> at <strong><fmt:formatDate value="${likedListingsDetails.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
	                                    	</c:if>
	                                    	<c:if test="${likedListingsDetails.size() > 3}">
												<c:forEach var="i" begin="0" end="2" step="1">
													<tr>
			                                        	<td>
			                                            	<strong>${likedListingsDetails.get(i).getTitle()}</strong> published by <strong>${likedListingsDetails.get(i).getUser().getFirstName} ${likedListingsDetails.get(i).getUser().getLastName}</strong> at <strong><fmt:formatDate value="${likedListingsDetails.get(i).getPubDate()}" pattern="yyyy-MM-dd HH:mm:ss" /></strong>
			                                           	</td>
			                                    	</tr>
		                                    	</c:forEach>
		                                    	<!-- TODO -->
		                                    	<a class="btn btn-primary" href="UserProfileShowAll?action=liked_listings&email=${email}" role="button">Show all liked listings</a>
	                                    	</c:if>
										</c:if>
										<c:if test="${likedListingsDetails.size() == 0}">
											<tr>
												<td>
													<p>No listings liked so far</p>
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
	            <h6 class="mt-2">Upload a new photo</h6>
	            <form class="form-photoFileFromProfile" action="UploadPhotoFromProfile" method="post" id="profileUploadPhotoForm" enctype = "multipart/form-data">
	            	<label class="custom-file">Choose new photo file
		                <input class="form-control" id="photo" name="photo" type="file"
	              		accept="image/jpeg,image/gif,image/png,application/pdf,image/x-eps" >
	            	</label>
		        </form>
	            <br>
	            <br>
	        	<h5>Email:</h5>
	        	<p>${user.getEmail()}</p>
	        	<h5>Phone:</h5>
	        	<p>${user.getPhoneNumber()}</p>
	        	<c:if test="${!user.getCvPath().equals(\"\")}">
	        		<h6><a href="${user.getCvPath()}">Curriculum Vitae</a></h6>
	        	</c:if>
	        	<c:if test="${user.getCvPath().equals(\"\")}">
	        		<h6>Curriculum Vitae</h6>
	        	</c:if>
	            <h6 class="mt-2">Upload a new CV</h6>
		        <form class="form-cvFileFromProfile" action="UploadCvFromProfile" method="post" id="profileUploadCvForm" enctype = "multipart/form-data">
	            	<label class="custom-file">Choose new CV file
		                <input class="form-control" id="cv" name="cv" type="file"
	              		accept="application/pdf" >
		            </label>
		        </form>
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