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

    <title>Listings</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_listings.css" rel="stylesheet">
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

	<br>
	
	<div class="pricing-header px-4 py-4 pt-md-4 pb-md-4 mx-auto text-center">
      <a class="btn btn-primary" href="UserListings?action=UserListingsPersonal" role="button">Add a listing or check applications to your current listings</a>
    </div>

	<br>
	
	<div class="container">
		 <div align="center">
	                    
	     	<h5><span class="fa fa-clock-o ion-clock float-right"></span> Listings from connected users </h5>
	     	
	     	<table class="table table-sm table-hover table-striped">
	         	<tbody>
	            	 <c:if test="${recommendedConnectedUsersListings.size() != 0}">
							<c:forEach var="i" begin="0" end="${recommendedConnectedUsersListings.size()-1}" step="1">
								<tr>
			                    	<td>
			                        	<strong>${recommendedConnectedUsersListings.get(i).getTitle()}</strong> published by <strong>${recommendedConnectedUsersListings.get(i).getUser().getFirstName()} ${recommendedConnectedUsersListings.get(i).getUser().getLastName() }</strong> at <strong><fmt:formatDate value="${recommendedConnectedUsersListings.get(i).getPubDate()}"/></strong>
			                      	</td>
			                     	<td>
			                           	<p> ${recommendedConnectedUsersListings.get(i).getDescription()}</p>
			                      	</td>
			                       	<td>
			                     		<c:if test="${ conApplied.get(i) eq false }">
			                              	<form action="UserListings" method="get">
												<button type="submit" id="listingApply" name="listingApply" value="true">Apply</button>
												<input type="hidden" name="listingID" value="${recommendedConnectedUsersListings.get(i).getListingID()}">
  												<input type="hidden" name="action" value="ListingApplication">
  											</form>
  										</c:if>
  										
  										<c:if test="${ conApplied.get(i) eq true }">
  											<strong> Applied already! </strong>
  										</c:if>
			                        </td>
			                    </tr>
		                    </c:forEach>
					</c:if>
					
					<c:if test="${recommendedConnectedUsersListings.size() == 0}">
						<tr>
							<td>
								<p>No listings yet </p>
							</td>
						</tr>
					</c:if>
	        	</tbody>
	   		</table>
		</div>

		<br> <br>
							
		<div align="center">
	    	
	    	<h5><span class="fa fa-clock-o ion-clock float-right"></span> Listings from not connected users </h5>
	        <table class="table table-sm table-hover table-striped">
	         	<tbody>
	         	
	            	<c:if test="${recommendedNotConnectedUsersListings.size() != 0}">
						<c:forEach var="i" begin="0" end="${recommendedNotConnectedUsersListings.size()-1}" step="1">
							<tr>
			              		<td>
			                    	<strong>${recommendedNotConnectedUsersListings.get(i).getTitle()}</strong> published by <strong>${recommendedNotConnectedUsersListings.get(i).getUser().getFirstName()} ${recommendedNotConnectedUsersListings.get(i).getUser().getLastName() }</strong> at <strong><fmt:formatDate value="${recommendedNotConnectedUsersListings.get(i).getPubDate()}"/></strong>
			                 	</td>
			                  	<td>
			                   		<p> ${recommendedNotConnectedUsersListings.get(i).getDescription()}</p>
				                </td>
				              	<td>
			                     	<c:if test="${ notConApplied.get(i) eq false }">
			                        	<form action="UserListings" method="get">
											<button type="submit" id="listingApply" name="listingApply" value="true">Apply</button>
											<input type="hidden" name="listingID" value="${recommendedNotConnectedUsersListings.get(i).getListingID()}">
  											<input type="hidden" name="action" value="ListingApplication">
  										</form>
  									</c:if>
  									<c:if test="${ notConApplied.get(i) eq true }">
  										<strong> Applied already! </strong>
  									</c:if>
			             		</td>
			          		</tr>
		        		 </c:forEach>
					</c:if>
										
					<c:if test="${recommendedNotConnectedUsersListings.size() == 0}">
						<tr>
							<td>
								<p>No listings yet </p>
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
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