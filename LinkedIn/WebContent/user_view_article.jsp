<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>View Article</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_comment.css" rel="stylesheet">
    <script>
    	window.onload=function () {
        	var objDiv = document.getElementById("comments-container");
        	objDiv.scrollTop = objDiv.scrollHeight;
   		}
    </script>
</head>

<body>
	<!-- NAVBAR -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow fixed-top">
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

	<!-- DISPLAY-HEADER (WHENEVER NEEDED) -->
    <!-- here -->

	<!-- CONTAINER -->
    <div class="container">
    
    	<div class="row">
    	
    	
    		<!-- NEWSFEED -->
    		<div class="col-md-8">
    		
		    			
		    	<div class="card article-card">
		  			<div class="card-body">
		    			<h5 class="card-title"> ${article.getTitle()}</h5>
					    <p class="card-text"> ${article.getText()} </p>
					    <p class="card-text"><small class="text-muted"> by ${article.getUser().getFirstName()} ${article.getUser().getLastName()} at ${article.getPubDate()} </small></p>
    							
    					<c:if test="${ not empty article.getPicturePath() }">
		  					<img class="card-img-bottom" src="${article.getPicturePath()}" alt="Article-title-1">
		  					<br>
		  				</c:if>
							
						<c:if test="${ not empty article.getVideoPath() }">
							<iframe width="320" height="240" src="${article.getVideoPath()}" frameborder="0" allowfullscreen></iframe>
		  					<br>
		  				</c:if>
		  					
		  				<c:if test="${ not empty article.getAudioPath() }">
		  					<audio controls>
								<source src="${article.getAudioPath()}" type="audio/ogg">
							</audio>
							<br>
		  				</c:if>
		  					  					
	    				<c:if test="${ liked eq false }">
				        	<a href="UserAddLikeArticle?add=true&articleID=${article.getArticleID()}" class="btn btn-primary">Like</a>
	  					</c:if>
	  					<c:if test="${ liked eq true }">
							<a href="UserAddLikeArticle?add=false&articleID=${article.getArticleID()}" class="btn btn-primary">Unlike</a>
	  					</c:if>
	  							
	  				</div>			  					
				</div>
				<main>
			  		<c:if test="${ not empty comments }">
		  				
			  			<div class="comments-container" id="comments-container" align="center">
  								
			  				<ul>	
			  					<c:forEach var="i" begin="0" end="${comments.size()-1}" step="1">
			 						<li class="comment">
				  						<span>
				  							${comments.get(i).getText() }
				  						</span>
				  					</li>
				  					<li class="time-right">
				  						<span>
				  							${comments.get(i).getUser().getFirstName() } ${comments.get(i).getUser().getLastName() } at ${comments.get(i).getPubDate() }
				  						</span>
				  					</li>
				  				</c:forEach>
			  				</ul>
		  				</div>
		  			</c:if>
		  				
		  			<c:if test="${ empty comments }">
		  				<p>No comments yet.</p>
		  			</c:if>
		  				
		  			<div align="right">
		  				<form action="UserAddComment" method="post">
		  					<input type="hidden" name="articleID" value="${ article.getArticleID() }">
		  					<input type="text" name="newComment" placeholder="Comment" 
		  						required requireMessage="Please insert message"
		  						pattern=".{1,1000}" title="Maximum length is 1000 characters">
		  						<button type="submit" class="btn btn btn-outline-success my-2 my-sm-0">Add comment</button>
		  				</form>
		  			</div>
		  		</main>				
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