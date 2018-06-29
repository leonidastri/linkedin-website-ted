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

    <title>User Messenger</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/start_page.css">

    <!-- Custom styles for this template -->
    <link href="css/user_messenger.css" rel="stylesheet">
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

    	<div class="container">
    
    		<div class="row">
	        	<div class="col-lg-12">
	            	<div class="tab-content py-4">
	                	<div class="tab-pane active" id="profile">
	                    	<div class="row">
	                    
	                    		<div class="col-sm">
	                            	<h3 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> Your chats with other users </h3>

									<c:if test="${chattingUsers.size() != 0}">
			
										<table class="table table-sm table-hover table-striped">
									     	<c:forEach var="i" begin="0" end="${chattingUsers.size()-1}" step="1">
			     								<tr>
			     									<td>
												     	<img src="${chattingUsers.get(i).getPhotoPath()}" class="mx-auto img-fluid img-circle d-block" alt="avatar">
												    </td>
		       										<td>
		       											${chattingUsers.get(i).getFirstName()}
		       										</td>
		       										<td>
		       											${chattingUsers.get(i).getLastName()}
		       										</td>
		       										<td>
		       											<a class="btn btn-primary" role="button" href="UserMessenger?receiverID=${chattingUsers.get(i).getUserID()}">Chat</a>
		       										</td>
		       									</tr>
											</c:forEach>
										</table>
				
									</c:if>
									<c:if test="${chattingUsers.size() == 0}">
										<p> No chats yet <p>
									</c:if>
									
								</div>
							
								<br>
								<div class="col-sm">
		                    
		                    		<div class="col-md-12">
		                            	<h3 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span>Your chats with connected users</h3>
													
											<c:if test="${networkUsers.size() != 0}">
											
												<table class="table table-sm table-hover table-striped">
											     	<c:forEach var="i" begin="0" end="${networkUsers.size()-1}" step="1">
											     		<tr>
										       				<td>
												     			<img src="${networkUsers.get(i).getPhotoPath()}" class="mx-auto img-fluid img-circle d-block" alt="avatar">
												     		</td>
										       				<td>
		       													${networkUsers.get(i).getFirstName()}
		       												</td>
		       												<td>
		       													${networkUsers.get(i).getLastName()}
		       												</td>
												     		<td>
										       					<a class="btn btn-primary" role="button" href="UserMessenger?receiverID=${networkUsers.get(i).getUserID()}">Chat</a>
										       				</td>
										       			</tr>
													</c:forEach>
												</table>
												
											</c:if>
											<c:if test="${networkUsers.size() == 0}">
												<p>No connected users yet</p>
											</c:if>	
									</div>
								</div>
							</div>						
						</div>
					</div>
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