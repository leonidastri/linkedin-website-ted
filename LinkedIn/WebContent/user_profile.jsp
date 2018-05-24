<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,model.User,model.Article,model.Comment,model.Job,model.Skill,model.Education"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Profile</title>
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
      <h1 class="display-5">John Doe</h1>
    </div>

	<div class="container">
	    <div class="row my-2">
	        <div class="col-lg-8 order-lg-2">
	            <div class="tab-content py-4">
	                <div class="tab-pane active" id="profile">
	                    <div class="row">
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Jobs</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Job Title 1</strong> from <strong>start_date1</strong> to <strong>end_date1</strong>
	                                            <p>Job Description 1</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Job Title 2</strong> from <strong>start_date2</strong> to <strong>end_date2</strong>
	                                            <p>Job Description2</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Job Title 3</strong> from <strong>start_date3</strong> to <strong>end_date3</strong>
	                                            <p>Job Description 3</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Job Title 4</strong> from <strong>start_date4</strong> to <strong>end_date4</strong>
	                                            <p>Job Description 4</p>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Education</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Education Title 1</strong> from <strong>start_date1</strong> to <strong>end_date1</strong>
	                                            <p>Education Description 1 </p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Education Title 2</strong> from <strong>start_date2</strong> to <strong>end_date2</strong>
	                                            <p>Education Description 2</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Education Title 3</strong> from <strong>start_date3</strong> to <strong>end_date3</strong>
	                                            <p>Education Description 3</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Education Title 4</strong> from <strong>start_date4</strong> to <strong>end_date4</strong>
	                                            <p>Education Description 4</p>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                    
	                    	
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Skills</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
												<strong>Skill 1</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
												<strong>Skill 2</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
												<strong>Skill 3 </strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
												<strong>Skill 4</strong>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                    
	                    	<div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Articles</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Article Title 1</strong> published at <strong>pub_date1</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Article Title 2</strong> published at <strong>pub_date2</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Article Title 3</strong> published at <strong>pub_date3</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Article Title 4</strong> published at <strong>pub_date4</strong>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Listings</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 1</strong> published at <strong>pub_date1</strong>
	                                        	<p>Description 1</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 2</strong> published at <strong>pub_date2</strong>
	                                        	<p>Description 2</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 3</strong> published at <strong>pub_date3</strong>
	                                        	<p>Description 3</p>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 4</strong> published at <strong>pub_date4</strong>
	                                        	<p>Description 4</p>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Comments</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Substring of comment 1...</strong> at <strong>pub_date1</strong>
	                                        </td>
	                                    </tr>                                   
	                                    <tr>
	                                        <td>
	                                            <strong>Substring of comment 2...</strong> at <strong>pub_date2</strong>
	                                        </td>
	                                    </tr>                                   
	                                    <tr>
	                                        <td>
	                                            <strong>Substring of comment 3...</strong> at <strong>pub_date3</strong>
	                                        </td>
	                                    </tr>                                   
	                                    <tr>
	                                        <td>
	                                            <strong>Substring of comment 4...</strong> at <strong>pub_date4</strong>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        
	                        
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Liked Articles</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Title1</strong> published by <strong>Author1</strong> at <strong>pub_date1</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Title2</strong> published by <strong>Author2</strong> at <strong>pub_date2</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Title3</strong> published by <strong>Author3</strong> at <strong>pub_date3</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Title4</strong> published by <strong>Author4</strong> at <strong>pub_date4</strong>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        
	                        <div class="col-md-12">
	                            <h5 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Liked Listings</h5>
	                            <table class="table table-sm table-hover table-striped">
	                                <tbody>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 1</strong> published by <strong>Publisher1</strong> at <strong>pub_date1</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 2</strong> published by <strong>Publisher2</strong> at <strong>pub_date2</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 3</strong> published by <strong>Publisher3</strong> at <strong>pub_date3</strong>
	                                        </td>
	                                    </tr>                                    
	                                    <tr>
	                                        <td>
	                                            <strong>Listing Title 4</strong> published by <strong>Publisher4</strong> at <strong>pub_date4</strong>
	                                        </td>
	                                    </tr>
	                                </tbody>
	                            </table>
	                        </div>
	                        
						</div>
	               	</div>
	         	</div>
	       	</div>
	        <div class="col-lg-4 order-lg-1 text-center">
	            <img src="//placehold.it/150" class="mx-auto img-fluid img-circle d-block" alt="avatar">
	            <h6 class="mt-2">Upload a different photo</h6>
	            <label class="custom-file">
	                <input type="file" id="file" class="custom-file-input">
	                <span class="custom-file-control">Choose file</span>
	            </label>
	            <br>
	            <br>
	            <br>
	        	<h5>Email:</h5>
	        	<p>john@doe.com</p>
	        	<h5>Phone:</h5>
	        	<p>6900000011</p>
	        	<h6><a href="#">Curriculum Vitae</a></h6>
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