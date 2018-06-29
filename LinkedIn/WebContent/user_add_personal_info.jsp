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

    <title>Add personal information</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_settings_add_info.css" rel="stylesheet">
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
    	<h3>Add your jobs, your education and your skills and let others know you better!</h3>
    </div>
    
    <br> <br>
    
	<div align="center">
		<div class="tabset">
 			<!-- Tab 1 -->
  			<input type="radio" name="tabset" id="tab1" aria-controls="addJob" checked>
  			<label for="tab1">Add job</label>
  
  			<!-- Tab 2 -->
  			<input type="radio" name="tabset" id="tab2" aria-controls="addEducation">
  			<label for="tab2">Add Education</label>
			
  			<!-- Tab 3 -->
  			<input type="radio" name="tabset" id="tab3" aria-controls="addSkill">
  			<label for="tab3">Add skill</label>
  			
  			<div class="tab-panels">
   				<section id="addJob" class="tab-panel">
					<form id="a_form" action="UserAddPersonalInfo?action=job" method="POST">
				
						<br>
						<h3>Add a job</h3>
						<div class="form-group">
			            	<label>Add title
			            		<input class="form-control" type="text" name="title" id="title"
			            		placeholder="Title"
			              		pattern=".{1,60}" title="Maximum length is 60 characters"
			              		required="true" requiredMessage="Please insert a job title">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>Add description
			            		<input class="form-control" type="text" name="description" id="description"
			            		placeholder="Description"
			              		pattern=".{1,60}" title="Maximum length is 60 characters"
			              		required="true" requiredMessage="Please insert a job description">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>From
			            		<input class="form-control" type="date" name="dateFrom"
			              		required="true" requiredMessage="Please insert a job date from">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>To
			            		<input class="form-control" type="date" name="dateTo"
			              		required="true" requiredMessage="Please insert a job date to">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>Choose if you want this job to be public or private <br>
			            		<input type="radio" name="isPrivate" value="false" checked> Public <br>
								<input type="radio" name="isPrivate" value="true"> Private
			            	</label>
			          	</div>
						<button type="submit" class="btn btn btn-outline-success my-2 my-sm-0">Add job</button>
					
					</form>
				</section>
				
   				<section id="addEducation" class="tab-panel">
				 	<form id="a_form" action="UserAddPersonalInfo?action=education" method="POST">
				
						<br>
						<h3>Add an education</h3>
						<div class="form-group">
			            	<label>Add title
			            		<input class="form-control" type="text" name="title" id="title"
			            		placeholder="Title"
			              		pattern=".{1,60}" title="Maximum length is 60 characters"
			              		required="true" requiredMessage="Please insert an education title">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>Add description
			            		<input class="form-control" type="text" name="description" id="description"
			            		placeholder="Description"
			              		pattern=".{1,60}" title="Maximum length is 60 characters"
			              		required="true" requiredMessage="Please insert an education description">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>From
			            		<input class="form-control" type="date" name="dateFrom"
			              		required="true" requiredMessage="Please insert an education date from">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>To
			            		<input class="form-control" type="date" name="dateTo"
			              		required="true" requiredMessage="Please insert an education date to">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>Choose if you want this education to be public or private <br>
			            		<input type="radio" name="isPrivate" value="false" checked> Public <br>
								<input type="radio" name="isPrivate" value="true"> Private
			            	</label>
			          	</div>
						<button type="submit" class="btn btn btn-outline-success my-2 my-sm-0">Add education</button>
						
					</form>
				</section>
				
   				<section id="addSkill" class="tab-panel">
		
					 <form id="a_form" action="UserAddPersonalInfo?action=skill" method="POST">
					 
					 	<br>
					 	<h3>Add a skill</h3>
			          	<div class="form-group">
			            	<label>Add description
			            		<input class="form-control" type="text" name="description" id="description"
			            		placeholder="Description"
			              		pattern=".{1,60}" title="Maximum length is 60 characters"
			              		required="true" requiredMessage="Please insert a skill description">
			            	</label>
			          	</div>
			          	<div class="form-group">
			            	<label>Choose if you want this skill to be public or private <br>
			            		<input type="radio" name="isPrivate" value="false" checked> Public <br>
								<input type="radio" name="isPrivate" value="true"> Private
			            	</label>
			          	</div>
						<button type="submit" class="btn btn btn-outline-success my-2 my-sm-0">Add skill</button>
	
					</form>
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