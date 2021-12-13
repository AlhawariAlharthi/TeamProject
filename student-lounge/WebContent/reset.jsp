<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="homeStyle.css">
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Reset</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
.topnav {
  overflow: hidden;
  background-color: #000000;
}

.topnav a {
  float: right;
  padding: 50px;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  font-family: Montserrat, sans-serif;
}

.topnav a:hover {
  background-color: #FFFFFF;
  color: black;
  }
</style>
<body>

	<div class="topnav">
  <a href="./login.jsp">Login</a>
  <a href="./signup.jsp">Sign up</a>
  <a href="./booklist.html">Explore</a>
  <a href="./index.html">Home</a>
</div>

      <div class="main" style = " margin: auto; width: 50%; padding: 50px;  ">
         
            <div class="login-form">
            ${wronginput}
               <form action="Reset" method="post">
                  <div class="form-group">
                     <label>Email</label>
                     <input type="text" class="form-control" placeholder="Email" name="email" required>
                     
                  </div>
					<button type="submit" class="btn btn-primary" name ="login">Reset</button>
               </form>
            </div>
      </div>

</body>
</html>