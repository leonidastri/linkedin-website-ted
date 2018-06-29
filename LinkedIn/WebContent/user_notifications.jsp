<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>Notifications</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_notifications.css" rel="stylesheet">
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
  	
    <br>
    
	<div align="center">
		<div class="tabset">
 			 <!-- Tab 1 -->
  			<input type="radio" name="tabset" id="tab1" aria-controls="friendRequests" checked>
  			<label for="tab1">Friend Requests</label>
  			<!-- Tab 2 -->
  			<input type="radio" name="tabset" id="tab2" aria-controls="articleLikes">
  			<label for="tab2">Article Likes</label>
  			 <!-- Tab 3 -->
  			<input type="radio" name="tabset" id="tab3" aria-controls="listingLikes" checked>
  			<label for="tab1">Listing Likes</label>
  			<!-- Tab 4 -->
  			<input type="radio" name="tabset" id="tab4" aria-controls="articleComments">
  			<label for="tab2">Article Likes</label>
  			
			<div class="tab-panels">
   				<section id="firendRequests" class="tab-panel">
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
		    	</section>

				<section id="articleLikes" class="tab-panel">
		            <table class="table table-sm table-hover table-striped">
		            	<tbody>                                  
		                	<c:if test="${likeArticles.size() != 0}">
								<c:forEach var="i" begin="0" end="${likeArticles.size()-1}" step="1">
									<tr>
										<td>
				                        	<a href="UserProfile?action=OtherUserProfile&email=${likeArticles.get(i).getUser().getEmail()}"> ${likeArticles.get(i).getUser().getEmail()} </a> 
				                        </td>
				                    	<td>
				                        	${likeArticles.get(i).getUser().getFirstName()}
				                        </td>
				                        <td>
				                        	${likeArticles.get(i).getUser().getLastName()}
				                        </td>
				                        <td>
				                        	<p> liked article ${likeArticles.get(i).getArticle().getTitle()} </p>
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
		    	</section>
    		
    			<section id="listingLikes" class="tab-panel">
	   				<table class="table table-sm table-hover table-striped">
		            	<tbody>                                  
		                	<c:if test="${likeListings.size() != 0}">
								<c:forEach var="i" begin="0" end="${likeListings.size()-1}" step="1">
									<tr>
				                    	<td>
				                        	<a href="UserProfile?action=OtherUserProfile&email=${likeListings.get(i).getUser().getEmail()}"> ${likeListings.get(i).getUser().getEmail()} </a> 
				                        </td>
				                        <td>
				                        	${likeListings.get(i).getUser().getFirstName()}
				                        </td>
				                        <td>
				                        	${likeListings.get(i).getUser().getLastName()}
				                        </td>
				                        <td>
				                        	<p> liked listing ${likeListings.get(i).getListing().getTitle()} </p>
				                   		</td>
				                    </tr>
			                   	</c:forEach>
							</c:if>
							<c:if test="${likeListings.size() == 0}">
								<tr>
									<td>
										<p>No likes yet in your listings</p>
									</td>
								</tr>
							</c:if>
		               </tbody>
		          	</table>
		    	</section>
   				 
   				
				<section id="articleComments" class="tab-panel">
	   				<table class="table table-sm table-hover table-striped">
		                <tbody>                                  
		                    <c:if test="${comments.size() != 0}">
								<c:forEach var="i" begin="0" end="${comments.size()-1}" step="1">
									<tr>
				                        <td>
				                            <a href="UserProfile?email=${comments.get(i).getUser().getEmail()}&action=OtherUserProfile">${comments.get(i).getUser().getFirstName()}</a>
				                         	
				                        </td>
				                        <td>
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
		        </section>
	    	</div>
	    </div>
	</div>
			
    <div class="container">			
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