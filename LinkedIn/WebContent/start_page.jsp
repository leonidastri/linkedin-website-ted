<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>LinkedIn</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/start_page.css" rel="stylesheet">
</head>
<body>
	<!-- NAVBAR -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h3 class="my-0 mr-md-auto font-weight-normal">LinkedIn</h3>
      	<nav class="my-2 my-md-0 mr-md-3">
        	<form class="form-inline my-2 my-lg-0" action="UserLogin" method="post" id="loginForm">
	          <input class="form-control mr-sm-2" id="email" name="email"
	              placeholder="Email Address" type="email"
	              validatorMessage="Maximum length is 100 characters"
	              required="true" requiredMessage="Please insert an email address" >
	          <input class="form-control mr-sm-2" id="password" name="password"
	              placeholder="Password" type="password"
	              validatorMessage="Maximum length is 30 characters"
	              required="true" requiredMessage="Please insert a password" >
	          <button class="btn btn-primary my-2 my-sm-0" type="submit">Log-in</button>
	        </form>
      	</nav>
    </div>
	
	<!-- DISPLAY-HEADER (WHENEVER NEEDED) -->
    <!-- here -->

	<!-- CONTAINER -->
    <div class="container">

		<!-- REGISTER -->
		<div class="bgimg">
			<br> <br> <br>
		    <div align="center" class ="register-container">
		      	<form class="form-signin" action="UserRegister" method="post" id="registerForm" enctype = "multipart/form-data">
		        	<h3>Get started - it's free.</h3>
		        	<hr>
		          	<div class="form-group">
		            	<label>Email address
		            		<input class="form-control" id="email" name="email"
		              		placeholder="Email address" type="email"
		              		pattern=".{1,100}" title="Maximum length is 100 characters"
		              		required="true" requiredMessage="Please insert an email address">
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>Password
		            		<input class="form-control" id="password" name="password"
		              		placeholder="Password" type="password"
		              		pattern=".{1,30}" title="Maximum length is 30 characters"
		              		required="true" requiredMessage="Please insert a password">
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>Confirm password
		            		<input class="form-control" id="confirmPassword" name="confirmPassword"
		              		placeholder="Confirm password" type="password"
		              		pattern=".{1,30}" title="Maximum length is 30 characters"
		              		required="true" requiredMessage="Please confirm a password">
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>First name
		            		<input class="form-control" id="firstName" name="firstName"
		              		placeholder="First name" type="text"
		              		pattern=".{1,60}" title="Maximum length is 60 characters"
		              		required="true" requiredMessage="Please insert a first name">
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>Last name
		            		<input class="form-control" id="lastName" name="lastName"
		              		placeholder="Last name" type="text"
		              		pattern=".{1,60}" title="Maximum length is 60 characters"
		              		required="true" requiredMessage="Please insert a last name">
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>Phone number
		            		<input class="form-control" id="phoneNumber" name="phoneNumber"
		              		placeholder="Phone number" type="tel"
		              		pattern=".{1,30}" title="Maximum length is 30 characters"
		              		required="true" requiredMessage="Please insert a phone number">
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>Choose CV file
		            		<input class="form-control" id="cv" name="cv" type="file"
		              		accept="application/pdf" >
		            	</label>
		          	</div>
		          	<div class="form-group">
		            	<label>Choose photo file
		            		<input class="form-control" id="photo" name="photo" type="file"
		              		accept="image/jpeg,image/gif,image/png,application/pdf,image/x-eps" >
		            	</label>
		          	</div>
		
		          	<button type="submit" class="btn btn btn-primary my-2 my-sm-0">Join now</button>
		      	</form>
		    </div>
			<br> <br> <br> <br> <br> <br>
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