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

    <title>Show All Users</title>

    <!-- Bootstrap core CSS -->
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  	<link rel="stylesheet" href="./css/admin_management.css">

    <!-- Custom styles for this template -->
    <link href="css/admin_management.css" rel="stylesheet">
</head>

<body>

	<!-- NAVBAR -->
    <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h3 class="my-0 mr-md-auto font-weight-normal">LinkedIn</h3>
      	<nav class="my-2 my-md-0 mr-md-3">
        	<a class="p-2 text-dark" href="admin_homepage.jsp">Home-page</a>
      	</nav>
      	<a class="btn btn-outline-primary" href="UserLogout">Sign out</a>
    </div>

	<!--  MANAGEMENT PAGE BODY -->
 
	<div align="center">
    	<div class="container">
    
    		<div class="row">
	        	<div class="col-lg-8 order-lg-2">
	            	<div class="tab-content py-4">
	                	<div class="tab-pane active" id="profile">
	                    	<div class="row">
	                    
	                    		<div class="col-md-12">
	                            	<h3 class="mt-2"><span class="fa fa-clock-o ion-clock float-right"></span> List of Users </h3>
	                            	
	                            	<form id="a_form" action="AdminShowAllUsers?pageNumber=${currentPage}" method="POST">
	                            	
	                            		<table class="table table-sm table-hover table-striped">	
	                            			<tbody>
												<c:if test="${users.size() != 0}">
													<c:forEach var="i" begin="0" end="${users.size()-1}" step="1">
												     	<tr>
												     		<td>
												     			<img src="${users.get(i).getPhotoPath()}" class="mx-auto img-fluid img-circle d-block" alt="avatar">
												     		</td>
												        	<td> 
												        		<a href="UserProfile?action=OtherUserProfile&email=${users.get(i).getEmail()}">${users.get(i).getEmail()}</a>
												        	</td>
												        	<td>
												        		${users.get(i).getFirstName()}
												        	</td>
												        	<td> 
												        		${users.get(i).getLastName()}
												        	</td>
												         	<td>
												            	<input type="checkbox" id="box" name="checkList" value="${users.get(i).getEmail()}" <c:if test="${tempChecked.get(i) == true}"> checked="checked"</c:if> > 
												         		<input type="hidden" id="hidden_box" name="checkList" value="false" />
												         	</td>
												        </tr>
													</c:forEach>
										        </c:if>
											</tbody>
										</table>
										
										<%@ include file="./pagination.jsp" %>
										<c:if test="${users.size() == 0 and not empty previousPage}">
										    <div class="row">
										    	Last page. <a href="${previousPage}">Previous page</a>
											</div>
										</c:if>
										
										<br> <br> 
										<button type="submit" class="btn btn btn-outline-success my-2 my-sm-0"> Save Choices </button>
									</form>
								</div>
	                        </div>
	                    </div>
	               	</div>
	         	</div>
	       	</div>
		</div>
		
		<form id="a_form2" action="GetUsersXML" method="GET">
			<button type="submit" class="btn btn btn-outline-success my-2 my-sm-0"> Export Users </button>
		</form>

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
