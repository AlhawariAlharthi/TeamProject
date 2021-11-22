<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
body {
	font-family: "Lato", sans-serif;
}

.main-head {
	height: 150px;
	background: #FFF;
}

.sidenav {
	height: 100%;
	background-color: #000;
	overflow-x: hidden;
	padding-top: 20px;
}

.main {
	padding: 0px 10px;
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
}

@media screen and (max-width: 450px) {
	.login-form {
		margin-top: 10%;
	}
	.register-form {
		margin-top: 10%;
	}
}

@media screen and (min-width: 768px) {
	.main {
		margin-left: 40%;
	}
	.sidenav {
		width: 40%;
		position: fixed;
		z-index: 1;
		top: 0;
		left: 0;
	}
	.login-form {
		margin-top: 80%;
	}
	.register-form {
		margin-top: 20%;
	}
}

.login-main-text {
	margin-top: 20%;
	padding: 60px;
	color: #fff;
}

.login-main-text h2 {
	font-weight: 300;
}

.btn-black {
	background-color: #000 !important;
	color: #fff;
}

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
		<a href="./login.html">Log in</a>
		<a href="./booklist.html">Explore</a> <a href="./index.html">Home</a>
	</div>

	<div class="sidenav">
		<div class="login-main-text">
			<h2>Sign up Page</h2>
			<p>Enter your information to create new account</p>
		</div>
	</div>
	<div class="main">
		<div class="col-md-6 col-sm-12">
			<div class="login-form">
				<form action="Signup" method="post">
				${wronginput}
					<div class="form-group">
						<label>Email</label> <input type="text" class="form-control"
							placeholder="Email" name="email">
					</div>
					<div class="form-group">
						<label>User Name</label> <input type="text" class="form-control"
							placeholder="User Name" name="username">
					</div>
					<div class="form-group">
						<label>First Name</label> <input type="text" class="form-control"
							placeholder="First Nmae" name="firtsname">
					</div>
					<div class="form-group">
						<label>Last Name</label> <input type="text" class="form-control"
							placeholder="Last Name" name="lastname">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="password">
					</div>
					<div class="form-group">
						<label>Confirm Password</label> <input type="password"
							class="form-control" placeholder="Re-enter your password"
							name="repassword">
					</div>

					<a class="btn btn-secondary" href="login.jsp">Log in</a>
					<button type="submit" class="btn btn-black" name="signup">Sign
						Up</button>

				</form>
			</div>
		</div>
	</div>

</body>
</html>