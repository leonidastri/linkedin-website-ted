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

    <title>Home-page</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_homepage.css" rel="stylesheet">
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

	<!-- DISPLAY-HEADER (WHENEVER NEEDED) -->
    <!-- here -->

	<!-- CONTAINER -->
    <div class="container">
    
    	<div class="row">
    	
    		<!-- PERSONAL DETAILS AND NETWORK -->
    		<div class="col-md-2">
    			<h4> Hello ${firstname}! </h4>
    			<a class="btn btn-primary" href="UserProfile?action=UserProfile" role="button">Check Profile</a>
				<br>
				<a class="btn btn-primary" href="UserProfile?action=Network" role="button">Your Network</a>
    		</div>
    	
    		<!-- NEWSFEED -->
    		<div class="col-md-8">
    		
    			<!-- TOP 20 RESULTS -->
    			<div class="card article-card">
  					<div class="card-body">
    					<h5 class="card-title">Article title 1</h5>
					    <p class="card-text">Article text 1......................</p>
					    <p class="card-text"><small class="text-muted">Uploaded at upload time 1</small></p>
  					</div>
  					<img class="card-img-bottom" src=".../100px180/" alt="Article-title-1">
				</div>
    			<div class="card article-card">
  					<div class="card-body">
    					<h5 class="card-title">Article title 2</h5>
					    <p class="card-text">Article text 2......................</p>
					    <p class="card-text"><small class="text-muted">Uploaded at upload time 2</small></p>
  					</div>
  					<img class="card-img-bottom" src=".../100px180/" alt="Article-title-2">
				</div>
    			<div class="card article-card">
  					<div class="card-body">
    					<h5 class="card-title">Article title 3</h5>
					    <p class="card-text">Article text 3......................</p>
					    <p class="card-text"><small class="text-muted">Uploaded at upload time 3</small></p>
  					</div>
  					<img class="card-img-bottom" src=".../100px180/" alt="Article-title-3">
				</div>
				
				<!-- TODO: SEE ALL RESULTS -->
				<div align="center">
		        	<a class="btn btn-primary" href="UserShowCompleteNewsfeed?email=${email}" role="button">Show complete newsfeed</a>
				</div>
    		</div>
    	
    	
    		<!-- INSERT NEW ARTICLE -->
    		<div class="col-md-2">
    			<form action="UserUploadArticle" method="post" id="userUploadArticleForm" enctype = "multipart/form-data">
    				<div class="form-group">
			            <label> Title
			            <input class="form-control" id="title" name="title"
			              placeholder="Title" type="text"
			              pattern=".{1,100}" title="Maximum length is 100 characters"
			              required="true" requiredMessage="Please insert a title">
			            </label>
			        </div>
			        <div class="form-group">
			            <label> Text
			            <input class="form-control" id="text" name="text"
			              placeholder="Text" type="text"
			              pattern=".{1,100}" title="Maximum length is 100 characters"
			              required="true" requiredMessage="Please insert the text">
			            </label>
			        </div>
			        <div class="form-group">
			            <label> Audio
			            <input class="form-control" id="audio" name="audio" type="file"
			              accept="audio/*" >
			              <span class="form-control">Choose Audio file</span>
			            </label>
			        </div>
			        <div class="form-group">
			            <label> Photo
			            <input class="form-control" id="photo" name="photo" type="file"
			              accept="image/jpeg,image/gif,image/png,application/pdf,image/x-eps" >
			              <span class="form-control">Choose Photo file</span>
			            </label>
			        </div>
			        <div class="form-group">
			            <label> Video
			            <input class="form-control" id="video" name="video" type="file"
			              accept="video/*" >
			              <span class="form-control">Choose Video file</span>
			            </label>
			        </div>
			        
			        <button type="submit" class="btn btn btn-outline-success my-2 my-sm-0">Publish</button>
    			</form>
    		</div>
    	
    	</div>

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
