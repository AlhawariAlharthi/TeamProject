<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- Bootstrap core JavaScript-->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Page level plugin JavaScript-->
<script
	src="https://cdn.datatables.net/1.10.18/js/jquery.dataTables.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.18/js/dataTables.bootstrap4.min.js"></script>


<script
	src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>
<script
	src="https://editor.datatables.net/extensions/Editor/js/dataTables.editor.min.js"></script>

<script type="text/javascript" src="HRApp.js"></script>

<style type="text/css">
</style>

<title>Welcome back ${user}</title>
<link rel="stylesheet" href="homeStyle.css">
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
<body>


	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("index.html");
		}
	%>
	<div class="topnav">

		<a href="./Logout">Logout</a>
		<a href="./booklist.html">Explore</a> <a href="./index.html">Home</a>
		

	</div>


	<div class="jumbotron text-center">
		<h1>Student Lounge</h1>
		<p>Book Sharing</p>
		<form>
			<div class="input-group">
				<input type="text" class="form-control" size="50"
					placeholder="Search book" required>
				<div class="input-group-btn">
					<button type="button" class="btn btn-danger">Search</button>
				</div>
			</div>
		</form>
	</div>
	<div class="container" style="width: 90%;">
		<ul class="nav nav-tabs">
			<li><a data-toggle="tab" href="#menu2">Manage Books</a></li>
			<li><a data-toggle="tab" href="#menu1">Settings</a></li>
		</ul>

		<div class="tab-content">
			<div id="menu1" class="tab-pane fade">
				<h3>Change Password</h3>

				<div class="container">

					<form action="ChangePass" method="post">

						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="password"
								type="password" class="form-control" name="pass"
								placeholder="Password">
						</div>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input id="password"
								type="password" class="form-control" name="confirm"
								placeholder="Confirm Password">
						</div>
						<br>
						<div class="input-group">
							<input type="submit" value="Change Password">
						</div>
					</form>
				</div>

			</div>

			<div id="menu2" class="tab-pane fade">
				<h3>Books Table</h3>
				<p>Double click the remove button to remove any book.</p>

				<script>
					fetchBooks();
				</script>


				<a class="btn btn-primary btn-rounded btn-sm my-0"
					data-toggle="modal" data-target="#addBookModal"> Add Book </a> <br>
				<br>


				<!-- Modal -->
				<div class="modal fade" id="addBookModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Add Book</h4>
							</div>
							<div class="modal-body">

								<div
									style="padding-top: 50px; padding-right: 30px; padding-bottom: 50px; padding-left: 30px;">
									<form class="form-horizontal" action="AddBook" method="post">


										<div class="form-group">
											<label for="Fname">Author : </label> <input type="text"
												class="form-control" name="AUTHOR"> <br> <label
												for="Lname">Title : </label> <input type="text"
												class="form-control" name="TITLE"> <br> <label
												for="JobRole">ISBN : </label> <input type="text"
												class="form-control" name="ISBN"> <br> <label
												for="Age">Major : </label> <input type="text"
												class="form-control" name="MAJOR"> <br> <label
												for="Age">Book Class : </label> <input type="text"
												class="form-control" name="CLASS"> <br>

											<button type="submit">Add Book</button>
										</div>
									</form>

								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>

					</div>
				</div>

				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">Edit Book</h4>
							</div>
							<div class="modal-body">
								<div id="add_to_me"></div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>