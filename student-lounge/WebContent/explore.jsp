<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<head>

<title>Bootstrap Theme Company Page</title>
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
<link rel="stylesheet" href="homeStyle.css">
<script type="text/javascript" src="app.js"></script>

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

.card-horizontal {
	display: flex;
	flex: 1 1 auto;
}

img.bookimg {
	hight: 300px;
	width: 150px;
	margin-right: 5px;
}

.column {
	float: left;
	width: 50%;
	padding: 0 10px;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}

.row {
	width: 90%;
	margin: auto;
	margin-bottom: 20px;
}

.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 10px;
	border: 3px solid;
	border-radius: 5px;
	background-color: #f1f1f1;
}
</style>
</head>
<body id="top" data-spy="scroll" data-target=".navbar" data-offset="60">

	<div class="topnav">
		<a href="./login.jsp">Log in</a> <a href="./signup.jsp">Sign up</a> <a
			href="./booklist.html">Explore</a> <a href="./index.html">Home</a>
	</div>


	<div class="jumbotron text-center">
		<h1>Student Lounge</h1>
		<p>Book Sharing</p>
		<form style="width: 75%; display: inline-block;" action="Search">
			<div class="input-group">
				<input type="text" class="form-control" size="50" name="search"
					placeholder="Search book" id="keyword">
				<div class="input-group-btn">
					<button type="submit" class="btn btn-danger" >Search</button>
				</div>
			</div>
		</form>
	</div>

	<div id="allbooks"></div>
	<script>
		getAllBooks( ${books} );
	</script>
	

	<footer class="container-fluid text-center">
		<a href="#top" title="To Top"> <span
			class="glyphicon glyphicon-chevron-up"></span>
		</a>
	</footer>

	<script>
		$(document).ready(
				function() {
					// Add smooth scrolling to all links in navbar + footer link
					$(".navbar a, footer a[href='#myPage']").on('click',
							function(event) {
								// Make sure this.hash has a value before overriding default behavior
								if (this.hash !== "") {
									// Prevent default anchor click behavior
									event.preventDefault();

									// Store hash
									var hash = this.hash;

									// Using jQuery's animate() method to add smooth page scroll
									// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
									$('html, body').animate({
										scrollTop : $(hash).offset().top
									}, 900, function() {

										// Add hash (#) to URL when done scrolling (default click behavior)
										window.location.hash = hash;
									});
								} // End if
							});

					$(window).scroll(function() {
						$(".slideanim").each(function() {
							var pos = $(this).offset().top;

							var winTop = $(window).scrollTop();
							if (pos < winTop + 600) {
								$(this).addClass("slide");
							}
						});
					});
				})
	</script>
</body>
</html>