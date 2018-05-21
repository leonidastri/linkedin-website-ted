<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="icon" href="../images/toplogo.png">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>LinkedIn Clone</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  <link rel="stylesheet" href="./css/start_page.css">

</head>
<body>

  <!-- NAVBAR -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="col-md-2">
      <a class="navbar-brand" href="#">LinkedIn Clone</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
    <div class="col-md-8">
      <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <form class="form-inline my-2 my-lg-0" action="UserLogin" method="post" id="loginForm">
          <input class="form-control mr-sm-2" id="email" name="email"
              placeholder="Email Address" type="email"
              validatorMessage="Maximum length is 100 characters"
              required="true" requiredMessage="Please insert an email address" >
          <input class="form-control mr-sm-2" id="password" name="password"
              placeholder="Password" type="password"
              validatorMessage="Maximum length is 30 characters"
              required="true" requiredMessage="Please insert a password" >
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log-in</button>
        </form>
      </div>
    </div>
  </nav>

  <!-- REGISTER -->
  <div class="bgimg">
    <br> <br> <br>
    <div align="center" class ="register-container">
      <form class="form-signin" action="UserRegister" method="post" id="registerForm">
        <h3> Get started - it's free. </h3>
        <hr>
          <div class="form-group">
            <label> <input class="form-control" id="email" name="email"
              placeholder="Email Address" type="email"
              validatorMessage="Maximum length is 100 characters"
              required="true" requiredMessage="Please insert an email address">
            </label>
          </div>
          <div class="form-group">
            <label> <input class="form-control" id="password" name="password"
              placeholder="Password" type="password"
              validatorMessage="Maximum length is 30 characters"
              required="true" requiredMessage="Please insert a password">
            </label>
          </div>
          <div class="form-group">
            <label> <input class="form-control" id="confirmPassword" name="confirmPassword"
              placeholder="Confirm Password" type="password"
              validatorMessage="Maximum length is 30 characters"
              required="true" requiredMessage="Please confirm a password">
            </label>
          </div>
          <div class="form-group">
            <label> <input class="form-control" id="firstName" name="firstName"
              placeholder="First Name" type="text"
              validatorMessage="Maximum length is 60 characters"
              required="true" requiredMessage="Please insert a first name">
            </label>
          </div>
          <div class="form-group">
            <label> <input class="form-control" id="lastName" name="lastName"
              placeholder="Last Name" type="text"
              validatorMessage="Maximum length is 60 characters"
              required="true" requiredMessage="Please insert a last name">
            </label>
          </div>
          <div class="form-group">
            <label> <input class="form-control" id="phoneNumber" name="phoneNumber"
              placeholder="Phone Number" type="tel"
              validatorMessage="Maximum length is 30 characters"
              required="true" requiredMessage="Please insert a phone number">
            </label>
          </div>

          <button type="submit" class="btn btn btn-outline-success my-2 my-sm-0">Join now</button>
      </form>
    </div>
    <br> <br> <br> <br> <br> <br>
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
